DROP TABLE IF EXISTS public.resource_alocateds;
CREATE TABLE public.resource_alocateds
(
    resource_id bigint NOT NULL,
    alocateds_id bigint NOT NULL,
    CONSTRAINT u_alocateds UNIQUE (alocateds_id),
    CONSTRAINT fk_alocateds_id FOREIGN KEY (alocateds_id)
        REFERENCES public.alocated (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_resource_id FOREIGN KEY (resource_id)
        REFERENCES public.resource (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
