DROP TABLE IF EXISTS sessions;
CREATE TABLE sessions (
    id          INT             NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255)    NOT NULL,
    location   VARCHAR(255)    NOT NULL,
    instructor  VARCHAR(255)    NOT NULL,
    PRIMARY KEY (id)
    );
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    ucmoId      VARCHAR(255)    NOT NULL,
    password    VARCHAR(255)    NOT NULL,
    fname       VARCHAR(255)    NOT NULL,
    lname       VARCHAR(255)    NOT NULL,
    email       VARCHAR(255)    NOT NULL,
    active      BIT             NOT NULL,
    PRIMARY KEY (ucmoId)
    );
