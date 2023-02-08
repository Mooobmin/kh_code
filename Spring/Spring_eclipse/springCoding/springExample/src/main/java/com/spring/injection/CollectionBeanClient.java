package com.spring.injection;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		
		Properties addressList = bean.getAddressList();
		System.out.println(addressList.getProperty("홍길동"));
		System.out.println(addressList.getProperty("김철수"));
		
		//Map<String, String> addressList = bean.getAddressList();
		//List <String> addressList = bean.getAddressList();
		//Set <String> addressList = bean.getAddressList();
		
		/*for(Map.Entry<String, String> addList : addressList.entrySet()){
			String key = addList.getKey();
			String value = addList.getValue();
			System.out.println("key = " + key + ", value = " + value);
		}*/
		
		/*		for(String address : addressList) {
			System.out.println(address.toString());
		}*/
		
		factory.close();
	}

}
