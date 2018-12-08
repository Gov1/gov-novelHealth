package com.dotridge.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageResourceLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MessageSource ms=new ClassPathXmlApplicationContext("file:./src/main/resources/applicationContext.xml");
		String error=ms.getMessage("field.reqired.loginBean.userId",new Object[]{"john","123"} , "username is required", Locale.ENGLISH);
		System.out.println(error);

	}

}
