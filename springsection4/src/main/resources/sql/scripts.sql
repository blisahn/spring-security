create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);


insert ignore into `users` values ('user','{noop}Uh%0HR2l6#_i','1');
insert ignore into `authorities` values ('user','read');

insert ignore into `users` values ('admin','{bcrypt}$2a$12$uCdzV9LPj8CauW35cYM39OJ2UHI3cGHAezkLb0yQzpOMTHcj/Gm9a','1');
insert ignore into `authorities` values ('admin','admin');
select * FROM `users`

CREATE TABLE `customer`(
                           `id` int not null auto_increment,
                           `email` varchar(45) not null ,
                           `pwd` varchar(200) not null ,
                           `role` varchar(45) not null,
                           PRIMARY KEY (`id`)
);

insert into `customer`(`email`, `pwd`, `role`)
values ('user@example.com', '{noop}Uh%0HR2l6#_i', 'read');

insert into `customer` (`email`, `pwd`, `role`)
values ('admin@example.com', '{bcrypt}$2a$12$uCdzV9LPj8CauW35cYM39OJ2UHI3cGHAezkLb0yQzpOMTHcj/Gm9a', 'admin');