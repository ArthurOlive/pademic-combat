DROP SEQUENCE IF EXISTS public.order_seq;
CREATE SEQUENCE public.order_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

DROP TABLE IF EXISTS public.order_migration;
CREATE TABLE public.order_migration
(   
    id bigint primary key,
    hospital1_id bigint NOT NULL,
    hospital2_id   bigint NOT NULL,
    resource1_id bigint NOT NULL,
    resource2_id bigint NOT NULL,
    status int,
    message varchar(255),
    created_at timestamp without time zone,
    CONSTRAINT fk_hospital2 FOREIGN KEY (hospital1_id)
        REFERENCES public.hospital (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_hospital1 FOREIGN KEY (hospital2_id)
        REFERENCES public.hospital (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_resource1 FOREIGN KEY (resource1_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_resource2 FOREIGN KEY (resource2_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
