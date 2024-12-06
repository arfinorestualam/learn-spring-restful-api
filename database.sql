CREATE DATABASE belajar_spring_restful_api;

USE belajar_spring_restful_api;

CREATE TABLE users
(
    username            varchar(100)    NOT NULL ,
    password            varchar(100)    NOT NULL ,
    name                varchar(100)    NOT NULL ,
    token               varchar(100),
    token_expired_at    BIGINT,
    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE InnoDB;

SELECT * FROM users;