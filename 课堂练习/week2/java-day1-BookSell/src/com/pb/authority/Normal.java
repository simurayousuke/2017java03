package com.pb.authority;
import com.pb.entity.EX;
import com.pb.entity.Book;
public interface Normal {
	public void query();//查询图书
	public Book buy(int bookId,int num);//买书
	public EX buyEx(int exCode);//买赠品
	public void checkout(Book book);//结账
}
