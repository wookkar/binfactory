package com.coupang.beanfactory;

import java.util.*;

public interface BeanFactory {
	public void addNewBean(BeanDefinition beanDefinition); 
	public <T> T getInstance(Class<T> type);
	public Object getInstance(String beanName);
}
