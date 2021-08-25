DROP SEQUENCE IF EXISTS public.alocated_seq;
CREATE SEQUENCE public.alocated_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.alocated;
CREATE TABLE public.alocated (
    id bigint primary key,
    resource_id  bigint,
    item_alocated_id bigint,
    quantity  int,
    created_at timestamp without time zone,
    CONSTRAINT fk_resource_id FOREIGN KEY (resource_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_item_alocated_id FOREIGN KEY (item_alocated_id)
        REFERENCES public.item (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)