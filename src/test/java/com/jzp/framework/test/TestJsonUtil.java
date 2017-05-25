package com.jzp.framework.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.jzp.framework.util.JsonUtil;

public class TestJsonUtil {

	public static void main(String[] args) {
		User user = new User();
		user.setId(5L);
		user.setName("我是谁");

		System.out.println(((User) JsonUtil.getInstance().json2obj(JsonUtil.getInstance().obj2json(user), User.class)).getName());

		String json = JsonUtil.getInstance().obj2json(user);
		String[] fileds = { "id", "name" };
		Object obj = JsonUtil.getInstance().parseJsonStrToList(json, user.getClass().getName(), fileds);
		if(obj instanceof User){
			System.out.println(obj.toString());
			
		}
	}
}
