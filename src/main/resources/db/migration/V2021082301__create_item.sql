DROP SEQUENCE IF EXISTS public.item_seq;
CREATE SEQUENCE public.item_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.item;
CREATE TABLE public.item (
    id bigint primary key,
    name varchar(255) unique,
    points int,
    created_at timestamp without time zone
)