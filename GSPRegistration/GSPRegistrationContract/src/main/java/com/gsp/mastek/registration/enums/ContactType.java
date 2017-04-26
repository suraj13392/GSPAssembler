package com.gsp.mastek.registration.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gsp.mastek.common.enums.EnumUtils;

public enum ContactType {
	FAX,PHONE,MOBILE,EMAIL;

	@JsonCreator
	public static ContactType fromValue(String value) {
		return EnumUtils.getEnumFromString(ContactType.class, value);
	}

	@JsonValue
	public String toJson() {
		return name().toUpperCase();
	}

}
