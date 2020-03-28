INSERT INTO sessions (title, location, instructor) VALUES ('Blackboard', 'Union 100', 'Copus');
INSERT INTO sessions (title, location, instructor) VALUES ('Financial Aid - Billing', 'Union 101', 'Grebe');
INSERT INTO sessions (title, location, instructor) VALUES ('Public Safety', 'Union 102', 'Park');
INSERT INTO sessions (title, location, instructor) VALUES ('Google-It', 'Union 103', 'Tian');
INSERT INTO sessions (title, location, instructor) VALUES ('Your Success Network', 'Union 104', 'Zhou');
INSERT INTO sessions (title, location, instructor) VALUES ('UNIV 1400', 'Union 105', 'Chen');
INSERT INTO sessions (title, location, instructor) VALUES ('Time Management', 'Union 106', 'Ding');
INSERT INTO sessions (title, location, instructor) VALUES ('Curing a Case of Homesickness', 'Union 107', 'Kang');

INSERT INTO users(ucmoId, password, fname, lname, email, active) VALUES ('700000001', 'password', 'Christine', 'Falk', 'cvf71530@ucmo.edu',1);
INSERT INTO users(ucmoId, password, fname, lname, email, active) VALUES ('700000002', 'password', 'Kate', 'Pohlman', 'kxp70570@ucmo.edu',1);
INSERT INTO users(ucmoId, password, fname, lname, email, active) VALUES ('700000003', 'password', 'Olivia', 'Erickson', 'ole82660@ucmo.edu',1);

REPLACE INTO roles VALUE (1, 'USER');
REPLACE INTO roles VALUE (2, 'ADMIN');

REPLACE INTO users (ucmoId, password, fname, lname, email, active)
VALUES (1, '$2y$10$A50PPo/tm3skv9iguM4UpOJg3ZUulV0XMB3iuGpx7po4k9OcFrREO', 'Program', 'User', 'user@acme.com', TRUE);

REPLACE INTO users (ucmoId, password, fname, lname, email, active)
VALUES (2, '$2y$10$A50PPo/tm3skv9iguM4UpOJg3ZUulV0XMB3iuGpx7po4k9OcFrREO', 'Program', 'Admin', 'admin@acme.com', TRUE);

REPLACE INTO users (ucmoId, password, fname, lname, email, active)
VALUES (3, '$2a$10$INhB6JyK/oGQqM1dVKoBS.r.qJ9aJUWS7E9nXvrwyxfa7L8EXBlwa', 'Please', 'Work', 'pleaseWork@acme.com', TRUE);

REPLACE INTO user_role (user_id, role_id) VALUES (1,1);
REPLACE INTO user_role (user_id, role_id) VALUES (2,2);
REPLACE INTO user_role (user_id, role_id) VALUES (3,2);
