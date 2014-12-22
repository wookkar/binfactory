package com.coupang;
import com.coupang.beanfactory.*;
import com.coupang.beans.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String configurationPath = "/com/coupang/c4/step16/";
		
		BeanDefinitionLoader beanDefinitionLoader = new  XmlFileBeanDefinitionLoader("/com/coupang/bean-definitions.xml");
		//BeanDefinitionLoader beanDefinitionLoader = new  PropertyFileBeanDefinitionLoader("/com/coupang/bean-definitions.properties");
		BeanFactory beanFactory = new DefaultBeanFactory(beanDefinitionLoader.getBeanDefinitions());
		
		Sample1 instance = beanFactory.getInstance(Sample1.class);
		System.out.println(instance != null);
		Sample1 instance1 = (Sample1)beanFactory.getInstance("sample1");
		System.out.println(instance1 != null);
		System.out.println(instance1 == instance);
		
		/*
		DefaultBeanFactory defaultBeanFactory = DefaultBeanFactory.createScopedBeanBeanFactory(
				configurationPath + "bean-definitions.properties",
				configurationPath + "bean-definitions2.xml");
		
		Sample1 instance = defaultBeanFactory.getInstance(Sample1.class);
		System.out.println(instance != null);
		
		Object instance2 = defaultBeanFactory.getInstance("sample2");
		System.out.println(instance2 != null);
		System.out.println(Sample2.class.isAssignableFrom(instance2.getClass()));
		System.out.println(instance2 instanceof Sample2);
		*/
	}

}
