package com.gsp.mastek.registration.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gsp.mastek.common.enums.EnumUtils;

public enum Gender {
	MALE,FEMALE,OTHER;

	@JsonCreator
	public static Gender fromValue(String value) {
		return EnumUtils.getEnumFromString(Gender.class, value);
	}

	@JsonValue
	public String toJson() {
		return name().toUpperCase();
	}

}
