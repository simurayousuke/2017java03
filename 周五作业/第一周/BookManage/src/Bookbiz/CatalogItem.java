package Bookbiz;

import entity.Book;
import entity.Disc;
import entity.Resource;

/**
 * 资源目录类
 */
public class CatalogItem {
	/**
	 * 记录资源
	 * @param resourceType 资源类型
	 * @return 资源
	 */
	public static Resource noteResource(String resourceType) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class<?> clazz=Class.forName("entity."+resourceType);
		Resource resource=(Resource)clazz.newInstance();
		// finish 判断类型
		return resource;
	}
}

