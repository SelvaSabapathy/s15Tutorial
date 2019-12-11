insert into user (user_id, name, email, username, password) values (next value for user_seq, 'Admin User', 'admin@sabapathy.com', 'admin', 'password');
insert into role (role_id, role) values (next value for role_seq, 'ADMIN');

insert into user_role (user_id, role_id) values (current value for user_seq, current value for role_seq);

insert into role (role_id, role) values (next value for role_seq, 'USER');

insert into user_role (user_id, role_id) values (current value for user_seq, current value for role_seq);
