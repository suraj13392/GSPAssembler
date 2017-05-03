package com.gsp.mastek.registration.vo;

import java.util.List;

public class PartyAddressResponseVO {

	private Long partyId;
	
	private List<PartyAddressVO> address;

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public List<PartyAddressVO> getAddress() {
		return address;
	}

	public void setAddress(List<PartyAddressVO> address) {
		this.address = address;
	}
	
	public String toString(){
		return "PartyAddressResponseVO [partyID=" + partyId + ", address=" + address
				+ "]";
	}
	
}
