package com.coupang.beanfactory;

import java.io.*;
import java.util.*;

public class PropertyFileBeanDefinitionLoader extends BeanDefinitionLoader {
	
	public PropertyFileBeanDefinitionLoader(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BeanDefinition> beanDifinitionFileLoaders(InputStream inputStream){
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		List<BeanDefinition> addDefinitions = new ArrayList<BeanDefinition>();
		List<String> lines = new ArrayList<String>();

		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(lines != null){
			for(String line : lines){
				String[] parsed = line.split("=");
				String[] scoped = parsed[1].split(":");
				addDefinitions.add(new BeanDefinition(parsed[0], scoped[1], scoped[0]));
			}
		}
		return addDefinitions;
		
	}
}
