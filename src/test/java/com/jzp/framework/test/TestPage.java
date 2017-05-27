package com.jzp.framework.test;

import com.jzp.framework.model.BaseEntity;
import com.jzp.framework.page.Page;

public class TestPage {
	public static void main(String[] args) {
		getPageInfo();
	}

	public static void getPageInfo() {
		Page<BaseEntity> page = new Page<BaseEntity>();
		System.out.println(page.getPageSize());
	}
}
