CREATE TABLE public.signal_type
(
    sit_id serial NOT NULL,
    sit_code text NOT NULL,
    sit_name text,
    sit_description text,
    CONSTRAINT sit_id_pk PRIMARY KEY (sit_id),
	CONSTRAINT sit_code_uk UNIQUE (sit_code)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.signal_type
    OWNER to postgres;