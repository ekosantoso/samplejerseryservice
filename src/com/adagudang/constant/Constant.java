package com.adagudang.constant;

public enum Constant {
	//db2 aws
	Connection("jdbc:postgresql://adagudang.c00arblb3cr3.ap-southeast-1.rds.amazonaws.com/adagudang")
	,User("adagudang")
	,Password("adagudang");
	//google
	
	private String text;

	Constant(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
	
}
