package com.pb.role;

import com.pb.authority.Normal;
import com.pb.authority.StoreMgr;
import com.pb.entity.Book;
import com.pb.entity.EX;


public abstract class Role {

	private String description;// ��ɫ��
	private StoreMgr storeMgr = null;//���Ȩ��
	private Normal normal = null;//�˿�Ȩ��
	
	/**
	 * ���
	 * @param bookId
	 * @param num
	 */
	public void in(int bookId,int num){
		if(storeMgr == null){
			System.out.println("��û�п�����ԱȨ��");
			return;
		}
		storeMgr.in(bookId,num);
	}
	
	/**
	 * ����
	 * @param bookId
	 * @param num
	 */
	public void out(int bookId,int num){
		if(storeMgr == null){
			System.out.println("��û�п�����ԱȨ��");
			return;
		}
		storeMgr.out(bookId,num);
	}
	
	/**
	 * ����ͼ��
	 * @param book
	 */
	public void save(Book book) {
		if(storeMgr == null){
			System.out.println("��û�п�����ԱȨ��");
			return;
		}
		storeMgr.save(book);
	}
	
	/**
	 * ��ѯͼ��
	 */
	public void query(){
		if(normal == null&&storeMgr==null){
			System.out.println("����û�е�¼�����½���ٲ���");
			return;
		}else if(normal!=null){	
			normal.query();
		}else{
			storeMgr.query();
		}
	}
	
	/**
	 * ����
	 * @param book
	 */
	public void checkout(Book book){
		if(normal == null){
			System.out.println("����û�е�¼�����½���ٲ���");
			return;
		}
		normal.checkout(book);
	}
	
	/**
	 * ����ͼ��
	 * @param bookId
	 * @param num
	 * @return
	 */
	public Book buy(int bookId,int num){
		if(normal == null){
			System.out.println("����û�е�¼�����½���ٲ���");
			return null;
		}
		return normal.buy(bookId, num);
	}
	
	/**
	 * ������Ʒ
	 * @param exCode
	 * @return
	 */
	public EX buyEx(int exCode){
		if(normal == null){
			System.out.println("����û�е�¼�����½���ٲ���");
			return null;
		}
		return normal.buyEx(exCode);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public StoreMgr getStoreMgr() {
		return storeMgr;
	}
	public void setStoreMgr(StoreMgr storeMgr) {
		this.storeMgr = storeMgr;
	}
	public void setNormal(Normal normal) {
		this.normal = normal;
	}
	
	public Normal getNormal() {
		return normal;
	}
	
	
	
}
