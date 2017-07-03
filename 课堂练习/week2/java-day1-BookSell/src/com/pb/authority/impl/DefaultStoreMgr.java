package com.pb.authority.impl;

import com.pb.authority.StoreMgr;
import com.pb.biz.BookBiz;
import com.pb.entity.Book;

/**
 * Ĭ�Ͽ��
 */
public class DefaultStoreMgr implements StoreMgr {

	/**
	 * ��дͼ�����
	 */
	public void in(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.inBook(bookId, num);	
	}
	/**
	 * ��д����ͼ��
	 */
	public void save(Book book) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.saveBook(book);
	}

	/**
	 * ��д����
	 */
	public void out(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.outBook(bookId, num);
	}

	/**
	 * ��д����ѯ
	 */
	public void query() {
		BookBiz bookBiz=new BookBiz();
		bookBiz.query();
	}
}
