-- creating Database
create database MLP191;

-- using the Database
use MLP191;


create table CUSTOMER
(
CUS_ID varchar(20) primary key,
CUS_NAME varchar(20),
CUS_PHONE bigint,
CUS_ADDR varchar(100),
CUS_EMAIL varchar(50),
);


ALTER table CUSTOMER add column CURR_AMT int;
ALTER table CUSTOMER add column PAY_STAT varchar(20);
ALTER table CUSTOMER CHANGE PAY_STAT  PAY_STAT varchar(20) DEFAULT NULL;



create table MENU
(
FOOD_ID varchar(20) primary key,
FOOD_NAME varchar(20),
FOOD_COST int
);
alter table MENU ADD column AVAIL_QUANTITY INT;
update MENU set AVAIL_QUANTITY =50 where FOOD_ID in ('FN001','FV001'); 


create table ORDERS
(
ORD_ID varchar(20) primary key,
ORD_DATE date,
FOOD_ID varchar(20),
QUANTITY int,
TOTAL int,
ORD_STATUS varchar(20),
CUS_ID varchar(20),
TOKEN int,
foreign key(CUS_ID) references CUSTOMER(CUS_ID),
foreign key(FOOD_ID) references MENU(FOOD_ID)
);




create table HISTORY
(
CUS_ID VARCHAR(20),
ORD_ID VARCHAR(20),
foreign key(CUS_ID) references CUSTOMER(CUS_ID),
foreign key(ORD_ID) references ORDERS(ORD_ID)
);


create table VENDORS
(

VEN_NAME varchar(20),
VEN_ID VARCHAR(20) primary key,
VEN_PASS VARCHAR(20) NOT NULL,
CUS_ID VARCHAR(20),
foreign key(CUS_ID) references CUSTOMER(CUS_ID)
);





