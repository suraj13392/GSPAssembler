CREATE TABLE public.roles
(
  id bigint NOT NULL,
  created_by_user character varying(255),
  creation_date timestamp without time zone,
  modification_date timestamp without time zone,
  modified_by_user character varying(255),
  role_name character varying(255),
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);