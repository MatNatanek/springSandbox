CREATE TABLE public.flyway
(
    id integer NOT NULL DEFAULT nextval('student_id_seq'::regclass),
    version text COLLATE pg_catalog."default",
    CONSTRAINT flyway_pkey PRIMARY KEY (id)
)

