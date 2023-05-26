Create database W07Q1;

create table users(
     user_id serial primary key ,
    user_name varchar(50),
    user_password varchar(20),
    singup_date date

);
drop table users;


