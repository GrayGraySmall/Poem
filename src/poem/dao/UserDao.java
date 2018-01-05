package poem.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import poem.model.PoemUser;
import poem.utils.JsonUtils;

@Repository
public class UserDao {
	@Resource
	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 用户注册，注册成功返回1 注册失败返回-1
	 * 
	 * @param user
	 * @return
	 */
	public int register(PoemUser user) {
		String sql = "insert into dbo.PoemUser(userName, password, intro, experience, userKind, userState, userIcon) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getPassword(), user.getIntro(),
					user.getExperience(), user.getUserKind(), user.getUserState(), user.getUserIcon() });
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("userDao--register注册失败");
			// return -1;
		}
		return ret;
	}

	/**
	 * 检查用户是否存在
	 * 
	 * @param userName
	 * @return
	 */
	public int checkExist(String userName) {
		String sql = "select count(*) from PoemUser where userName = ?";
		int counter = jdbcTemplate.queryForObject(sql, new Object[] { userName }, Integer.class);
		return counter;
	}

	/**
	 * 检查用户登录
	 * 
	 * @return 登录成功返回用户信息 登录失败返回null
	 */
	public PoemUser checkLogin(String userName, String password) {
		String sql = "select * from dbo.PoemUser where userName = ? and password = ?";
		List<PoemUser> users = jdbcTemplate.query(sql, new Object[] { userName, password },
				BeanPropertyRowMapper.newInstance(PoemUser.class));
		if (users.size() != 0) {
			System.out.println(users.size());
			return users.get(0);
		}
		return null;
	}

	/**
	 * 查询所有用户（按姓名查询）
	 * 
	 * @param userName
	 * @return
	 */
	public PoemUser[] selectAllUser(String userName, int changeState) {
		String sql = "select userName, intro, experience, userKind from dbo.PoemUser where userState = ?";
		if (userName.equals("-1") == false) {
			sql += " and userName like '%" + userName + "%'";
		}
		sql += " order by experience";
		List<PoemUser> users = jdbcTemplate.query(sql, new Object[] { changeState },
				BeanPropertyRowMapper.newInstance(PoemUser.class));
		if (users.size() == 0) {
			return null;
		}
		return users.toArray(new PoemUser[0]);
	}

	/**
	 * 修改用户权限（关进小黑屋）和解封
	 * 
	 * @param userName
	 * @return
	 */
	public int changeState(String userName, int state) {
		String sql = "update dbo.PoemUser set userState = ? where userName = ?";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { state, userName });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserDao---->changeState出错了");
			return -1;
		}
		return ret;
	}

	/**
	 * 修改用户权限（变为管理员）
	 * 
	 * @param userName
	 * @return
	 */
	public int changeKind(String userName, int getKind) {
		String sql = "update dbo.PoemUser set userKind = ? where userName = ?";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { getKind, userName });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserDao---->changeState出错了");
			return -1;
		}
		return ret;
	}

	/**
	 * 查询管理员用户
	 * @return
	 */
	public PoemUser[] selectManager() {
		String sql = "select * from dbo.PoemUser where userKind = 1";
		List<PoemUser> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PoemUser.class));
		if (users.size() == 0) {
			return null;
		}
		System.out.println("selectManager------>"+JsonUtils.objectToJson(users));
		return users.toArray(new PoemUser[0]);
	}
	
	public int updateIcon(String userName, String icon) {
		String sql = "update dbo.PoemUser set userIcon = ? where userName = ?";
		int ret = -1;
		ret = jdbcTemplate.update(sql, new Object[]{icon, userName});
		try {
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("updateIcon -------> 出错了");
			return -1;
		}
		return ret;
	}
}
