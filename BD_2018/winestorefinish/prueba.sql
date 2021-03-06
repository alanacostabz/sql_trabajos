PGDMP     '    )    
            v            winestoreDB    10.4    10.4     g           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            h           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            i           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �            1259    25375 	   purchases    TABLE       CREATE TABLE winestore.purchases (
    purchase_id integer NOT NULL,
    costumer_id integer NOT NULL,
    date_of_purchase date NOT NULL,
    amount_of_purchase numeric(10,2) NOT NULL,
    amount_of_bottles integer NOT NULL,
    wine_store_id integer NOT NULL
);
     DROP TABLE winestore.purchases;
    	   winestore      	   developer    false            �            1259    25371    purchases_costumer_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_costumer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.purchases_costumer_id_seq;
    	   winestore    	   developer    false    245            j           0    0    purchases_costumer_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.purchases_costumer_id_seq OWNED BY winestore.purchases.costumer_id;
         	   winestore    	   developer    false    243            �            1259    25369    purchases_purchase_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_purchase_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.purchases_purchase_id_seq;
    	   winestore    	   developer    false    245            k           0    0    purchases_purchase_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.purchases_purchase_id_seq OWNED BY winestore.purchases.purchase_id;
         	   winestore    	   developer    false    242            �            1259    25373    purchases_wine_store_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_wine_store_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE winestore.purchases_wine_store_id_seq;
    	   winestore    	   developer    false    245            l           0    0    purchases_wine_store_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE winestore.purchases_wine_store_id_seq OWNED BY winestore.purchases.wine_store_id;
         	   winestore    	   developer    false    244            �
           2604    25378    purchases purchase_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN purchase_id SET DEFAULT nextval('winestore.purchases_purchase_id_seq'::regclass);
 G   ALTER TABLE winestore.purchases ALTER COLUMN purchase_id DROP DEFAULT;
    	   winestore    	   developer    false    242    245    245            �
           2604    25379    purchases costumer_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN costumer_id SET DEFAULT nextval('winestore.purchases_costumer_id_seq'::regclass);
 G   ALTER TABLE winestore.purchases ALTER COLUMN costumer_id DROP DEFAULT;
    	   winestore    	   developer    false    243    245    245            �
           2604    25380    purchases wine_store_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN wine_store_id SET DEFAULT nextval('winestore.purchases_wine_store_id_seq'::regclass);
 I   ALTER TABLE winestore.purchases ALTER COLUMN wine_store_id DROP DEFAULT;
    	   winestore    	   developer    false    244    245    245            d          0    25375 	   purchases 
   TABLE DATA                  	   winestore    	   developer    false    245          m           0    0    purchases_costumer_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.purchases_costumer_id_seq', 1, false);
         	   winestore    	   developer    false    243            n           0    0    purchases_purchase_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.purchases_purchase_id_seq', 54, true);
         	   winestore    	   developer    false    242            o           0    0    purchases_wine_store_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('winestore.purchases_wine_store_id_seq', 1, false);
         	   winestore    	   developer    false    244            �
           2606    25382    purchases purchases_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (purchase_id);
 E   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT purchases_pkey;
    	   winestore      	   developer    false    245            �
           1259    25431    fki_customer_id    INDEX     O   CREATE INDEX fki_customer_id ON winestore.purchases USING btree (costumer_id);
 &   DROP INDEX winestore.fki_customer_id;
    	   winestore      	   developer    false    245            �
           1259    25388    fki_wine_store_id    INDEX     S   CREATE INDEX fki_wine_store_id ON winestore.purchases USING btree (wine_store_id);
 (   DROP INDEX winestore.fki_wine_store_id;
    	   winestore      	   developer    false    245            �
           2606    33624    purchases customer_id    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT customer_id FOREIGN KEY (costumer_id) REFERENCES winestore.customer(customer_id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT customer_id;
    	   winestore    	   developer    false    245            �
           2606    25383    purchases wine_store_id    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT wine_store_id FOREIGN KEY (wine_store_id) REFERENCES winestore.wine_store(wine_store_id) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT wine_store_id;
    	   winestore    	   developer    false    245            d   Q  x�͖=k�0�w�
mI@1��S$:u�`()4iW�$*4q���=�1�o�-c?z��N�n�};�|wxe���oڪ��OW����7ly�,.g�NU�vW_�7��E�Y��଼Vݭ��ٱj�o���?E�#�Ί}<��o�l�gf��B	i��J/8�2!R�C�3kWOIN�� �3�\F�iMD,a$��1 1D��s�É`^�!F��&r,�ɥ-9'VFAO���&Fl�>�g�1b������cb�J���@��1��Qs�T�a�+H�X�18�$1b*DM�Lj��)��ábCX#0��}�C� F�L�he&����Pbf*     