package com.pb.authority;
import com.pb.entity.Book;
public interface StoreMgr {
	public void in(int bookId,int num);//���
	public void out(int bookId,int num);//����
	public void save(Book book);//����
	public void query();//��ѯ���
}
