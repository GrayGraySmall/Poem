package poem.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import poem.model.PoemPosts;
import poem.model.PostAddReply;
import poem.utils.JsonUtils;

@Repository
public class PostDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 用户发帖，增加帖子
	 * 
	 * @param posts
	 * @return
	 */
	public int addPost(PoemPosts posts) {
		String sql = "insert into dbo.PoemPosts(userName, kindName, publishTime, poemTitle, poemContent,  preContent, fine) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql,
					new Object[] { posts.getUserName(), posts.getKindName(), posts.getPublishTime(),
							posts.getPoemTitle(), posts.getPoemContent(), posts.getPreContent(), posts.getFine() });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("POSTDAO+addPOST ERROR");
			// e.printStackTrace();
			return -1;
		}
		return ret;
	}

	/**
	 * 查询所有的诗集（但是只生成预览的） 为了节约流量
	 * 
	 * @return
	 */
	public PostAddReply[] selectAllPosts(int fine) {
		String sql = "select b.poemId, userName, kindName, publishTime, poemTitle, preContent, "
				+ "(select count(*) from dbo.RePly where poemId =b.poemId) as reply, fine from dbo.PoemPosts as b";
		List<PostAddReply> posts;
		if (fine != 0) {
			sql = sql + "where fine = ?";
			posts = jdbcTemplate.query(sql, new Object[] { fine },
					BeanPropertyRowMapper.newInstance(PostAddReply.class));
		} else {
			posts = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PostAddReply.class));
		}
		if (posts.size() == 0) {
			return null;
		}
		return posts.toArray(new PostAddReply[0]);
	}

	/**
	 * 按帖子id查询帖子信息
	 * 
	 * @param PoemId
	 * @return
	 */
	public PoemPosts selectPost(int PoemId) {
		String sql = "select * from dbo.PoemPosts where poemId = ?";
		List<PoemPosts> posts = jdbcTemplate.query(sql, new Object[] { PoemId },
				BeanPropertyRowMapper.newInstance(PoemPosts.class));
		if (posts.size() == 0) {
			return null;
		}
		return posts.get(0);
	}

	/**
	 * 按照一定要求查询用户帖子
	 * 
	 * @param poemTitle
	 * @param fine
	 * @return
	 */
	public PostAddReply[] selectAllPosts(String poemTitle, int fine) {
		List<PostAddReply> posts;
		if (fine != -1) {
			String sql = "select poemId, userName, poemTitle, preContent, publishTime, fine from dbo.PoemPosts where fine = ? ";
			if (poemTitle.equals("-1") == false) {
				sql += " and poemTitle like '%" + poemTitle + "%'";
			}
			sql = sql + " order by publishTime desc";
			posts = jdbcTemplate.query(sql, new Object[] { fine },
					BeanPropertyRowMapper.newInstance(PostAddReply.class));
			if (posts.size() == 0) {
				return null;
			}
		} else {
			String sql = "select b.poemId, userName, kindName, publishTime, poemTitle, preContent, "
					+ "(select count(*) from dbo.RePly where poemId = b.poemId) as reply, fine from dbo.PoemPosts as b";
			if (poemTitle.equals("-1") == false) {
				sql += " where poemTitle like '%" + poemTitle + "%'";
			}
			sql = sql + " order by publishTime desc";
			posts = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PostAddReply.class));
			if (posts.size() == 0) {
				return null;
			}
		}
		System.out.println(JsonUtils.objectToJson(posts));
		return posts.toArray(new PostAddReply[0]);
	}

	/**
	 * 按照一定要求查询用户帖子
	 * 
	 * @param poemTitle
	 * @param fine
	 * @return
	 */
	public PostAddReply[] selectAllPosts(String kind) {
		String sql = "select b.poemId, userName, kindName, publishTime, poemTitle, preContent, "
				+ "(select count(*) from dbo.RePly where poemId = b.poemId) as reply, fine from dbo.PoemPosts as b where kindName=?";
		List<PostAddReply> posts = jdbcTemplate.query(sql, new Object[] { kind },
				BeanPropertyRowMapper.newInstance(PostAddReply.class));
		if (posts.size() == 0) {
			return null;
		}
		System.out.println(JsonUtils.objectToJson(posts));
		return posts.toArray(new PostAddReply[0]);
	}

	/**
	 * 根据用户名查询用户帖子
	 * 
	 * @param userName
	 * @return
	 */
	public PostAddReply[] selectPostByUserName(String userName) {
		String sql = "select b.poemId, userName, kindName, publishTime, poemTitle, preContent, "
				+ "(select count(*) from dbo.RePly where poemId = b.poemId) as reply, fine "
				+ "from dbo.PoemPosts as b where userName=? order by publishTime";
		List<PostAddReply> posts = jdbcTemplate.query(sql, new Object[] { userName },
				BeanPropertyRowMapper.newInstance(PostAddReply.class));
		if (posts.size() == 0) {
			return null;
		}
		System.out.println(JsonUtils.objectToJson(posts));
		return posts.toArray(new PostAddReply[0]);
	}

	/**
	 * 帖子加精
	 * 
	 * @param poemId
	 * @param fine
	 * @return
	 */
	public int changeFine(int poemId, int fine) {
		String sql = "update dbo.PoemPosts set fine = ? where poemId = ?";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { fine, poemId });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("POST--------->changfine出错了");
			return -1;
		}
		return ret;
	}

	/**
	 * 删除帖子
	 * 
	 * @param poemId
	 * @return
	 */
	public int deletePost(int poemId) {
		String sql = "delete from dbo.PoemPosts where poemId = ?";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { poemId });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR---------->deletePost");
			return -1;
		}
		return ret;
	}
}
