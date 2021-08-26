DROP SEQUENCE IF EXISTS public.hospital_seq;
CREATE SEQUENCE public.hospital_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.hospital;
CREATE TABLE public.hospital (
    id bigint primary key,
    name varchar(255) unique,
    cnpj varchar(14),
    address varchar(255),
    lat decimal(10, 8),
    log decimal(10, 8),
    percent decimal(10, 2),
    resource_id bigint,
    created_at timestamp without time zone,
    CONSTRAINT fk_resource_id FOREIGN KEY (resource_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)