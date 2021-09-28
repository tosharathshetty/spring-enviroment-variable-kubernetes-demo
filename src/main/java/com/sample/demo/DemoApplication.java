package com.sample.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
// import org.springframework.core.env.PropertySource;

@SpringBootApplication
@PropertySource(value =  "classpath:jdbc.properties",ignoreResourceNotFound=true)
@PropertySource(value = "classpath:wsdl.properties",ignoreResourceNotFound=true)

// public class DemoApplication extends SpringBootServletInitializer {

// @PropertySource("classpath:application-${spring.profiles.active}.properties")


	public class DemoApplication  {

		@Autowired
		private Environment enviroment;
		public static void main(String[] args) {
			
			// AnnotationConfigApplicationContext context =
			// new AnnotationConfigApplicationContext();
			// ConfigurableEnvironment env = context.getEnvironment();
			// printSources(env);
			// System.out.println("-- System properties --");
			// printMap(env.getSystemProperties());
			// System.out.println("-- System Env properties --");
			// printMap(env.getSystemEnvironment());
			// context.close();	
			


			SpringApplication.run(DemoApplication.class, args);
	}

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	// 	return application.sources(DemoApplication.class);
	// }

	private static void printSources (ConfigurableEnvironment env) {
		System.out.println("-- property sources --");
		for (org.springframework.core.env.PropertySource<?> propertySource : env.getPropertySources()) {
			System.out.println("name =  " + propertySource.getName() + "\nsource = " + propertySource
								.getSource().getClass()+"\n");
		}
	}
  
	private static void printMap (Map<?, ?> map) {
		map.entrySet()
		   .stream().limit(15)
		   .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
		System.out.println("-------------");
  
	}

}
