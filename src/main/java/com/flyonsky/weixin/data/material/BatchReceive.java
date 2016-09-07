package com.flyonsky.weixin.data.material;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.ServiceReceive;

/**
 * 批量获取素材返回抽象类
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BatchReceive extends ServiceReceive{

	// 该类型的素材的总数
	@JsonProperty("total_count")
	private int totalCount;
	
	// 本次调用获取的素材的数量
	@JsonProperty("item_count")
	private int itemCount;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
