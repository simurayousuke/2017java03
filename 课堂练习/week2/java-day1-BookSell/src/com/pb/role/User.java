package com.pb.role;
import com.pb.entity.Book;
import com.pb.entity.EX;
import com.pb.role.Role;


public class User {
	private Role role = null;
	
	/**
	 * 登录
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
	 * 图书入库
	 * @param bookId
	 * @param num
	 */
	public void in(int bookId,int num){
		role.in(bookId, num);
	}
	
	/**
	 * 图书出库
	 * @param bookId
	 * @param num
	 */
	public void out(int bookId,int num){
		role.out(bookId, num);
	}
	
	/**
	 * 新增图书
	 * @param book
	 */
	public void save(Book book){
		role.save(book);
	}
	
	/**
	 * 查看图书信息
	 */
	public void query(){
		role.query();
	}
	
	/**
	 * 结账
	 * @param book
	 */
	public void checkout(Book book){
		role.checkout(book);
	}
	
	/**
	 * 购买图书
	 * @param bookId
	 * @param num
	 * @return
	 */
	public Book buy(int bookId, int num){
		return role.buy(bookId, num);
	}
	
	/**
	 * 购买附赠品
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
