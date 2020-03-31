
package com.springwebmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontControllerConfig extends AbstractAnnotationConfigDispatcherServletInitializer
{

	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebMvcConfig.class};
		//return null;
	}

	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
		//return new Class[] {WebMvcConfig.class};
	}

	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	

}
