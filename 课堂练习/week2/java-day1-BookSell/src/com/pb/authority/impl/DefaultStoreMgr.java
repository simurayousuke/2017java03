package com.pb.authority.impl;

import com.pb.authority.StoreMgr;
import com.pb.biz.BookBiz;
import com.pb.entity.Book;

/**
 * 默认库管
 */
public class DefaultStoreMgr implements StoreMgr {

	/**
	 * 重写图书入库
	 */
	public void in(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.inBook(bookId, num);	
	}
	/**
	 * 重写新增图书
	 */
	public void save(Book book) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.saveBook(book);
	}

	/**
	 * 重写出库
	 */
	public void out(int bookId, int num) {
		BookBiz bookBiz=new BookBiz();
		bookBiz.outBook(bookId, num);
	}

	/**
	 * 重写库存查询
	 */
	public void query() {
		BookBiz bookBiz=new BookBiz();
		bookBiz.query();
	}
}
