package poem.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import poem.model.PoemUser;
import poem.service.UserService;

@Controller
public class UserRest {
	@Autowired
	private UserService userService;

	/**
	 * 检查用户是否登录成功
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = { "userLogin/{userName}/{password}" }, method = RequestMethod.GET)
	public @ResponseBody PoemUser checkLogin(@PathVariable("userName") String userName,
			@PathVariable("password") String password, HttpSession session) {
		if (userName == null) {
			return null;
		}
		if (password == null) {
			return null;
		}
		System.out.println("userLogin/{userName}/{password}" + userName);
		PoemUser user = userService.checkLogin(userName, password);
		if (user != null) {
			session.setAttribute("userName", user.getUserName());
		}
		return user;
	}

	/**
	 * 检查用户名是否已注册
	 * 
	 * @return
	 */
	@RequestMapping(value = { "userRegister/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody int checkExist(@PathVariable("userName") String userName) {
		System.out.println("userRegister/{userName}:" + userName);
		return userService.checkExist(userName);
	}

	/**
	 * 用户注册
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = { "userRegister/{userName}/{password}" }, method = RequestMethod.GET)
	public @ResponseBody int checkRegister(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		System.out.println("userRegister/{userName}/{password}:" + userName);
		return userService.register(userName, password);
	}

	/**
	 * 请求所有用户
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "alluser/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody PoemUser[] selectAllUsers(@PathVariable("userName") String userName) {
		System.out.println("USERREST--->selectAllUsers选择所有用户");
		return userService.selectAllUser(userName, 1);
	}

	/**
	 * 请求所有被封禁的用户
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "bannedUser/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody PoemUser[] selectBannedUsers(@PathVariable("userName") String userName) {
		System.out.println("USERREST--->selectAllUsers选择被封禁用户");
		return userService.selectAllUser(userName, 0);
	}

	/**
	 * 修改用户状态
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "changeStae/{userName}/{state}" }, method = RequestMethod.GET)
	public @ResponseBody int changState(@PathVariable("userName") String userName, @PathVariable("state") int state) {
		System.out.println(userName+state);
		return userService.changeState(userName, state);
	}

	/**
	 * 修改用户状态(变为管理员)
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "changeKind/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody int changeKind(@PathVariable("userName") String userName) {
		System.out.println("USERREST--->changeKind修改用户状态(变为管理员)" + userName);
		return userService.changeKind(userName, 1);
	}

	/**
	 * 查询管理员用户
	 * 
	 * @param dataId
	 * @return
	 */
	@RequestMapping(value = { "querymanager" }, method = RequestMethod.GET)
	public @ResponseBody PoemUser[] queryManager() {
		return userService.selectManager();
	}
	
	/**
	 * 修改用户状态(变为普通用户)
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = { "removeManager/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody int removeManager(@PathVariable("userName") String userName) {
		System.out.println("USERREST--->changeKind修改用户状态(变为普通用户)" + userName);
		return userService.changeKind(userName, 0);
	}
}
