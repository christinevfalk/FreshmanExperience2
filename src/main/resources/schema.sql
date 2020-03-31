DROP TABLE IF EXISTS sessions;
CREATE TABLE sessions (
    id              INT             NOT NULL AUTO_INCREMENT,
    title           VARCHAR(255)    NOT NULL,
    location        VARCHAR(255)    NOT NULL,
    instructor      VARCHAR(255)    NOT NULL,
    PRIMARY KEY (id)
    );
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_name       VARCHAR(255)    NOT NULL,
    password        VARCHAR(255)    NOT NULL,
    first_name      VARCHAR(255)    NOT NULL,
    last_name       VARCHAR(255)    NOT NULL,
    email           VARCHAR(255)    NOT NULL,
    active          BIT             NOT NULL,
    PRIMARY KEY (user_name)
    );
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
    role_id         INT             NOT NULL AUTO_INCREMENT,
    role            VARCHAR(255)    NOT NULL,
    PRIMARY KEY (role_id)
    );
