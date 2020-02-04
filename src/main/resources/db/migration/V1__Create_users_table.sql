create table users (
    ID int primary key auto_increment,
    NAME varchar(100) not null,
    LAST_NAME varchar(100) not null,
    EMAIL varchar(100) not null,
    LOGIN varchar(100) not null,
    PASSWORD varchar(100) not null
);
