package com.backend.achadosperdidos.entities.enums;

public enum FlagItem {
	FOUND_ITEM(1),
	LOST_ITEM(2);
	
	private int code;
	
	private FlagItem(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FlagItem valueOf(int code) {
		for (FlagItem value: FlagItem.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ItemFlag code");
	}
}
