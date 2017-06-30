package Bookbiz;

import entity.Book;
import entity.Disc;
import entity.Resource;

/**
 * ��ԴĿ¼��
 */
public class CatalogItem {
	/**
	 * ��¼��Դ
	 * @param resourceType ��Դ����
	 * @return ��Դ
	 */
	public static Resource noteResource(String resourceType) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		Class<?> clazz=Class.forName("entity."+resourceType);
		Resource resource=(Resource)clazz.newInstance();
		// finish �ж�����
		return resource;
	}
}

