package com.gsp.mastek.registration.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gsp.mastek.common.enums.EnumUtils;

public enum PartyType {
	PROPRIETER,PARTNER;

	@JsonCreator
	public static PartyType fromValue(String value) {
		return EnumUtils.getEnumFromString(PartyType.class, value);
	}

	@JsonValue
	public String toJson() {
		return name().toUpperCase();
	}

}
