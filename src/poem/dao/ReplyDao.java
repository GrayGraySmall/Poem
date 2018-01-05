package poem.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import poem.model.Reply;
import poem.model.ReplyAndUser;
import poem.utils.JsonUtils;

@Repository
public class ReplyDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 添加回复
	 * 
	 * @param reply
	 * @return
	 */
	public int insertAddReply(Reply reply) {
		String sql = "insert into dbo.RePly(userName, poemId, replyContent, replyTime) values(?,?,?,?)";
		int ret = -1;
		ret = jdbcTemplate.update(sql,
				new Object[] { reply.getUserName(), reply.getPoemId(), reply.getReplyContent(), reply.getReplyTime() });
		try {
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Reply----->insertAddReply出错");
			return -1;
		}
		return ret;
	}

	/**
	 * 按帖子的编号显示回复并按时间顺序排序
	 * 
	 * @param poemId
	 * @return
	 */
	public ReplyAndUser[] queryReply(int poemId) {
		String sql = "select * from dbo.reply_user_information where poemId = ? order by replyTime";
		List<ReplyAndUser> replys = jdbcTemplate.query(sql, new Object[] { poemId },
				BeanPropertyRowMapper.newInstance(ReplyAndUser.class));
		if (replys.size() == 0) {
			return null;
		}
		System.out.println("queryReply--->" + JsonUtils.objectToJson(replys));
		return replys.toArray(new ReplyAndUser[0]);
	}
}
