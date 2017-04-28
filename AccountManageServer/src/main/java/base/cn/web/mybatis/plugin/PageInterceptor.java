package base.cn.web.mybatis.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;  
import org.apache.ibatis.executor.resultset.ResultSetHandler;  
import org.apache.ibatis.executor.statement.StatementHandler;  
import org.apache.ibatis.mapping.BoundSql;  
import org.apache.ibatis.mapping.MappedStatement;  
import org.apache.ibatis.plugin.*;  
import org.apache.ibatis.reflection.MetaObject;  
import org.apache.ibatis.reflection.SystemMetaObject;  
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;  
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;  
  





import base.cn.web.mybatis.util.PageInfo;

import java.sql.*;  
import java.util.List;  
import java.util.Properties;

/** 
 * Mybatis - 通用分页拦截器 
 * @author xyUser
 *  
 */
@SuppressWarnings("rawtypes")
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class}),  
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})})
public class PageInterceptor implements Interceptor{
	
	private static final Logger logger = Logger.getLogger(PageInterceptor.class); 
	  
    public static final ThreadLocal<PageInfo> localPage = new ThreadLocal<PageInfo>();  
  
    /** 
     * 开始分页 
     * @param pageNum 
     * @param pageSize 
     */  
    public static void startPage(int pageNum, int pageSize) {  
        localPage.set(new PageInfo(pageNum, pageSize));  
    }  
    
    /** 
     * 开始分页 
     * @param pageNum 
     * @param pageSize 
     */  
    public static void startPage(int pageNum) {  
        localPage.set(new PageInfo(pageNum));  
    }  
  
    /** 
     * 结束分页并返回结果，该方法必须被调用，否则localPage会一直保存下去，直到下一次startPage 
     * @return 
     */  
	public static PageInfo endPage() {  
        PageInfo page = localPage.get();  
        localPage.remove();  
        return page;  
    }  

	@SuppressWarnings("unchecked")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (localPage.get() == null) {  
            return invocation.proceed();  
        }  
        if (invocation.getTarget() instanceof StatementHandler) {  
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();  
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);  
            // 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环  
            // 可以分离出最原始的的目标类)  
            while (metaStatementHandler.hasGetter("h")) {  
                Object object = metaStatementHandler.getValue("h");  
                metaStatementHandler = SystemMetaObject.forObject(object);  
            }  
            // 分离最后一个代理对象的目标类  
            while (metaStatementHandler.hasGetter("target")) {  
                Object object = metaStatementHandler.getValue("target");  
                metaStatementHandler = SystemMetaObject.forObject(object);  
            }  
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");  
            //分页信息if (localPage.get() != null) {  
            PageInfo page = localPage.get();  
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");  
            // 分页参数作为参数对象parameterObject的一个属性  
            String sql = boundSql.getSql();  
            // 重写sql  
            String pageSql = buildPageSqlForMysql(sql, page);  
            //重写分页sql  
            metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
         // 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数  
            metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET); 
            metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
            Connection connection = (Connection) invocation.getArgs()[0];  
            // 重设分页参数里的总页数等  
            setPageParameter(sql, connection, mappedStatement, boundSql, page);  
            // 将执行权交给下一个拦截器  
            return invocation.proceed();  
        } else if (invocation.getTarget() instanceof ResultSetHandler) {  
            Object result = invocation.proceed();  
            PageInfo page = localPage.get();  
            page.setList((List) result);  
            return result;  
        }  
        return null;  
	}

	/** 
     * 只拦截这两种类型的 
     * <br>StatementHandler 
     * <br>ResultSetHandler 
     * @param target 
     * @return 
     */  
    @Override  
    public Object plugin(Object target) {  
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {  
            return Plugin.wrap(target, this);  
        } else {  
            return target;  
        }  
    }  

	@Override
	public void setProperties(Properties arg0) {
		
		
	}
	
	/** 
     * 修改原SQL为分页SQL-适用于mysql
     * @param sql 
     * @param page 
     * @return 
     */  
	public String buildPageSqlForMysql(String sql, PageInfo page) {  
	    StringBuilder pageSql = new StringBuilder();  
	    String beginrow = String.valueOf((page.getPageIndex() - 1) * page.getPageSize());  
	    pageSql.append(sql);  
	    pageSql.append(" limit " + beginrow + "," + page.getPageSize());  
	    return pageSql.toString();  
	}
	
	/** 
     * 修改原SQL为分页SQL-适用于oracle
     * @param sql 
     * @param page 
     * @return 
     */  
	public String buildPageSqlForOracle(String sql, PageInfo page) {  
	    StringBuilder pageSql = new StringBuilder(100);  
	    page.computeBeginIndex();
	    page.computeEndIndex();
	    String beginrow = String.valueOf(page.getBeginIndex());  
	    String endrow = String.valueOf(page.getEndIndex());  
	    pageSql.append("select * from ( select temp.*, rownum row_id from ( ");  
	    pageSql.append(sql);  
	    pageSql.append(" ) temp where rownum <= ").append(endrow);  
	    pageSql.append(") where row_id > ").append(beginrow);  
	    return pageSql.toString();  
	}
	
	/** 
     * 获取总记录数 
     * @param sql 
     * @param connection 
     * @param mappedStatement 
     * @param boundSql 
     * @param page 
     */  
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,  
                                  BoundSql boundSql, PageInfo page) {  
        // 记录总记录数  
        String countSql = "select count(0) from (" + sql.replace("*", "1") + ") temp";  
        PreparedStatement countStmt = null;  
        ResultSet rs = null;  
        try {  
            countStmt = connection.prepareStatement(countSql);  
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,  
                    boundSql.getParameterMappings(), boundSql.getParameterObject());  
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());  
            rs = countStmt.executeQuery();  
            int totalCount = 0;  
            if (rs.next()) {  
                totalCount = rs.getInt(1);  
            }  
            page.setRecordCount(totalCount);  
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);  
            page.setTotalpage(totalPage);  
        } catch (SQLException e) {  
            logger.error("Ignore this exception", e);  
        } finally {  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                logger.error("Ignore this exception", e);  
            }  
            try {  
                countStmt.close();  
            } catch (SQLException e) {  
                logger.error("Ignore this exception", e);  
            }  
        }  
    }  
    
    /** 
     * 代入参数值 
     * @param ps 
     * @param mappedStatement 
     * @param boundSql 
     * @param parameterObject 
     * @throws SQLException 
     */  
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,  
                               Object parameterObject) throws SQLException {  
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);  
        parameterHandler.setParameters(ps);  
    }  
  
   

}
