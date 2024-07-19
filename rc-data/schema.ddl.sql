-- CREATE DATABASE restcontries;

CREATE TABLE t_countries (
id serial primary key,
flag_png varchar(120) not null,
country_capital varchar(200),
country_population bigint not null,
country_name varchar(80) not null,
country_area decimal(10,2) not null,
tld char(3),
iso_code char(2) not null unique ,
coat_of_arms_png varchar(120), 
google_map varchar(120) not null
);