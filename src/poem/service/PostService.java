package poem.service;

import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poem.dao.PostDao;
import poem.model.PoemPosts;
import poem.model.PostAddReply;
import poem.utils.DateUtils;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;

	/**
	 * 用户发帖
	 * 
	 * @param posts
	 * @return
	 */
	public int addPost(PoemPosts posts) {
		if (posts.getPreContent().length() > 30) {
			posts.setPreContent(posts.getPreContent().substring(0, 30));
		}
		String date = DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"); // 获取服务器当前时间,并格式化
		System.out.println(date);
		posts.setPublishTime(new java.sql.Date(DateUtils.strToDate(date, "yyyy-MM-dd HH:mm:ss").getTime()));
		return postDao.addPost(posts);
	}

	/**
	 * 查询所有帖子内容
	 * 
	 * @return
	 */
	public PostAddReply[] selectAllPosts(int fine) {
		return postDao.selectAllPosts(fine);
	}

	/**
	 * 按id查找post
	 * 
	 * @param poemId
	 * @return
	 */
	public PoemPosts selectPosts(int poemId) {
		return postDao.selectPost(poemId);
	}

	/**
	 * 按照要求查询用户帖子
	 * 
	 * @param poemtitle
	 * @param fine
	 * @return
	 */
	public PostAddReply[] selectPosts(String poemtitle, int fine) {
		return postDao.selectAllPosts(poemtitle, fine);
	}

	/**
	 * 按照要求查询用户帖子(种类)
	 * 
	 * @param poemtitle
	 * @param fine
	 * @return
	 */
	public PostAddReply[] selectPosts(String kindName) {
		return postDao.selectAllPosts(kindName);
	}

	/**
	 * 改变帖子加精状态
	 * 
	 * @param poemId
	 * @param fine
	 * @return
	 */
	public int changeFine(int poemId, int fine) {
		return postDao.changeFine(poemId, fine);
	}

	/**
	 * 删除帖子
	 */
	public int deletePost(int poemId) {
		return postDao.deletePost(poemId);
	}

	/**
	 * 根据用户名查询用户帖子
	 * 
	 * @param userName
	 * @return
	 */
	public PostAddReply[] selectPostByUserName(String userName) {
		return postDao.selectPostByUserName(userName);
	}
}
