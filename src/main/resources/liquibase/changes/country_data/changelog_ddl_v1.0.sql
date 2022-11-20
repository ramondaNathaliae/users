-- mysql
-- CREATE DATABASE "users_complete_database";


CREATE TABLE IF NOT EXISTS country(
    country_id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) UNIQUE NOT NULL,
    iso_code varchar(5) UNIQUE NOT NULL,
    country_code int UNIQUE NOT NULL);