package com.flyonsky.weixin.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.weixin.data.AbstractData;

/**
 * 订单的商品详情
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderGoodsDetail extends AbstractData{

	// 订单商品详情
	@JsonProperty("goods_detail")
	private List<GoodsInfo> goodsDetail;

	/**
	 * 订单商品详情
	 * @return
	 */
	public List<GoodsInfo> getGoodsDetail() {
		return goodsDetail;
	}

	/**
	 * 订单商品详情
	 * @param goodsDetail
	 */
	public void setGoodsDetail(List<GoodsInfo> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
}
