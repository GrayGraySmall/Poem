package poem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poem.service.KindService;
import poem.utils.JsonUtils;

@Controller
public class KindRest {
	@Autowired
	private KindService kindService;
	
	/**
	 * 查找所有的用户种类
	 * @return
	 */
	@RequestMapping(value={"poemKind"}, method=RequestMethod.GET)
	public @ResponseBody String[] selectAllKind() {
		System.out.println("selectAllKind and poemKind:");
		String kind[] = kindService.selectAllKind();
		System.out.println(JsonUtils.objectToJson(kind));
		return kind;
	}
}
