package com.flyonsky.weixin.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageData {

	@JsonProperty("ToUserName")
	private String toUserName;
	
	@JsonProperty("FromUserName")
	private String fromUserName;
	
	@JsonProperty("CreateTime")
	private long createTime;
	
	@JsonProperty("MsgType")
	private String msgType;
	
	@JsonProperty("Event")
	private String event;
	
	@JsonProperty("EventKey")
	private String eventKey;
	
	@JsonProperty("Ticket")
	private String ticket;
	
	@JsonProperty("Latitude")
	private double latitude;
	
	@JsonProperty("Longitude")
	private double longitude;
	
	@JsonProperty("Precision")
	private double precision;
	
	@JsonProperty("Content")
	private String content;
	
	@JsonProperty("MsgId")
	private long msgId;
	
	@JsonProperty("PicUrl")
	private String picUrl;
	
	@JsonProperty("MediaId")
	private String mediaId;
	
	@JsonProperty("Format")
	private String format;
	
	@JsonProperty("Recognition")
	private String recognition;
	
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;
	
	@JsonProperty("Location_X")
	private double locationX;
	
	@JsonProperty("Location_Y")
	private double LocationY;
	
	@JsonProperty("Scale")
	private int scale;
	
	@JsonProperty("Label")
	private String label;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Description")
	private String description;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return LocationY;
	}

	public void setLocationY(double locationY) {
		LocationY = locationY;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
