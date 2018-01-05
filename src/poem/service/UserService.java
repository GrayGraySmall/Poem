package poem.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poem.dao.UserDao;
import poem.model.PoemUser;
import poem.utils.MD5Utils;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 用户注册
	 * 管理员状态UserKind，1，普通用户0
	 * 用户权限，UserState 1， 封禁0
	 * @param userName
	 * @param password
	 * @return
	 */
	public int register(String userName, String password){
		String icon = "resources/img/headimg.jpeg";
		String intro = "君子好逑";
		PoemUser user = new PoemUser(userName, MD5Utils.md5(password), intro, 0, 0, 1, icon);
		return userDao.register(user);
	}
	
	/**
	 * 检查用户是否存在
	 * @param userName
	 * @return
	 */
	public int checkExist(String userName){
		return userDao.checkExist(userName);
	}
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return	登录成功返回用户信息
	 * 			登录失败返回null
	 */
	public PoemUser checkLogin(String userName, String password) {
		PoemUser user =  userDao.checkLogin(userName, MD5Utils.md5(password));
		return user;
	}
	
	/**
	 * 查询所有的用户
	 * @param userName
	 * @return
	 */
	public PoemUser[] selectAllUser(String userName, int changState) {
		return userDao.selectAllUser(userName, changState);
	}
	
	/**
	 * 修改用户状态
	 * @param userName
	 * @return
	 */
	public int changeState(String userName, int state) {
		return userDao.changeState(userName, state);
	}
	
	/**
	 * 修改用户（变为管理员）
	 * @param userName
	 * @return
	 */
	public int changeKind(String userName, int kindName) {
		return userDao.changeKind(userName, kindName);
	}
	
	/**
	 * 查询管理员用户
	 */
	public PoemUser[] selectManager(){
		return userDao.selectManager();
	}
	
	public int updateIcon(String userName, String icon) {
		return userDao.updateIcon(userName, icon);
	}
}
