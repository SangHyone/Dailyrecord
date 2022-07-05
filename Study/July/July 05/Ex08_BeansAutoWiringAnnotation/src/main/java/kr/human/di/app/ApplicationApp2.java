package kr.human.di.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.human.di.config.AppConfig;
import kr.human.di.vo.Application;
import kr.human.di.vo.Driver;

public class ApplicationApp2 {
	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Application application = context.getBean("application",Application.class);
		System.out.println(application);
		
		Driver driver = context.getBean("driver",Driver.class);
		System.out.println(driver);
		
		context.close();
	}
}
