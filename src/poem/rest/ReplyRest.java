package poem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poem.model.Reply;
import poem.model.ReplyAndUser;
import poem.service.ReplyService;
import poem.utils.JsonUtils;

@Controller
public class ReplyRest {
	@Autowired
	private ReplyService replyService;
	
	/**
	 * 添加用户回复
	 * @param reply
	 * @return
	 */
	@RequestMapping(value={"/addReply"}, method=RequestMethod.POST)
	public @ResponseBody int insertReply(@RequestBody Reply reply) {
		System.out.println("ReplyRest-->"+JsonUtils.objectToJson(reply));
		return replyService.insertReply(reply);
	}
	
	/**
	 * 获取用户回复
	 * @param poemId
	 * @return
	 */
	@RequestMapping(value={"queryReply/{poemId}"}, method=RequestMethod.GET)
	public @ResponseBody ReplyAndUser[] selectReply(@PathVariable("poemId") int poemId){
		System.out.println("selectReply---->运行了");
		return replyService.selectReply(poemId);
	}
}
