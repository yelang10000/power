package com.sun.power.core.utils;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 
 * 项目名称：CloudSecurity 类名称：CommonUtils 类描述：公共处理函数类 修改备注：
 * 
 * @version
 * 
 */
public class CommonUtils
{

	private static Logger log = Logger.getLogger(CommonUtils.class);
	private static String GET = "get";
	private static String SET = "set";

	public CommonUtils()
	{

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize() throws Throwable
	{

	}

	private static Field getObjectField(Object sourceObj, String fieldName)
	{

		Field field = null;
		try
		{
			field = sourceObj.getClass().getDeclaredField(fieldName);
		} catch (SecurityException e)
		{
			log.debug("getObjectField SecurityException error", e);
		} catch (NoSuchFieldException e)
		{
			log.debug("getObjectField NoSuchFieldException error:", e);
		}
		return field;
	}

	private static Method getObjectMethod(Object sourceObj, String fieldName, String methodHead, Class<?> clazz)
	{

		Method method = null;
		try
		{
			if (clazz == null)
			{
				method = (Method) sourceObj.getClass().getMethod(methodHead + getMethodName(fieldName));
			}
			else
			{
				method = (Method) sourceObj.getClass().getMethod(methodHead + getMethodName(fieldName), clazz);
			}
		} catch (SecurityException e)
		{
			log.debug("getObjectMethod SecurityException error:", e);
		} catch (NoSuchMethodException e)
		{
			log.debug("getObjectMethod NoSuchMethodException error:", e);
		} catch (Exception e)
		{
			log.debug("getObjectMethod Exception error:", e);
		}
		return method;
	}

	/**
	 * 
	 * getObjectMethodObj(根据属性名称获取该属性的字段值)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 */
	public static Object getObjectMethodObj(Object sourceObj, String fieldName)
	{

		Method method = getObjectMethod(sourceObj, fieldName, GET, null);
		Object result = null;
		if (method != null)
		{
			try
			{
				result = method.invoke(sourceObj);
			} catch (IllegalArgumentException e)
			{
				log.debug("getObjectMethod IllegalArgumentException error:", e);
			} catch (IllegalAccessException e)
			{
				log.debug("getObjectMethod IllegalAccessException error:", e);
			} catch (InvocationTargetException e)
			{
				log.debug("getObjectMethod InvocationTargetException error:", e);
			}
		}
		return result;
	}

	public static Class<?> fieldToClass(Field field)
	{

		String className = field.getGenericType().toString();
		if (className.equals("class java.lang.String"))
		{
			return String.class;
		}
		else if (className.equals("class java.lang.Integer"))
		{
			return Integer.class;
		}
		else if (className.equals("class java.lang.Long"))
		{
			return Long.class;
		}
		return null;
	}

	public static void setObjectMethodObj(Object sourceObj, String fieldName, Object value)
	{

		log.debug(String.format("setObjectMethodObj fieldName:%s; value:%s", fieldName, value));
		Field field = getObjectField(sourceObj, fieldName);
		if (field == null)
		{
			log.debug("setObjectMethodObj getMethod error.");
			return;
		}
		Class<?> clazz = fieldToClass(field);
		if (clazz == null)
		{
			log.error("setObjectMethodObj clazz error.");
			return;
		}

		Method setMethod = getObjectMethod(sourceObj, fieldName, SET, clazz);

		if (setMethod != null)
		{
			try
			{
				setMethod.invoke(sourceObj, value);
			} catch (IllegalArgumentException e)
			{
				log.debug("getObjectMethod IllegalArgumentException error:", e);
			} catch (IllegalAccessException e)
			{
				log.debug("getObjectMethod IllegalAccessException error:", e);
			} catch (InvocationTargetException e)
			{
				log.debug("getObjectMethod InvocationTargetException error:", e);
			}
		}
	}

	/**
	 * 
	 * getObjectMethod(获取属性值，安装对象类型返回)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectMethod(Object sourceObj, String fieldName, Class<T> className)
	{

		Object obj = getObjectMethodObj(sourceObj, fieldName);
		T result = null;
		if (obj != null)
		{
			result = (T) obj;
		}
		else
		{
			return null;
		}
		return result;
	}

	/**
	 * 
	 * getMethodName(返回属性首字母大写名称)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 */
	public static String getMethodName(String fildeName) throws Exception
	{

		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	// 获取UUID
	public static String getUUID()
	{

		UUID uuid = UUID.randomUUID();

		return uuid.toString().toUpperCase();
	}

	/**
	 * 
	 * getClassAllFields(获取一个对象的所有字段)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 */
	@SuppressWarnings("rawtypes")
	public static List<Field> getClassAllFields(Class clazz)
	{

		if (clazz == null)
		{
			return null;
		}

		List<Field> parentFieldList = null;
		if (clazz.getSuperclass() != null)
		{
			parentFieldList = getClassAllFields(clazz.getSuperclass());
		}

		List<Field> result = new ArrayList<Field>();
		if (parentFieldList != null)
		{
			for (Field field : parentFieldList)
			{
				result.add(field);
			}
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields)
		{
			result.add(field);
		}

		return result;
	}

	/**
	 * 
	 * stringTrimAndUpperExchange(讲参数转换成大写，并且去掉前后的空格)
	 * 
	 * @param name
	 * @param @return 设定文件
	 * @return String DOM对象
	 */
	public static String stringTrimAndUpperExchange(String inputStr)
	{

		if (inputStr != null)
		{
			return inputStr.toUpperCase().trim();
		}
		return null;
	}

	// 对Intgeger类型的List进行排序
	public static void orderIntegerList(List<Integer> intList)
	{

		Collections.sort(intList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1.compareTo(o2);
			}
		});
	}

	public static int IntegerTointDef(Integer source, int defaultValue)
	{

		if (source != null)
		{
			return source.intValue();
		}
		else
		{
			return defaultValue;
		}
	}
}
