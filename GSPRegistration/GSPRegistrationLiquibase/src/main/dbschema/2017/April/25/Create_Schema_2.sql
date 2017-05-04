/* These table scripts are generated through Hibernate */

CREATE TABLE party.revinfo
(
  rev integer NOT NULL,
  revtstmp bigint,
  CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.business_dtls_aud
(
  businessdtls_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  center_jurisdiction character varying(255),
  commissionarate_cd character varying(255),
  division_cd character varying(255),
  range_cd character varying(255),
  state_cd character varying(255),
  state_jurisdiction character varying(255),
  ward_circle_sector_num character varying(255),
  organization_id bigint,
  CONSTRAINT business_dtls_aud_pkey PRIMARY KEY (businessdtls_id, rev),
  CONSTRAINT fksjxlbv2pfkc3pw3w1lp8w4yd8 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE party.goods_dtls_aud
(
  goodsdtls_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  goods_description character varying(255),
  hsn_code character varying(255),
  organization_id bigint,
  CONSTRAINT goods_dtls_aud_pkey PRIMARY KEY (goodsdtls_id, rev),
  CONSTRAINT fkqth28lj0ukg5s8hqcy4wq5pjk FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE party.gstnregistration_dtls_aud
(
  gstnregistrationdtls_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  gstin character varying(255),
  state_cd character varying(255),
  CONSTRAINT gstnregistration_dtls_aud_pkey PRIMARY KEY (gstnregistrationdtls_id, rev),
  CONSTRAINT fkkhbiyh2ettb2c45hwa2jbdft2 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.membership_aud
(
  rev integer NOT NULL,
  organization_id bigint NOT NULL,
  party_id bigint NOT NULL,
  revtype smallint,
  CONSTRAINT membership_aud_pkey PRIMARY KEY (rev, organization_id, party_id)
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.organization_address_aud
(
  organizationaddress_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  building_name character varying(255),
  building_number character varying(255),
  district character varying(255),
  floor_number character varying(255),
  locality character varying(255),
  pin_code character varying(255),
  state_cd character varying(255),
  street character varying(255),
  CONSTRAINT organization_address_aud_pkey PRIMARY KEY (organizationaddress_id, rev),
  CONSTRAINT fkni2fhuh64ncyha4ujfdsobwg6 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.organization_aud
(
  organization_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  commencement_dt date,
  gstn_registration_dt date,
  legal_name character varying(255),
  organization_status character varying(255),
  pan_number character varying(255),
  trade_name character varying(255),
  CONSTRAINT organization_aud_pkey PRIMARY KEY (organization_id, rev),
  CONSTRAINT fkjc7pc3ombplinmhjykfmu9ckg FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.organization_contact_aud
(
  organizationcontact_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  address_id bigint,
  contact_type character varying(255),
  contact_value character varying(255),
  CONSTRAINT organization_contact_aud_pkey PRIMARY KEY (organizationcontact_id, rev),
  CONSTRAINT fkg20luoesnx2j9bgksj78pci6p FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.organization_contactpreference_aud
(
  organizationcontactpreference_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  contact_id bigint,
  preferred_day character varying(255),
  preferred_timefrom character varying(255),
  preferred_timeto character varying(255),
  CONSTRAINT organization_contactpreference_aud_pkey PRIMARY KEY (organizationcontactpreference_id, rev),
  CONSTRAINT fkh3qv7v4ww55wlmb5xyfonf48i FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.party_address_aud
(
  partyaddress_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  building_name character varying(255),
  building_number character varying(255),
  district character varying(255),
  floor_number character varying(255),
  locality character varying(255),
  pin_code character varying(255),
  state_cd character varying(255),
  street character varying(255),
  CONSTRAINT party_address_aud_pkey PRIMARY KEY (partyaddress_id, rev),
  CONSTRAINT fksr2hia37wqpsluhfwuigtxjr6 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.party_aud
(
  party_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  aadhar_number character varying(255),
  date_of_birth date,
  designation character varying(255),
  din_number character varying(255),
  father_first_name character varying(255),
  father_last_name character varying(255),
  father_middle_name character varying(255),
  first_name character varying(255),
  gender character varying(255),
  husband_first_name character varying(255),
  husband_last_name character varying(255),
  husband_middle_name character varying(255),
  is_indian_citizen character varying(255),
  last_name character varying(255),
  middle_name character varying(255),
  pan_number character varying(255),
  party_status character varying(255),
  party_type character varying(255),
  passport_number character varying(255),
  CONSTRAINT party_aud_pkey PRIMARY KEY (party_id, rev),
  CONSTRAINT fksj6yj7ketv55r5ifggoffg4u4 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.party_contact_aud
(
  partycontact_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  contact_type character varying(255),
  contact_value character varying(255),
  CONSTRAINT party_contact_aud_pkey PRIMARY KEY (partycontact_id, rev),
  CONSTRAINT fkg7rkawo7km5qar461lbn77g87 FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

CREATE TABLE party.partycontact_preference_aud
(
  partycontactpreference_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  preferred_day character varying(255),
  preferred_timefrom character varying(255),
  preferred_timeto character varying(255),
  CONSTRAINT partycontact_preference_aud_pkey PRIMARY KEY (partycontactpreference_id, rev),
  CONSTRAINT fkqwbcprv63iulholmlgiv3d0vy FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);


CREATE TABLE party.service_dtls_aud
(
  servicedtls_id bigint NOT NULL,
  rev integer NOT NULL,
  revtype smallint,
  activity_id bigint,
  created_by character varying(255),
  created_dt timestamp without time zone,
  request_id bigint,
  updated_by character varying(255),
  updated_dt timestamp without time zone,
  sac_code character varying(255),
  service_description character varying(255),
  organization_id bigint,
  CONSTRAINT service_dtls_aud_pkey PRIMARY KEY (servicedtls_id, rev),
  CONSTRAINT fkgm9espa0uuq32fdgkmg7dvl3s FOREIGN KEY (rev)
      REFERENCES party.revinfo (rev) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

