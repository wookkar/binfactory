package com.coupang.beanfactory;

import java.io.*;
import java.util.*;

public abstract class BeanDefinitionLoader {
	private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
	private final Object object = new Object();
	
	public BeanDefinitionLoader(String filePath) {
		beanDifinitionFileLoaders(filePath);
	}
	
	public List<BeanDefinition> getBeanDefinitions() {
		return beanDefinitions;
	}

	public void beanDifinitionFileLoaders(String filePath){
		InputStream inputStream = this.getClass().getResourceAsStream(filePath);
		List<BeanDefinition> addDefinitions = beanDifinitionFileLoaders(inputStream);
		synchronized(object){
			for(BeanDefinition addDefinition : addDefinitions){
				if(!isExist(beanDefinitions, addDefinition)) {
					beanDefinitions.add(addDefinition);
				}
			}	
		}
	}
	
	public boolean isExist(List<BeanDefinition> beanDefinitions, BeanDefinition addDefinition){
		for(BeanDefinition beanDefinition : beanDefinitions){
			if(beanDefinition.getBeanName().equals(addDefinition.getBeanName())){
				return true;	
			}
		}	
		return false;
	}
	
	public abstract List<BeanDefinition> beanDifinitionFileLoaders(InputStream inputStream);
}
