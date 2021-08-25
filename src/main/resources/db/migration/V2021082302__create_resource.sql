DROP SEQUENCE IF EXISTS public.resource_seq;
CREATE SEQUENCE public.resource_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.resource;
CREATE TABLE public.resource (
    id bigint primary key,
    created_at timestamp without time zone
)