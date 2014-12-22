package com.coupang.beanfactory;

import java.lang.reflect.*;
import java.util.*;

public class SingletonBeanFactory implements BeanFactory{
	private Map<BeanDefinition, Object> beans= new HashMap<BeanDefinition, Object>();
	
	@Override
	public void addNewBean(BeanDefinition beanDefinition){
		try {
			Class<?> forName = Class.forName(beanDefinition.getClassFullName());
			beans.put(beanDefinition, forName.newInstance());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}; 
	
	public <T> T getInstance(Class<T> type) {
		for( BeanDefinition key : beans.keySet() ){
			try {
				Class<?> forName = Class.forName(key.getClassFullName());
				if(forName.equals(type)){
					return (T) beans.get(key);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return null;
	}
	public Object getInstance(String beanName) {
		for( BeanDefinition key : beans.keySet() ){
			if(key.getBeanName().equals(beanName)){
				return beans.get(key);
			} 
        }
		return null;
	}
}
