package com.pb.authority;
import com.pb.entity.EX;
import com.pb.entity.Book;
public interface Normal {
	public void query();//��ѯͼ��
	public Book buy(int bookId,int num);//����
	public EX buyEx(int exCode);//����Ʒ
	public void checkout(Book book);//����
}
