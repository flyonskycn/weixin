package com.flyonsky.weixin.data.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 个性化菜单
 * 公众号的不同用户群体看到不一样的自定义菜单
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalityMenu extends DefaultMenu{

	// 菜单匹配规则
	@JsonProperty("matchrule")
	private MatchRule matchRule;

	public MatchRule getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(MatchRule matchRule) {
		this.matchRule = matchRule;
	}
}
