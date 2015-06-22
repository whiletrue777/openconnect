drop database if exists test;
create database test;
use test;

drop table if exists login;
drop table if exists proto;
drop table if exists site;
drop table if exists admin;

create table if not exists login(
username varchar(100),
userId varchar(255),
password varchar(255)
);

create table if not exists proto(
id int,
name varchar(100),
goods varchar(100),
price int,
stock int
);

create table if not exists site(
id int(10) unique,
name varchar(255),
url varchar(255)
);

/*管理者情報*/
create table admin (
admin_id int(11),
admin_name varchar(100),
admin_pass varchar(100)
);

insert into login values('aaa','aaa','1234');
insert into login values('bbb','bbb','1234');
insert into login values('ccc','ddd','1234');
insert into login values('ddd','ddd','1234');


insert into proto(id,name,goods,price,stock)
values(1,'kuriya','book',100,3);

insert into proto(id,name,goods,price,stock)
values(2,'hosoya','sake',6000,33);

insert into proto(id,name,goods,price,stock)
values(3,'ikeda','book',100,3);

insert into proto(id,name,goods,price,stock)
values(4,'wada','vegitable',4000,30);

insert into proto(id,name,goods,price,stock)
values(5,'kishi','car',50000,29);



insert into site(id,name,url)
values(1,'March','http://www.internousdev.com:8080/YouJustJewelry/');

insert into site(id,name,url)
values(2,'February','http://www.internousdev.com:8080/solare/');

insert into site(id,name,url)
values(3,'January','http://www.internousdev.com:8080/UESTO/');


insert into admin values(1,'root','abcd');