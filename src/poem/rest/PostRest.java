package poem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import poem.model.PoemPosts;
import poem.model.PostAddReply;
import poem.service.PostService;
import poem.utils.JsonUtils;

@Controller
public class PostRest {
	@Autowired
	private PostService postService;

	/**
	 * 用户发帖
	 * 
	 * @param posts
	 * @return
	 */
	@RequestMapping(value = { "publish" }, method = RequestMethod.POST)
	public @ResponseBody int addPost(@RequestBody PoemPosts posts) {
		System.out.println(posts.getPreContent());
		return postService.addPost(posts);
	}

	/**
	 * 按帖子id查询帖子信息
	 * 
	 * @param poemId
	 * @return
	 */
	@RequestMapping(value = { "publish/{poemId}" }, method = RequestMethod.GET)
	public @ResponseBody PoemPosts selectPost(@PathVariable("poemId") int poemId) {
		PoemPosts posts = postService.selectPosts(poemId);
		System.out.println("publish/{poemId}" + JsonUtils.objectToJson(posts));
		return posts;
	}

	/**
	 * 按要求查询帖子信息
	 * 
	 * @param title
	 * @param fine
	 * @return
	 */
	@RequestMapping(value = { "getpost/{title}/{fine}" }, method = RequestMethod.GET)
	public @ResponseBody PostAddReply[] selectAllPosts(@PathVariable("title") String title,
			@PathVariable("fine") int fine) {
		System.out.println("POSTREST -----> selectAllPosts");
		return postService.selectPosts(title, fine);
	}

	/**
	 * 按要求查询帖子信息
	 * 
	 * @param title
	 * @param fine
	 * @return
	 */
	@RequestMapping(value = { "getpost/{kindName}" }, method = RequestMethod.GET)
	public @ResponseBody PostAddReply[] selectAllPosts(@PathVariable("kindName") String kindName) {
		System.out.println("POSTREST+kindName  -----> selectAllPosts");
		return postService.selectPosts(kindName);
	}

	/**
	 * 改变诗歌状态（加精OR 不加精）
	 * 
	 * @param poemId
	 * @param fine
	 * @return
	 */
	@RequestMapping(value = { "changePost/{poemId}/{fine}" }, method = RequestMethod.GET)
	public @ResponseBody int changeFine(@PathVariable("poemId") int poemId, @PathVariable("fine") int fine) {
		return postService.changeFine(poemId, fine);
	}

	/**
	 * 删除帖子
	 * 
	 * @param poemId
	 * @return
	 */
	@RequestMapping(value = { "deletePost/{poemId}" }, method = RequestMethod.GET)
	public @ResponseBody int deletePost(@PathVariable("poemId") int poemId) {
		return postService.deletePost(poemId);
	}

	/**
	 * 根据用户名查询用户的帖子
	 */
	@RequestMapping(value = { "userPost/{userName}" }, method = RequestMethod.GET)
	public @ResponseBody PostAddReply[] queryPostByName(@PathVariable("userName") String userName) {
		System.out.println("PostAddReply[] 查询用户的帖子");
		return postService.selectPostByUserName(userName);
	}
}
