package poem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poem.dao.ReplyDao;
import poem.model.Reply;
import poem.model.ReplyAndUser;
import poem.utils.DateUtils;

@Service
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;

	/**
	 * 增加回复
	 * 
	 * @param reply
	 * @return
	 */
	public int insertReply(Reply reply) {
		String date = DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"); // 获取服务器当前时间,并格式化
		reply.setReplyTime(new java.sql.Date(DateUtils.strToDate(date, "yyyy-MM-dd HH:mm:ss").getTime()));
		return replyDao.insertAddReply(reply);
	}
	
	/**
	 * 查询回复
	 * @param poemId
	 * @return
	 */
	public ReplyAndUser[] selectReply(int poemId) {
		return replyDao.queryReply(poemId);
	}
}
