package com.jzp.framework.test;

import com.jzp.framework.util.SearchFilterUtil;

public class Test {

	public static void main(String[] args) {
		testSearchFilterUtil();
	}

	public static void testSearchFilterUtil() {
		System.out.println(SearchFilterUtil.getInstance().addEq("id", 3).getSearchFilter().size());
	}
}
