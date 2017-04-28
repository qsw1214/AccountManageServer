package base.cn.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

public class InitializedApplicationContext implements ApplicationContextAware,InitializingBean{

	private WebApplicationContext applicationContext; 
	
	@Override
	public void afterPropertiesSet() throws Exception {
		/**
		 * 装载WebApplicationContext 到AppContextManager
		 */
		WebApplicationContext wac = applicationContext;
		AppContextManager appManager = AppContextManager.instance();
		appManager.setWebApplicationContext(wac);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = (WebApplicationContext) applicationContext;
		
	}

}
