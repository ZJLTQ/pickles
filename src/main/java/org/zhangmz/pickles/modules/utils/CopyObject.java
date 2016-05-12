package org.zhangmz.pickles.modules.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 实现对象的拷贝操作  
 * @author dc_zjl
 *
 */
public class CopyObject {
	public Object copy(Object object) throws Exception  
	{  
	    Class<?> classType = object.getClass();  
	    //先调用Class类的getConstructor()方法获得一个Constructor 对象，它代表默认的构造方法，然后调用  
	    //Constructor对象的newInstance()方法构造一个实例。  
	    Object objectCopy = classType.getConstructor(new Class[] {})  
	            .newInstance(new Object[] {});  
	    // Class 类的getDeclaredFields()方法返回类的所有属性，包括public、protected、默  
	    // 认和private访问级别的属性  
	    Field[] fields = classType.getDeclaredFields();  
	    for (Field field : fields)  
	    {  
	        String name = field.getName();  
	        // 将属性的首字母转换为大写  
	        String firstLetter = name.substring(0, 1).toUpperCase();            String getMethodName = "get" + firstLetter + name.substring(1);  
	        String setMethodName = "set" + firstLetter + name.substring(1);  
	        Method getMethod = classType.getMethod(getMethodName,  
	                new Class[] {});  
	        Method setMethod = classType.getMethod(setMethodName,  
	                new Class[] { field.getType() });  
	        Object value = getMethod.invoke(object, new Object[] {});  
	        setMethod.invoke(objectCopy, new Object[] { value });  
	    }  
	    // 以上两行代码等价于下面一行  
	    // Object obj2 = classType.newInstance();  
	    // System.out.println(obj);  
	    return objectCopy;  
	}  
}
