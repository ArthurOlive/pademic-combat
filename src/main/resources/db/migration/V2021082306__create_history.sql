DROP SEQUENCE IF EXISTS public.history_seq;
CREATE SEQUENCE public.history_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.history;
CREATE TABLE public.history
(   
    id bigint primary key,
    hospital_from_id bigint NOT NULL,
    hospital_to_id   bigint NOT NULL,
    resource_id bigint NOT NULL,
    created_at timestamp without time zone,
    CONSTRAINT fk_from FOREIGN KEY (hospital_from_id)
        REFERENCES public.hospital (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_to FOREIGN KEY (hospital_to_id)
        REFERENCES public.hospital (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_resource_id FOREIGN KEY (resource_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
