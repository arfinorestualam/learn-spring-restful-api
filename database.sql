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

SELECT * FROM contacts;

CREATE TABLE contacts
(
    id          VARCHAR(100)    NOT NULL ,
    username    VARCHAR(100)    NOT NULL ,
    first_name  VARCHAR(100)    NOT NULL ,
    last_name   VARCHAR(100),
    phone       VARCHAR(100),
    email       VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY fk_users_contacts (username) REFERENCES users (username)
) ENGINE InnoDB;