
//import java.util.*;
public class VerifyEqual {
	/**
	 * 验证管理员的用户名和密码是否相等
	 */
	public boolean verify(String username, String password) {

		// 完成用户名和密码验证
		Manager manager = new Manager();
		return username.equals(manager.username) && password.equals(manager.password);

	}
}
