CREATE DATABASE "curso-jsp"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE SEQUENCE public.serialuser
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 11
  CACHE 1;
ALTER TABLE public.serialuser
  OWNER TO postgres;

CREATE TABLE public.usuario
(
  id bigint NOT NULL DEFAULT nextval('serialuser'::regclass),  
  login character varying,
  senha character varying,
  nome character varying,
  telefone character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.usuario
  OWNER TO postgres;
