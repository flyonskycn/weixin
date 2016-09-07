package com.flyonsky.weixin.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 扫码支付时的商品详细信息
 * @author Administrator
 *
 */
public class GoodsInfo{

	// 必填 32 商品的编号
	@JsonProperty("goods_id")
	private String goodsId;
	
	// 可选 32 微信支付定义的统一商品编号
	@JsonProperty("wxpay_goods_id")
	private String wxpayGoodsId;
	
	// 必填  商品名称
	@JsonProperty("goods_name")
	private String goodsName;
	
	// 必填 商品数量
	@JsonProperty("goods_num")
	private int goodsNum;
	
	// 必填 商品单价，单位为分
	@JsonProperty("price")
	private int price;
	
	// 可选 商品类目ID
	@JsonProperty("goods_category")
	private String goodsCategory;
	
	// 可选 商品描述信息
	@JsonProperty("body")
	private String body;

	/**
	 * 商品的编号 必填
	 * @return
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * 商品的编号 必填
	 * @param goodsId
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * 微信支付定义的统一商品编号 可选 
	 * @return
	 */
	public String getWxpayGoodsId() {
		return wxpayGoodsId;
	}

	/**
	 * 微信支付定义的统一商品编号 可选 
	 * @param wxpayGoodsId
	 */
	public void setWxpayGoodsId(String wxpayGoodsId) {
		this.wxpayGoodsId = wxpayGoodsId;
	}

	/**
	 * 必填  商品名称
	 * @return
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 必填  商品名称
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 必填 商品数量
	 * @return
	 */
	public int getGoodsNum() {
		return goodsNum;
	}

	/**
	 * 必填 商品数量
	 * @param goodsNum
	 */
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	/**
	 * 必填 商品单价，单位为分
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 必填 商品单价，单位为分
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 可选 商品类目ID
	 * @return
	 */
	public String getGoodsCategory() {
		return goodsCategory;
	}

	/**
	 * 可选 商品类目ID
	 * @param goodsCategory
	 */
	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	/**
	 * 可选 商品描述信息
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 可选 商品描述信息
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}
}
