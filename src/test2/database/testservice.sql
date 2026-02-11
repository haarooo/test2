drop database if exists testservice;
create database testservice;
use testservice;

create table product(
	bno int auto_increment,
    constraint primary key(bno),
    nickname varchar(10) not null,
    product varchar(30) not null,
    content longtext not null,
    price int not null,
    pwd int not null,
    phone char(13) not null,
    isAvailable bool default true,  
    bdate datetime default now()
);
insert into product(nickname , product , content , price , pwd , phone)values
("유재석" , "키보드" , "거의 새상품" , 5000 , 1234 , "010-1234-1234");

select * from product

