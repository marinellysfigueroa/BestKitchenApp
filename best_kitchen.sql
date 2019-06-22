--
-- PostgreSQL database dump
--

-- Dumped from database version 10.9 (Ubuntu 10.9-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.9 (Ubuntu 10.9-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: chef; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chef (
    pk_chef_id integer NOT NULL,
    name character varying(25) NOT NULL,
    first_last_name character varying(25) NOT NULL,
    second_last_name character varying(25)
);


ALTER TABLE public.chef OWNER TO postgres;

--
-- Name: chef_pk_chef_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chef_pk_chef_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.chef_pk_chef_id_seq OWNER TO postgres;

--
-- Name: chef_pk_chef_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.chef_pk_chef_id_seq OWNED BY public.chef.pk_chef_id;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    pk_client_id integer NOT NULL,
    name character varying(25) NOT NULL,
    firts_last_name character varying(25) NOT NULL,
    second_last_name character varying(25),
    observations character varying(50)
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_pk_client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_pk_client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_pk_client_id_seq OWNER TO postgres;

--
-- Name: client_pk_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_pk_client_id_seq OWNED BY public.client.pk_client_id;


--
-- Name: dining_table; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dining_table (
    pk_dining_table_id integer NOT NULL,
    max_number_diners integer DEFAULT 0 NOT NULL,
    location character varying(25) NOT NULL
);


ALTER TABLE public.dining_table OWNER TO postgres;

--
-- Name: dining_table_pk_dining_table_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dining_table_pk_dining_table_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.dining_table_pk_dining_table_id_seq OWNER TO postgres;

--
-- Name: dining_table_pk_dining_table_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dining_table_pk_dining_table_id_seq OWNED BY public.dining_table.pk_dining_table_id;


--
-- Name: invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice (
    pk_invoice_id integer NOT NULL,
    fk_client_id integer NOT NULL,
    fk_waiter_id integer NOT NULL,
    date timestamp with time zone DEFAULT now() NOT NULL,
    fk_dining_table_id integer NOT NULL
);


ALTER TABLE public.invoice OWNER TO postgres;

--
-- Name: invoice_detail; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice_detail (
    pk_invoice_detail_id integer NOT NULL,
    fk_invoice_id integer NOT NULL,
    fk_chef_id integer NOT NULL,
    plate character varying(25) NOT NULL,
    amount double precision DEFAULT 0.0 NOT NULL
);


ALTER TABLE public.invoice_detail OWNER TO postgres;

--
-- Name: invoice_detail_pk_invoice_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.invoice_detail_pk_invoice_detail_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invoice_detail_pk_invoice_detail_id_seq OWNER TO postgres;

--
-- Name: invoice_detail_pk_invoice_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invoice_detail_pk_invoice_detail_id_seq OWNED BY public.invoice_detail.pk_invoice_detail_id;


--
-- Name: invoice_pk_invoice_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.invoice_pk_invoice_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invoice_pk_invoice_id_seq OWNER TO postgres;

--
-- Name: invoice_pk_invoice_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invoice_pk_invoice_id_seq OWNED BY public.invoice.pk_invoice_id;


--
-- Name: vw_total_invoiced_by_invoice; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vw_total_invoiced_by_invoice AS
 SELECT sum(invoice_detail.amount) AS total,
    invoice_detail.fk_invoice_id
   FROM public.invoice_detail
  GROUP BY invoice_detail.fk_invoice_id;


ALTER TABLE public.vw_total_invoiced_by_invoice OWNER TO postgres;

--
-- Name: vw_total_invoced_by_client_vip; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vw_total_invoced_by_client_vip AS
 SELECT c.pk_client_id,
    c.name,
    c.firts_last_name,
    c.second_last_name,
    c.observations,
        CASE
            WHEN (tv.total IS NULL) THEN (0)::double precision
            ELSE tv.total
        END AS total
   FROM ((public.client c
     LEFT JOIN public.invoice i ON ((c.pk_client_id = i.fk_client_id)))
     LEFT JOIN public.vw_total_invoiced_by_invoice tv ON ((i.pk_invoice_id = tv.fk_invoice_id)))
  WHERE (tv.total > (100000)::double precision);


ALTER TABLE public.vw_total_invoced_by_client_vip OWNER TO postgres;

--
-- Name: waiter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.waiter (
    pk_waiter_id integer NOT NULL,
    name character varying(25) NOT NULL,
    first_last_name character varying(25) NOT NULL,
    second_last_name character varying(25)
);


ALTER TABLE public.waiter OWNER TO postgres;

--
-- Name: vw_total_invoiced_monthly_by_waiter; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.vw_total_invoiced_monthly_by_waiter AS
 SELECT w.pk_waiter_id,
    w.name,
    w.first_last_name,
    w.second_last_name,
    to_char(i.date, 'MM'::text) AS month,
    to_char(i.date, 'Month'::text) AS name_month,
    to_char(i.date, 'YYYY'::text) AS year,
    sum(
        CASE
            WHEN (tv.total IS NULL) THEN (0)::double precision
            ELSE tv.total
        END) AS total
   FROM ((public.waiter w
     LEFT JOIN public.invoice i ON ((w.pk_waiter_id = i.fk_waiter_id)))
     LEFT JOIN public.vw_total_invoiced_by_invoice tv ON ((i.pk_invoice_id = tv.fk_invoice_id)))
  GROUP BY w.pk_waiter_id, w.name, w.first_last_name, w.second_last_name, (to_char(i.date, 'MM'::text)), (to_char(i.date, 'Month'::text)), (to_char(i.date, 'YYYY'::text));


ALTER TABLE public.vw_total_invoiced_monthly_by_waiter OWNER TO postgres;

--
-- Name: waiter_pk_waiter_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.waiter_pk_waiter_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.waiter_pk_waiter_id_seq OWNER TO postgres;

--
-- Name: waiter_pk_waiter_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.waiter_pk_waiter_id_seq OWNED BY public.waiter.pk_waiter_id;


--
-- Name: chef pk_chef_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chef ALTER COLUMN pk_chef_id SET DEFAULT nextval('public.chef_pk_chef_id_seq'::regclass);


--
-- Name: client pk_client_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN pk_client_id SET DEFAULT nextval('public.client_pk_client_id_seq'::regclass);


--
-- Name: dining_table pk_dining_table_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dining_table ALTER COLUMN pk_dining_table_id SET DEFAULT nextval('public.dining_table_pk_dining_table_id_seq'::regclass);


--
-- Name: invoice pk_invoice_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice ALTER COLUMN pk_invoice_id SET DEFAULT nextval('public.invoice_pk_invoice_id_seq'::regclass);


--
-- Name: invoice_detail pk_invoice_detail_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_detail ALTER COLUMN pk_invoice_detail_id SET DEFAULT nextval('public.invoice_detail_pk_invoice_detail_id_seq'::regclass);


--
-- Name: waiter pk_waiter_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waiter ALTER COLUMN pk_waiter_id SET DEFAULT nextval('public.waiter_pk_waiter_id_seq'::regclass);


--
-- Data for Name: chef; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chef (pk_chef_id, name, first_last_name, second_last_name) FROM stdin;
1	Diana	Miranda	Aponte
3	Jose	Martinez	Villalobos
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (pk_client_id, name, firts_last_name, second_last_name, observations) FROM stdin;
1	Roberto	Guariato	Delgado	Cliente VIP
2	Jhon	Benitez	Lopez	
\.


--
-- Data for Name: dining_table; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dining_table (pk_dining_table_id, max_number_diners, location) FROM stdin;
1	1	1ra derecha
\.


--
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice (pk_invoice_id, fk_client_id, fk_waiter_id, date, fk_dining_table_id) FROM stdin;
1	1	1	2019-06-21 17:30:45.977601-05	1
\.


--
-- Data for Name: invoice_detail; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice_detail (pk_invoice_detail_id, fk_invoice_id, fk_chef_id, plate, amount) FROM stdin;
\.


--
-- Data for Name: waiter; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.waiter (pk_waiter_id, name, first_last_name, second_last_name) FROM stdin;
1	Javier	Apote	Hernandez
2	Laura	Palacios	Sifonte
\.


--
-- Name: chef_pk_chef_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.chef_pk_chef_id_seq', 3, true);


--
-- Name: client_pk_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_pk_client_id_seq', 2, true);


--
-- Name: dining_table_pk_dining_table_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dining_table_pk_dining_table_id_seq', 1, true);


--
-- Name: invoice_detail_pk_invoice_detail_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoice_detail_pk_invoice_detail_id_seq', 1, false);


--
-- Name: invoice_pk_invoice_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoice_pk_invoice_id_seq', 1, true);


--
-- Name: waiter_pk_waiter_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.waiter_pk_waiter_id_seq', 2, true);


--
-- Name: chef chef_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chef
    ADD CONSTRAINT chef_pkey PRIMARY KEY (pk_chef_id);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (pk_client_id);


--
-- Name: dining_table dining_table_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dining_table
    ADD CONSTRAINT dining_table_pkey PRIMARY KEY (pk_dining_table_id);


--
-- Name: invoice_detail invoice_detail_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_detail
    ADD CONSTRAINT invoice_detail_pkey PRIMARY KEY (pk_invoice_detail_id);


--
-- Name: invoice invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (pk_invoice_id);


--
-- Name: waiter waiter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.waiter
    ADD CONSTRAINT waiter_pkey PRIMARY KEY (pk_waiter_id);


--
-- Name: invoice fk_invoice_client; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT fk_invoice_client FOREIGN KEY (pk_invoice_id) REFERENCES public.client(pk_client_id);


--
-- Name: invoice_detail fk_invoice_detail_chef; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_detail
    ADD CONSTRAINT fk_invoice_detail_chef FOREIGN KEY (fk_chef_id) REFERENCES public.chef(pk_chef_id);


--
-- Name: invoice_detail fk_invoice_detail_invoice; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_detail
    ADD CONSTRAINT fk_invoice_detail_invoice FOREIGN KEY (fk_invoice_id) REFERENCES public.invoice(pk_invoice_id);


--
-- Name: invoice fk_invoice_dining_table; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT fk_invoice_dining_table FOREIGN KEY (fk_dining_table_id) REFERENCES public.dining_table(pk_dining_table_id);


--
-- Name: invoice fk_invoice_waiter; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT fk_invoice_waiter FOREIGN KEY (fk_waiter_id) REFERENCES public.waiter(pk_waiter_id);


--
-- PostgreSQL database dump complete
--

