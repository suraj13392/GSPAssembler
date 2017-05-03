package com.gsp.mastek.registration.vo;

import java.util.List;

public class PartyDetailsResponseVO {
	public List<PartyVO> party ;

	public List<PartyVO> getParty() {
		return party;
	}

	public void setParty(List<PartyVO> party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "PartyDetailsResponseVO [party=" + party + "]";
	}
}
