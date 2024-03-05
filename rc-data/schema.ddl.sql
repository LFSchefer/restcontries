-- CREATE DATABASE restcontries;

CREATE TABLE t_countries (
id serial primary key,
flag_png varchar(40) not null,
country_capital varchar(200) not null,
country_population bigint not null,
country_name varchar(60) not null,
country_area decimal(10,2) not null,
tld char(2) unique,
iso_code char(2) not null unique ,
coat_of_arms_png varchar(60), 
google_map varchar(50) not null
);