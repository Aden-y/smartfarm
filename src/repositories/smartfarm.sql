create database smartfarm;
use smartfarm;

CREATE TABLE  if not exists users (
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    firsname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) not null,
    phone bigint not null,
    type enum('Customer', 'Farm Owner', 'Store Keeper') not null,
    password varchar(255) not null,
    registerdate varchar(20) not null,
    lastlogin varchar(20) not null
);

create table if not exists products (
    id bigint not null primary key auto_increment,
    name varchar(100) not null,
    category varchar(50) not null,
    description text not null,
    units varchar(20) not null,
    quantity double not null default  0.0,
    price double not null
);


create table if not exists storeitems (
    id bigint not null primary key auto_increment,
    name varchar(100) not null,
    category varchar(50) not null,
    units varchar(20) not null,
    quantity double not null default  0.0,
    updatedat varchar(25) not null
);

create table if not exists farms (
    id bigint not null primary key auto_increment,
    name varchar(100) not null,
    size double not null,
    location varchar(255) not null
);

create table if not exists plants (
    id bigint not null primary key auto_increment,
    farmid bigint not null,
    name varchar(100) not null,
    category varchar(50) not null,
    description text not null,
    rootscount bigint null,
    plantedon varchar(20) null,
    foreign key (farmid) references farms(id)
);

create table if not exists animals (
    id bigint not null primary key auto_increment,
    name varchar(100) not null,
    category varchar(50) not null,
    breed varchar(100) null,
    color varchar(100) null,
    weight double null,
    dob varchar(20) null,
    gender enum('Male','Female') not null,
    count bigint not null default 1
);


create table if not exists orders (
    id bigint not null primary key auto_increment,
    userid bigint not null ,
    amount double not null ,
    status varchar(10) not null default 'Pending',
    date varchar(20) not null ,
    foreign key (userid) references users(id)
);

create table if not exists orderitems (
    id bigint not null primary key auto_increment,
    name varchar(100) not null ,
    description text not null ,
    quantity int not null  default 1,
    price double not null ,
    amount double not null ,
    orderid bigint not null ,
    foreign key (orderid) references orders(id)

);

