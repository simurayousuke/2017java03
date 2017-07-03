package com.pb.authority;
import com.pb.entity.Book;
public interface StoreMgr {
	public void in(int bookId,int num);//入库
	public void out(int bookId,int num);//出库
	public void save(Book book);//新书
	public void query();//查询库存
}
