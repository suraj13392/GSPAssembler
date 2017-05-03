package com.gsp.mastek.registration.vo;

import java.util.List;

public class PartyContactResponseVO {
	
	private Long partyID;
	
	private List<PartyContactVO> contactDetails;

	public Long getPartyID() {
		return partyID;
	}

	public void setPartyID(Long partyID) {
		this.partyID = partyID;
	}

	public List<PartyContactVO> getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(List<PartyContactVO> contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	@Override
	public String toString(){
		return "PartyContactResponseVO [partyID=" + partyID + ", contactDetails=" + contactDetails
				+ "]";
	}

}
