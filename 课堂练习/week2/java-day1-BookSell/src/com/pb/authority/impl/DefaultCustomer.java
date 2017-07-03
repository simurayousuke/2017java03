package com.pb.authority.impl;

import com.pb.authority.Normal;
import com.pb.entity.Book;
import com.pb.entity.EX;
import com.pb.biz.BookBiz;;
public class DefaultCustomer implements Normal {

	@Override
	public void query() {
	 BookBiz bookbiz=new BookBiz();
	 bookbiz.query();
	}

	@Override
	public Book buy(int bookId, int num) {
		 BookBiz bookbiz=new BookBiz();
		return  bookbiz.buyBook(bookId, num);
	}

	@Override
	public EX buyEx(int exCode) {
		 BookBiz bookbiz=new BookBiz();
		 return bookbiz.buyEX(exCode);
	}

	@Override
	public void checkout(Book book) {
		 BookBiz bookbiz=new BookBiz();
		 bookbiz.checkout(book);

	}

}
