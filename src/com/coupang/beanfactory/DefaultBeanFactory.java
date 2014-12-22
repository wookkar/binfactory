package com.coupang.beanfactory;

import java.util.*;

public class DefaultBeanFactory  implements BeanFactory{
	private final Object object = new Object();
	private Map<Scope, BeanFactory> beanFactories = new HashMap<Scope, BeanFactory>();
	private BeanFactoryFactory beanFactoryFactory = new BeanFactoryFactory();
	
	public DefaultBeanFactory(List<BeanDefinition> beanDefinitions){
		for(BeanDefinition beanDefinition : beanDefinitions){
			this.addNewBean(beanDefinition);
		}
	}
	
	private BeanFactory createBeanFactory(Scope scope){
		return beanFactoryFactory.makeBeanFactory(scope);
	}

	@Override
	public void addNewBean(BeanDefinition beanDefinition) {
		// TODO Auto-generated method stub
		synchronized (object){
			if(!this.beanFactories.containsKey(beanDefinition.getScope())){
				this.beanFactories.put(beanDefinition.getScope(), createBeanFactory(beanDefinition.getScope()));
			}
			beanFactories.get(beanDefinition.getScope()).addNewBean(beanDefinition);
		}
	}

	@Override
	public <T> T getInstance(Class<T> type) {
		// TODO Auto-generated method stub
		for( Scope key : beanFactories.keySet() ){
			T instance = beanFactories.get( key).getInstance(type);
			if (instance != null) {
				return instance;
			}
		}
		return null;
	}

	@Override
	public Object getInstance(String beanName) {
		// TODO Auto-generated method stub
		for( Scope key : beanFactories.keySet() ){
			Object instance = beanFactories.get( key).getInstance(beanName);
			if (instance != null) {
				return instance;
			}
		}
		return null;
	}
}
