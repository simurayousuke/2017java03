package com.pb.role;
import com.pb.entity.Book;
import com.pb.entity.EX;
import com.pb.role.Role;


public class User {
	private Role role = null;
	
	/**
	 * ��¼
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password){
		//if(username.equals(password)){
			return true;
		//}
		//return false;
	}
	
	/**
	 * ͼ�����
	 * @param bookId
	 * @param num
	 */
	public void in(int bookId,int num){
		role.in(bookId, num);
	}
	
	/**
	 * ͼ�����
	 * @param bookId
	 * @param num
	 */
	public void out(int bookId,int num){
		role.out(bookId, num);
	}
	
	/**
	 * ����ͼ��
	 * @param book
	 */
	public void save(Book book){
		role.save(book);
	}
	
	/**
	 * �鿴ͼ����Ϣ
	 */
	public void query(){
		role.query();
	}
	
	/**
	 * ����
	 * @param book
	 */
	public void checkout(Book book){
		role.checkout(book);
	}
	
	/**
	 * ����ͼ��
	 * @param bookId
	 * @param num
	 * @return
	 */
	public Book buy(int bookId, int num){
		return role.buy(bookId, num);
	}
	
	/**
	 * ������Ʒ
	 * @param exCode
	 * @return
	 */
	public EX buyEx(int exCode){
		return role.buyEx(exCode);
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}	
}
