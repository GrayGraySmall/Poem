package poem.model;

import org.springframework.stereotype.Component;

/**
 * 用户dbo.PoemUser
 * 
 * @author zephyr
 *
 */
@Component("poemUser")
public class PoemUser {
	private String userName;// 用户名
	private String password;// 密码
	private String intro;// 个性签名
	private int experience;// 经验值
	private int userKind;
	private int userState;
	private String userIcon;

	public PoemUser(String userName, String password, String intro, int experience, int userKind, int userState,
			String userIcon) {
		super();
		this.userName = userName;
		this.password = password;
		this.intro = intro;
		this.experience = experience;
		this.userKind = userKind;
		this.userState = userState;
		this.userIcon = userIcon;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getUserKind() {
		return userKind;
	}

	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public PoemUser() {
		super();
	}

}
