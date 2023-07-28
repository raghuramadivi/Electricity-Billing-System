create DataBase Bill_system;
use Bill_system;

create table Signup(meter_no varchar(20),username varchar(30),name varchar(30),password varchar(30),usertype varchar(20));
select * from Signup

create table  new_customer(name varchar(20),meterno varchar(30),address varchar(30),city varchar(30),state varchar(20),email varchar(30),phone_no varchar(12));
select * from new_customer

create table meter_info(meter_number varchar(30),meter_location varchar(30),meter_type varchar(30),phase_code varchar(30),bill_type varchar(30),days varchar(10));
select * from meter_info

create table tax(cost_per_unit varchar(20),meter_rent varchar(20),service_charge varchar(20),service_tax varchar(20),swach_bharat varchar(20),fixed_tax varchar(20));
select * from tax;

create table bill(meter_no varchar(20),month varchar(20),unit varchar(20),total_bill varchar(20),status varchar(20));
select * from bill;