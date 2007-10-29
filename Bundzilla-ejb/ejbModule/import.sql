insert into Role (id, name, version) values (1, 'admin', 1);
insert into Role (id, name, version) values (2, 'user', 1);
insert into User (id, name, password, email, version) values (1, "admin", "admin", "admin@bundzilla.com", 1);
insert into UserRole (id, user_id, role_id, version) values (1, 1, 1, 1);
insert into UserRole (id, user_id, role_id, version) values (2, 1, 2, 1);