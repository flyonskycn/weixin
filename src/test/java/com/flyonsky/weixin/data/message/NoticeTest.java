package com.flyonsky.weixin.data.message;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.weixin.data.EnumEventType;
import com.flyonsky.weixin.data.EnumMsgType;

public class NoticeTest {

	/**
	 * 测试接收到的文本消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testTextNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[this is a test]]></Content>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isNotBlank(data.getContent()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.text.toString()));
	}
	
	/**
	 * 测试接收到的图片消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testImageNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[image]]></MsgType>"
				+ "<PicUrl><![CDATA[this is a url]]></PicUrl>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isNoneBlank(data.getPicUrl()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.image.toString()));
	}
	
	/**
	 * 测试接收到的语音消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testVoiceNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[voice]]></MsgType>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<Format><![CDATA[Format]]></Format>"
				+ "<Recognition><![CDATA[腾讯微信团队]]></Recognition>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isBlank(data.getPicUrl()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getMediaId()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getRecognition()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.voice.toString()));
	}
	
	/**
	 * 测试接收到的视频消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testVideoNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[video]]></MsgType>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isBlank(data.getPicUrl()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getMediaId()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.video.toString()));
	}
	
	/**
	 * 测试接收到的小视频消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testShortVideoNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[shortvideo]]></MsgType>"
				+ "<MediaId><![CDATA[media_id]]></MediaId>"
				+ "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isBlank(data.getPicUrl()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getMediaId()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.shortvideo.toString()));
	}
	
	/**
	 * 测试接收到的地理位置消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testLocationNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[location]]></MsgType>"
				+ "<Location_X>23.134521</Location_X>"
				+ "<Location_Y>113.358803</Location_Y>"
				+ "<Scale>20</Scale>"
				+ "<Label><![CDATA[位置信息]]></Label>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isBlank(data.getPicUrl()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getLocationX() > 0);
		Assert.assertTrue(data.getLocationY() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.location.toString()));
	}
	
	/**
	 * 测试接收到的链接消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testLinkNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[link]]></MsgType>"
				+ "<Title><![CDATA[公众平台官网链接]]></Title>"
				+ "<Description><![CDATA[公众平台官网链接]]></Description>"
				+ "<Url><![CDATA[url]]></Url>"
				+ "<MsgId>1234567890123456</MsgId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(StringUtils.isBlank(data.getContent()));
		Assert.assertTrue(StringUtils.isBlank(data.getPicUrl()));
		Assert.assertTrue(data.getMsgId() > 0);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.link.toString()));
	}
	
	/**
	 * 测试接收到的关注事件消息
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testSubscribeNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[subscribe]]></Event>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.subscribe.toString()));
	}
	
	/**
	 * 测试接收到的用户未关注时，进行关注后的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testScanSubscribeNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[subscribe]]></Event>"
				+ "<EventKey><![CDATA[qrscene_123123]]></EventKey>"
				+ "<Ticket><![CDATA[TICKET]]></Ticket>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.subscribe.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
	}
	
	/**
	 * 测试接收到的扫码事件用户已关注时的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testScanNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[SCAN]]></Event>"
				+ "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>"
				+ "<Ticket><![CDATA[TICKET]]></Ticket>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.SCAN.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
	}
	
	/**
	 * 测试接收到上报地理位置事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testLocationEventNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[LOCATION]]></Event>"
				+ "<Latitude>23.137466</Latitude>"
				+ "<Longitude>113.352425</Longitude>"
				+ "<Precision>119.385040</Precision>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.LOCATION.toString()));
		Assert.assertTrue(data.getLatitude() > 0);
		Assert.assertTrue(data.getLongitude() > 0);
		Assert.assertTrue(data.getPrecision() > 0);
	}
	
	/**
	 * 测试接收到点击菜单拉取消息时的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuClickNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[CLICK]]></Event>"
				+ "<EventKey><![CDATA[EVENTKEY]]></EventKey>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.CLICK.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
	}
	
	/**
	 * 测试接收到点击菜单跳转链接时的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuViewNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[VIEW]]></Event>"
				+ "<EventKey><![CDATA[www.qq.com]]></EventKey>"
				+ "<MenuId>MENUID</MenuId>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.VIEW.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getMenuId()));
	}
	
	/**
	 * 测试接收到扫码推事件的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuScanCodeNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[scancode_push]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<ScanCodeInfo>"
				+ "<ScanType><![CDATA[qrcode]]></ScanType>"
				+ "<ScanResult><![CDATA[1]]></ScanResult>"
				+ "</ScanCodeInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.scancode_push.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getScanCodeInfo());
	}
	
	/**
	 * 测试接收到扫码推事件且弹出“消息接收中”提示框的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuScanWaitNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[scancode_waitmsg]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<ScanCodeInfo>"
				+ "<ScanType><![CDATA[qrcode]]></ScanType>"
				+ "<ScanResult><![CDATA[1]]></ScanResult>"
				+ "</ScanCodeInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.scancode_waitmsg.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getScanCodeInfo());
	}
	
	/**
	 * 测试接收到弹出系统拍照发图的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuSysphotoNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[pic_sysphoto]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<SendPicsInfo>"
				+ "<Count>1</Count>"
				+ "<PicList>"
				+ "<item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum></item>"
				+ "</PicList>"
				+ "</SendPicsInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.pic_sysphoto.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getSendPicsInfo());
	}
	
	/**
	 * 测试接收到弹出拍照或者相册发图的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuPhotoOrAlbumNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[pic_photo_or_album]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<SendPicsInfo>"
				+ "<Count>1</Count>"
				+ "<PicList>"
				+ "<item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum></item>"
				+ "</PicList>"
				+ "</SendPicsInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.pic_photo_or_album.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getSendPicsInfo());
	}
	
	/**
	 * 测试接收到弹出微信相册发图器的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuWinxinNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[pic_weixin]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<SendPicsInfo>"
				+ "<Count>1</Count>"
				+ "<PicList>"
				+ "<item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum></item>"
				+ "</PicList>"
				+ "</SendPicsInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.pic_weixin.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getSendPicsInfo());
	}
	
	/**
	 * 测试接收到弹出地理位置选择器的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testMenuLocationSelectNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[location_select]]></Event>"
				+ "<EventKey><![CDATA[6]]></EventKey>"
				+ "<SendLocationInfo>"
				+ "<Location_X><![CDATA[23]]></Location_X>"
				+ "<Location_Y><![CDATA[113]]></Location_Y>"
				+ "<Scale><![CDATA[15]]></Scale>"
				+ "<Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>"
				+ "<Poiname><![CDATA[]]></Poiname>"
				+ "</SendLocationInfo>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.location_select.toString()));
		Assert.assertTrue(StringUtils.isNotBlank(data.getEventKey()));
		Assert.assertNotNull(data.getSendLocationInfo());
	}
	
	/**
	 * 测试模版消息发送后的事件推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testTemplateMessageNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[TEMPLATESENDJOBFINISH]]></Event>"
				+ "<MsgId>200163836</MsgId>"
				+ "<Status><![CDATA[success]]></Status>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.TEMPLATESENDJOBFINISH.toString()));
	}
	
	/**
	 * 测试客服创建会话的通知推送
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testCustomCreateSessionNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[kf_create_session]]></Event>"
				+ "<KfAccount><![CDATA[test1@test]]></KfAccount>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.kf_create_session.toString()));
	}
	
	/**
	 * 测试客服关闭会话的通知推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testCustomCloseSessionNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[kf_close_session]]></Event>"
				+ "<KfAccount><![CDATA[test1@test]]></KfAccount>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.kf_close_session.toString()));
	}
	
	/**
	 * 测试客服转换会话的通知推送
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testCustomTransferSessionNotice() throws JsonParseException, JsonMappingException, IOException{
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[toUser]]></ToUserName>"
				+ "<FromUserName><![CDATA[fromUser]]></FromUserName>"
				+ "<CreateTime>1348831860</CreateTime>"
				+ "<MsgType><![CDATA[event]]></MsgType>"
				+ "<Event><![CDATA[kf_switch_session]]></Event>"
				+ "<FromKfAccount><![CDATA[test1@test]]></FromKfAccount>"
				+ "<ToKfAccount><![CDATA[test2@test]]></ToKfAccount>"
				+ "</xml>";
		ObjectMapper mapper = new XmlMapper();
		Notice data = mapper.readValue(xml, Notice.class);
		Assert.assertNotNull(data);
		Assert.assertTrue(data.getMsgType().equals(EnumMsgType.event.toString()));
		Assert.assertTrue(data.getEvent().equals(EnumEventType.kf_switch_session.toString()));
	}
}
