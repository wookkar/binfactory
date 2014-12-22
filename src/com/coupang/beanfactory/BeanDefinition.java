package com.coupang.beanfactory;

public class BeanDefinition {
	private String beanName;
	private String classFullName;
	private Scope scope = Scope.SINGLETON;

	public BeanDefinition(String beanName, String classFullName){
		this.beanName = beanName;
		this.classFullName = classFullName;
	}
	
	public BeanDefinition(String beanName, String classFullName, String scope){
		this(beanName, classFullName);
		if("SINGLETON".equals(scope))
			this.scope = Scope.SINGLETON;
		else	if("PROTOTYPE".equals(scope))
			this.scope = Scope.PROTOTYPE;
	}
	
	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getClassFullName() {
		return classFullName;
	}

	public void setClassFullName(String classFullName) {
		this.classFullName = classFullName;
	}
}
