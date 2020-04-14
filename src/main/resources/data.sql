INSERT INTO sessions (title, location, instructor) VALUES ('Blackboard', 'Union 100', 'Copus');
INSERT INTO sessions (title, location, instructor) VALUES ('Financial Aid - Billing', 'Union 101', 'Grebe');
INSERT INTO sessions (title, location, instructor) VALUES ('Public Safety', 'Union 102', 'Park');
INSERT INTO sessions (title, location, instructor) VALUES ('Google-It', 'Union 103', 'Tian');
INSERT INTO sessions (title, location, instructor) VALUES ('Your Success Network', 'Union 104', 'Zhou');
INSERT INTO sessions (title, location, instructor) VALUES ('UNIV 1400', 'Union 105', 'Chen');
INSERT INTO sessions (title, location, instructor) VALUES ('Time Management', 'Union 106', 'Ding');
INSERT INTO sessions (title, location, instructor) VALUES ('Curing a Case of Homesickness', 'Union 107', 'Kang');

REPLACE INTO roles VALUE (1, 'USER');
REPLACE INTO roles VALUE (2, 'ADMIN');

REPLACE INTO users (user_name, password, first_name, last_name, email, active)
VALUES (700000001, '$2y$10$A50PPo/tm3skv9iguM4UpOJg3ZUulV0XMB3iuGpx7po4k9OcFrREO', 'Christine', 'Falk', 'cvf71530@ucm.com', TRUE);

REPLACE INTO users (user_name, password, first_name, last_name, email, active)
VALUES (700000002, '$2y$10$A50PPo/tm3skv9iguM4UpOJg3ZUulV0XMB3iuGpx7po4k9OcFrREO', 'Kate', 'Pohlman', 'kxp70570@ucm.com', TRUE);

REPLACE INTO users (user_name, password, first_name, last_name, email, active)
VALUES (700000003, '$2y$10$A50PPo/tm3skv9iguM4UpOJg3ZUulV0XMB3iuGpx7po4k9OcFrREO', 'Olivia', 'Erickson', 'ole82660@ucm.com', TRUE);

REPLACE INTO user_role (user_name, role_id) VALUES (700000001,1);
REPLACE INTO user_role (user_name, role_id) VALUES (700000002,2);
REPLACE INTO user_role (user_name, role_id) VALUES (700000003,2);

REPLACE INTO session_attendance (id, user_name) VALUES (1,700000001);