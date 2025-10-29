--SecurityTest > script.sql

--스프링 시큐리티에서 제공하는 테이블
create table users (
	username varchar2(50) not null primary key, -- ID
	password varchar2(50) not null,             -- 비밀번호
	enabled char(1) default '1'                 -- 계정 활성화 여부
);

create table authorities (
	username varchar2(50) not null,         -- ID(FK)
	authority varchar2(50) not null,        -- 권한
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);


insert into users (username, password) values ('dog', '1111');
insert into users (username, password) values ('cat', '1111');
insert into users (username, password) values ('tiger', '1111');

insert into authorities (username, authority) values ('dog', 'ROLE_USER');      -- 일반사용자
insert into authorities (username, authority) values ('cat', 'ROLE_MANAGER');   -- 중간관리자
insert into authorities (username, authority) values ('tiger', 'ROLE_ADMIN');   -- 관리자
insert into authorities (username, authority) values ('tiger', 'ROLE_MANAGER');

commit;

select * from users;

select * from authorities;