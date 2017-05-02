package com.gsp.mastek.registration.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;

public class OrganizationSpecs {
	
	public static Specification<Organization> findByCriteria(final SearchRegDtlsCriteriaVO searchCriteria) {

        return new Specification<Organization>() {

            @Override
            public Predicate toPredicate(
                Root<Organization> root,
                CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<Predicate>();
                Join jGSTN = root.join("gstnregistrationDtlses",JoinType.LEFT);
                Join jParties = root.join("parties",JoinType.LEFT);

                if (StringUtils.isNotEmpty(searchCriteria.getPanNumber())) {
                    predicates.add(cb.equal(root.get("panNumber"), searchCriteria.getPanNumber()));
                }
                if (searchCriteria.getOrganizationId()!= null) {
                    predicates.add(cb.equal(root.get("organizationId"), searchCriteria.getOrganizationId()));
                }
                if (StringUtils.isNotEmpty(searchCriteria.getAadharNumber())) {
                    predicates.add(cb.equal(jParties.get("aadharNumber"), searchCriteria.getAadharNumber()));
                }
                if (StringUtils.isNotEmpty(searchCriteria.getGstin())) {
                    predicates.add(cb.equal(jGSTN.get("gstin"), searchCriteria.getGstin()));
                }
                if (StringUtils.isNotEmpty(searchCriteria.getUserName())) {
                    predicates.add(cb.equal(jParties.get("lastName"), searchCriteria.getUserName()));
                }
                if (StringUtils.isNotEmpty(searchCriteria.getPartyStatus())) {
                    predicates.add(cb.equal(jParties.get("partyStatus"), searchCriteria.getPartyStatus()));
                }
                if (searchCriteria.getPartyId()!= null) {
                    predicates.add(cb.equal(jParties.get("partyId"), searchCriteria.getPartyId()));
                }
                
                return cb.and(predicates.toArray(new Predicate[] {}));
            }
        };
    }

}
