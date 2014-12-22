package com.coupang.beanfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class PrototypeBeanFactory implements BeanFactory{
	private List<BeanDefinition> beanDefinitions= new ArrayList<BeanDefinition>();
	@Override
	public void addNewBean(BeanDefinition beanDefinition) {
		// TODO Auto-generated method stub
		beanDefinitions.add(beanDefinition);
	}

	@Override
	public <T> T getInstance(Class<T> type) {
		// TODO Auto-generated method stub
		for( BeanDefinition beanDefinition : beanDefinitions ){
			try {
				Class<?> forName = Class.forName(beanDefinition.getClassFullName());
				if(forName.equals(type)){
					Constructor<?> declaredConstructor = forName.getDeclaredConstructor();
					declaredConstructor.setAccessible(true);
					return (T) declaredConstructor.newInstance();
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Object getInstance(String beanName) {
		// TODO Auto-generated method stub
		for( BeanDefinition beanDefinition : beanDefinitions ){
			try {
				if(beanDefinition.getBeanName().equals(beanName)){
					Class<?> forName = Class.forName(beanDefinition.getClassFullName());
					Constructor<?> declaredConstructor = forName.getDeclaredConstructor();
					declaredConstructor.setAccessible(true);
					return declaredConstructor.newInstance();
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
