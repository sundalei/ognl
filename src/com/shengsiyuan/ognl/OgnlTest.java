package com.shengsiyuan.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlTest {
	public static void main(String[] args) throws OgnlException {
		Person person = new Person();
		person.setName("zhangsan");
		
		Dog dog2 = new Dog();
		dog2.setName("hello");
		
		person.setDog(dog2);
		
		Dog dog = new Dog();
		dog.setName("wangcai");
		
		OgnlContext context = new OgnlContext();
		
		context.put("person", person);
		context.put("dog", dog);
		
		//context.setRoot(person);
		context.setRoot(person);
		
		//Object object = Ognl.parseExpression("name");
		Object object = Ognl.parseExpression("dog.name");
		
		System.out.println(object);
		
		Object object2 = Ognl.getValue(object, context, context.getRoot());
		
		System.out.println(object2);
		
		System.out.println("--------------------------------");
		
		Object object3 = Ognl.parseExpression("#person.name");
		
		System.out.println(object3);
		
		Object object4 = Ognl.getValue(object3, context, context.getRoot());
		
		System.out.println(object4);
		
		System.out.println("--------------------------------");
		
		Object object5 = Ognl.parseExpression("#dog.name");
		
		System.out.println(object5);
		
		Object object6 = Ognl.getValue(object5, context, context.getRoot());
		
		System.out.println(object6);
		
		System.out.println("--------------------------------");
		
		Object object7 = Ognl.parseExpression("name.toUpperCase().length()");
		
		System.out.println(object7);
		
		Object object8 = Ognl.getValue(object7, context, context.getRoot());
		
		System.out.println(object8);
		
		System.out.println("--------------------------------");
		
		Object object9 = Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)");
		
		System.out.println(object9);
		
		Object object10 = Ognl.getValue(object9, context, context.getRoot());
		
		System.out.println(object10);
		
		System.out.println("--------------------------------");
		
		Object object11 = Ognl.parseExpression("@@min(4, 10)");
		
		System.out.println(object11);
		
		Object object12 = Ognl.getValue(object11, context, context.getRoot());
		
		System.out.println(object12);
		
		System.out.println("--------------------------------");
		
		Object object13 = Ognl.parseExpression("new java.util.LinkedList()");
		
		System.out.println(object13);
		
		Object object14 = Ognl.getValue(object13, context, context.getRoot());
		
		System.out.println(object14);
	}
}
