create database STUDENTMANAGEMENT

use STUDENTMANAGEMENT

drop table STUDENT
create table STUDENT (
	id int primary key,
	name nvarchar(50) null,
	age int null,
	address nvarchar(50) null,
	gpa float null
)

delete from STUDENT
where id = ?
select * from STUDENT
insert into STUDENT values (6 , 'tu' , 20 , 'dc' , 9)

