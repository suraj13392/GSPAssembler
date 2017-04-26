/*
Created: 4/10/2017
Modified: 4/19/2017
Model: PostgreSQL 9.4
Database: PostgreSQL 9.4
*/

-- Create schemas section -------------------------------------------------
/*
CREATE SCHEMA "party"
; */

-- Create tables section -------------------------------------------------

-- Table party.party

CREATE TABLE "party"."party"(
 "party_id" Bigint NOT NULL,
 "party_type" Character varying(50) NOT NULL,
 "first_name" Character varying(100) NOT NULL,
 "middle_name" Character varying(100),
 "last_name" Character varying(100) NOT NULL,
 "father_first_name" Character varying(100),
 "father_middle_name" Character varying(100),
 "father_last_name" Character varying(100),
 "husband_first_name" Character varying(100),
 "husband_middle_name" Character varying(100),
 "husband_last_name" Character varying(100),
 "designation" Character varying(50),
 "gender" Character varying(50),
 "date_of_birth" Date,
 "is_indian_citizen" Character varying(50),
 "pan_number" Character varying(10),
 "passport_number" Character varying(15),
 "aadhar_number" Character varying(12),
 "din_number" Character varying(8),
 "party_status" Character varying(50) NOT NULL,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Add keys for table party.party

ALTER TABLE "party"."party" ADD CONSTRAINT "pk_party_id" PRIMARY KEY ("party_id")
;

-- Table party.organization

CREATE TABLE "party"."organization"(
 "organization_id" Bigint NOT NULL,
 "legal_name" Character varying(100) NOT NULL,
 "trade_name" Character varying(100),
 "pan_number" Character varying(10) NOT NULL,
 "commencement_dt" Date NOT NULL,
 "gstn_registration_dt" Date,
 "organization_status" Character varying(50) NOT NULL,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Add keys for table party.organization

ALTER TABLE "party"."organization" ADD CONSTRAINT "pk_organization_id" PRIMARY KEY ("organization_id")
;

-- Table party.membership

CREATE TABLE "party"."membership"(
 "membership_id" Bigint NOT NULL,
 "organization_id" Bigint,
 "party_id" Bigint,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "userprofile_id" Bigint NOT NULL,
 "created_dt" Timestamp,
 "created_by" Character varying(50),
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.membership

CREATE INDEX "IX_membership_party_id" ON "party"."membership" ("party_id")
;

CREATE INDEX "IX_membership_organization_id" ON "party"."membership" ("organization_id")
;

-- Add keys for table party.membership

ALTER TABLE "party"."membership" ADD CONSTRAINT "pk_membership_id" PRIMARY KEY ("membership_id")
;

-- Table party.party_address

CREATE TABLE "party"."party_address"(
 "partyaddress_id" Bigint NOT NULL,
 "building_number" Character varying(100),
 "floor_number" Character varying(100),
 "building_name" Character varying(100),
 "street" Character varying(100),
 "locality" Character varying(100),
 "district" Character varying(50),
 "state_cd" Character varying(50),
 "pin_code" Character varying(6),
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "party_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.party_address

CREATE INDEX "IX_partyaddress_party_id" ON "party"."party_address" ("party_id")
;

-- Add keys for table party.party_address

ALTER TABLE "party"."party_address" ADD CONSTRAINT "pk_partyaddress_id" PRIMARY KEY ("partyaddress_id")
;

-- Table party.organization_address

CREATE TABLE "party"."organization_address"(
 "organizationaddress_id" Bigint NOT NULL,
 "building_number" Character varying(100),
 "floor_number" Character varying(100),
 "building_name" Character varying(100),
 "street" Character varying(100),
 "locality" Character varying(100),
 "district" Character varying(50),
 "state_cd" Character varying(50),
 "pin_code" Character varying(6),
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "organization_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.organization_address

CREATE INDEX "IX_organization_address_organization_id" ON "party"."organization_address" ("organization_id")
;

-- Add keys for table party.organization_address

ALTER TABLE "party"."organization_address" ADD CONSTRAINT "pk_organizationaddress_id" PRIMARY KEY ("organizationaddress_id")
;

-- Table party.party_contact

CREATE TABLE "party"."party_contact"(
 "partycontact_id" Bigint NOT NULL,
 "contact_type" Character varying(50),
 "contact_value" Character varying(100),
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "partyaddress_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.party_contact

CREATE INDEX "IX_partycontact_partyaddress_id" ON "party"."party_contact" ("partyaddress_id")
;

-- Add keys for table party.party_contact

ALTER TABLE "party"."party_contact" ADD CONSTRAINT "pk_partycontact_id" PRIMARY KEY ("partycontact_id")
;

-- Table party.organization_contact

CREATE TABLE "party"."organization_contact"(
 "organizationcontact_id" Bigint NOT NULL,
 "contact_type" Character varying(50),
 "contact_value" Character varying(100),
 "address_id" Bigint,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "organizationaddress_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.organization_contact

CREATE INDEX "IX_organizationcontact_organizationaddress_id" ON "party"."organization_contact" ("organizationaddress_id")
;

-- Add keys for table party.organization_contact

ALTER TABLE "party"."organization_contact" ADD CONSTRAINT "pk_organizationcontact_id" PRIMARY KEY ("organizationcontact_id")
;

-- Table party.partycontact_preference

CREATE TABLE "party"."partycontact_preference"(
 "partycontactpreference_id" Bigint NOT NULL,
 "preferred_day" Character varying(50),
 "preferred_timefrom" Character varying(20) NOT NULL,
 "preferred_timeto" Character varying(20) NOT NULL,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "partycontact_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.partycontact_preference

CREATE INDEX "IX_partycontactpreference_partycontact_id" ON "party"."partycontact_preference" ("partycontact_id")
;

-- Add keys for table party.partycontact_preference

ALTER TABLE "party"."partycontact_preference" ADD CONSTRAINT "pk_partycontactpreference_id" PRIMARY KEY ("partycontactpreference_id")
;

-- Table party.organization_contactpreference

CREATE TABLE "party"."organization_contactpreference"(
 "organizationcontactpreference_id" Bigint NOT NULL,
 "preferred_day" Character varying(50),
 "preferred_timefrom" Character varying(20) NOT NULL,
 "preferred_timeto" Character varying(20),
 "contact_id" Bigint,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "organizationcontact_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.organization_contactpreference

CREATE INDEX "IX_organizationcontactpreference_organizationcontact_id" ON "party"."organization_contactpreference" ("organizationcontact_id")
;

-- Add keys for table party.organization_contactpreference

ALTER TABLE "party"."organization_contactpreference" ADD CONSTRAINT "pk_organizationcontactpreference_id" PRIMARY KEY ("organizationcontactpreference_id")
;

-- Table party.business_dtls

CREATE TABLE "party"."business_dtls"(
 "businessdtls_id" Bigint NOT NULL,
 "state_cd" Character varying(50),
 "state_jurisdiction" Character varying(50),
 "ward_circle_sector_num" Character varying(50),
 "center_jurisdiction" Character varying(50),
 "range_cd" Character varying(50),
 "commissionarate_cd" Character varying(50),
 "division_cd" Character varying(50),
 "organization_id" Bigint,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.business_dtls

CREATE INDEX "IX_businessdtls_organization_id" ON "party"."business_dtls" ("organization_id")
;

-- Add keys for table party.business_dtls

ALTER TABLE "party"."business_dtls" ADD CONSTRAINT "pk_businessdtls_id" PRIMARY KEY ("businessdtls_id")
;

-- Table party.gstnregistration_dtls

CREATE TABLE "party"."gstnregistration_dtls"(
 "gstnregistrationdtls_id" Bigint NOT NULL,
 "state_cd" Character varying(50) NOT NULL,
 "gstin" Character varying(15) NOT NULL,
 "organization_id" Bigint,
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.gstnregistration_dtls

CREATE INDEX "IX_gstnregistrationdtls_organization_id" ON "party"."gstnregistration_dtls" ("organization_id")
;

-- Add keys for table party.gstnregistration_dtls

ALTER TABLE "party"."gstnregistration_dtls" ADD CONSTRAINT "pk_gstnregistrationdtls_id" PRIMARY KEY ("gstnregistrationdtls_id")
;

-- Table party.goods_dtls

CREATE TABLE "party"."goods_dtls"(
 "goodsdtls_id" Bigint NOT NULL,
 "goods_description" Character varying(50),
 "hsn_code" Character varying(10),
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50),
 "organization_id" Bigint
)
;

-- Create indexes for table party.goods_dtls

CREATE INDEX "IX_goodsdtls_organization_id" ON "party"."goods_dtls" ("organization_id")
;

-- Add keys for table party.goods_dtls

ALTER TABLE "party"."goods_dtls" ADD CONSTRAINT "pk_goodsdtls_id" PRIMARY KEY ("goodsdtls_id")
;

-- Table party.service_dtls

CREATE TABLE "party"."service_dtls"(
 "servicedtls_id" Bigint NOT NULL,
 "service_description" Character varying(50),
 "sac_code" Character varying(8),
 "request_id" Bigint NOT NULL,
 "activity_id" Bigint NOT NULL,
 "organization_id" Bigint,
 "created_dt" Timestamp NOT NULL,
 "created_by" Character varying(50) NOT NULL,
 "updated_dt" Timestamp,
 "updated_by" Character varying(50)
)
;

-- Create indexes for table party.service_dtls

CREATE INDEX "IX_servicedtls_organization_id" ON "party"."service_dtls" ("organization_id")
;

-- Add keys for table party.service_dtls

ALTER TABLE "party"."service_dtls" ADD CONSTRAINT "pk_servicedtls_id" PRIMARY KEY ("servicedtls_id")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "party"."membership" ADD CONSTRAINT "party_membership" FOREIGN KEY ("party_id") REFERENCES "party"."party" ("party_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."membership" ADD CONSTRAINT "organization_membership" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."business_dtls" ADD CONSTRAINT "organization_businessdtls" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."gstnregistration_dtls" ADD CONSTRAINT "organization_gstnregistrationdtls" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."party_address" ADD CONSTRAINT "party_partyaddress" FOREIGN KEY ("party_id") REFERENCES "party"."party" ("party_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."party_contact" ADD CONSTRAINT "partyaddress_partycontact" FOREIGN KEY ("partyaddress_id") REFERENCES "party"."party_address" ("partyaddress_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."partycontact_preference" ADD CONSTRAINT "partycontact_partycontactpreference" FOREIGN KEY ("partycontact_id") REFERENCES "party"."party_contact" ("partycontact_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."organization_address" ADD CONSTRAINT "organization_organizationaddress" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."organization_contact" ADD CONSTRAINT "organizationaddress_organizationcontact" FOREIGN KEY ("organizationaddress_id") REFERENCES "party"."organization_address" ("organizationaddress_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."organization_contactpreference" ADD CONSTRAINT "organizationcontact_organizationcontactpreference" FOREIGN KEY ("organizationcontact_id") REFERENCES "party"."organization_contact" ("organizationcontact_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."goods_dtls" ADD CONSTRAINT "organization_goodsdtls" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "party"."service_dtls" ADD CONSTRAINT "organization_servicedtls" FOREIGN KEY ("organization_id") REFERENCES "party"."organization" ("organization_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;




