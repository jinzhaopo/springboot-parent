package com.jzp.framework.mvc;

import java.io.Serializable;

import com.jzp.framework.util.InternationalUtil;

/**
 * 
 * @ClassName: Message
 * @Description: 消息<br/>
 *               这个是用来做请求提示的
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月25日 上午9:31:27
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 2557891928459271003L;

	/**
	 * 消息类型
	 */
	private MessageType messageType;
	/**
	 * 内容提示
	 */
	private String content;

	public Message(MessageType messageType, String content, Object args[]) {
		this.messageType = messageType;
		this.content = InternationalUtil.getMessage(content, args);
	}
	
	public static Message success()
	

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
