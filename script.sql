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


-----------------------------------------------
create table member (
    memberid varchar2(50) primary key,      --아이디(username)
    memberpw varchar2(100) not null,        -- 암호(password)암호화하는 길이 생각해서 넉넉히
    membername varchar2(50) not null,       -- 이름(추가)
    email varchar2(100) not null,           -- 이메일(추가)
    gender char(1) not null,                -- 성별(추가)
    enabled char(1) default '1' not null,   -- 활동유무(enabled)
    regdate date default sysdate not null   -- 회원가입 날짜(추가)
);

drop table member;


create table member_auth (
    memberid varchar2(50) not null,         -- ID(FK)
	auth varchar2(50) not null,        -- 권한(ROLE_XXX)
	constraint fk_member_auth foreign key(memberid) references member(memberid)
);

insert into member_auth (memberid, auth) values ('dog', 'ROLE_MEMBER');     
insert into member_auth (memberid, auth) values ('cat', 'ROLE_MEMBER');   
insert into member_auth (memberid, auth) values ('tiger', 'ROLE_ADMIN'); 
insert into member_auth (memberid, auth) values ('tiger', 'ROLE_MEMBER');

commit;

select * from member;
select * from member_auth;

select memberid as username, memberpw as password, enabled from member where memberid = 'cat';

select memberid as username, auth as authority from member_auth where memberid = ?;