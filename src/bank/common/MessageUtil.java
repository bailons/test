package bank.common;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;


public class MessageUtil {
	/**
	 * Description: 私有化构造
	 */
	private MessageUtil() {
		super();
	}

	/**
	 * @Description 为每次调用生成一个XStream
	 * @Title getInstance
	 * @return
	 */
	private static XStream getInstance() {
		XStream xStream = new XStream(new DomDriver("UTF-8")) {
			/**
			 * 忽略xml中多余字段
			 */
			@Override
			protected MapperWrapper wrapMapper(MapperWrapper next) {
				return new MapperWrapper(next) {
					@SuppressWarnings("rawtypes")
					@Override
					public boolean shouldSerializeMember(Class definedIn, String fieldName) {
						if (definedIn == Object.class) {
							return false;
						}
						return super.shouldSerializeMember(definedIn, fieldName);
					}
				};
			}
		};

		// 设置默认的安全校验
		XStream.setupDefaultSecurity(xStream);
		// 使用本地的类加载器
		xStream.setClassLoader(MessageUtil.class.getClassLoader());
		// 允许所有的类进行转换
		xStream.addPermission(AnyTypePermission.ANY);
		return xStream;
	}

	/**
	 * @Description 将xml字符串转化为java对象
	 * @Title xmlToBean
	 * @param xml
	 * @param clazz
	 * @return
	 */
	public static <T> T xmlToBean(String xml, Class<T> clazz) {
		if (xml == null || xml.equals("") || clazz == null) {
			return null;
		}
		XStream xStream = getInstance();
		xStream.processAnnotations(clazz);
		Object object = xStream.fromXML(xml);
		T cast = clazz.cast(object);
		return cast;
	}

	/**
	 * @Description 将java对象转化为xml字符串
	 * @Title beanToXml
	 * @param object
	 * @return
	 */
	public static String beanToXml(Object object) {
		if (object == null) {
			return "";
		}
		XStream xStream = getInstance();
		xStream.processAnnotations(object.getClass());
		// 剔除所有tab、制表符、换行符
		String xml = xStream.toXML(object).replaceAll("\\s+", " ");
		return xml;
	}

	public static String fileZero(Integer value) {
		DecimalFormat df = new DecimalFormat("00000000");
		return df.format(value);
	}

	public static String build(Object o){
		StringBuffer sb = new StringBuffer();
		sb.append(Constant.ENCODE_HEAD).append(MessageUtil.beanToXml(o).replaceAll(" ","")).append("\n");
		int length = 0;
		try {
			length = sb.toString().getBytes(Constant.GBK_ENCODE).length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return MessageUtil.fileZero(length - 31) + sb;
	}
}
