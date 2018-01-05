package poem.model;

import org.springframework.stereotype.Component;

/**
 * 诗歌分类dbo.PomeKind
 * 
 * @author zephyr
 *
 */
@Component("poemKind")
public class PoemKind {
	private String kindName;// 分类名
	private String kindIntro;// 分类简介

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindIntro() {
		return kindIntro;
	}

	public void setKindIntro(String kindIntro) {
		this.kindIntro = kindIntro;
	}

	public PoemKind(String kindName, String kindIntro) {
		super();
		this.kindName = kindName;
		this.kindIntro = kindIntro;
	}

	public PoemKind() {
		super();
	}
}
