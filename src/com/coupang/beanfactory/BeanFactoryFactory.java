package com.coupang.beanfactory;

public class BeanFactoryFactory {
	public BeanFactory makeBeanFactory(Scope scope){
		if(scope == Scope.SINGLETON){
			return new SingletonBeanFactory();
		}
		else if(scope == Scope.PROTOTYPE){
			return new PrototypeBeanFactory();
		}
		return null;
	}
}
