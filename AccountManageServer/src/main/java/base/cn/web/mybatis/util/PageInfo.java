package base.cn.web.mybatis.util;

import java.util.ArrayList;
import java.util.List;

import com.accountmanage.util.Constants;

public class PageInfo<Entity> {

	List<Entity> list=new ArrayList<Entity>();

	private Integer pageIndex;// 当前页

	private Integer totalpage;// 总页数

	private Integer recordCount;// 总数量
	
	private Integer beginIndex;//开始行数

	private Integer endIndex;//结束行数
	
	private Integer pageSize;//每页记录数量
	
	public PageInfo(){
		this.pageSize = Constants.PAGE_SIZE;
	}
	
	public PageInfo(int pageIndex){
		this.pageIndex = pageIndex;
		this.pageSize = Constants.PAGE_SIZE;
	}
	
	public PageInfo(int beginIndex,int pageSize) {
		this.beginIndex = beginIndex;
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void computeBeginIndex() {
		this.beginIndex = (pageIndex - 1) * pageSize;
		this.setBeginIndex(beginIndex);
	}

	public void computeEndIndex() {
		this.endIndex = 0;
		if(pageIndex==totalpage)
		{
			if(recordCount==pageSize)
			{
				endIndex=beginIndex+pageSize;
			}else{
				if(recordCount % pageSize==0)
				{
					endIndex=beginIndex+pageSize;
				}else{
					endIndex=beginIndex+(recordCount % pageSize);
				}
			}
		}else{
			if(totalpage!=0)
			{
				endIndex=beginIndex+pageSize;
			}
		}
		this.setEndIndex(endIndex);
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void computeTotalpage() {
		this.totalpage=recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;
		this.setTotalpage(totalpage);
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public List<Entity> getList() {
		return list;
	}

	public void setList(List<Entity> list) {
		this.list = list;
	}

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	
}
