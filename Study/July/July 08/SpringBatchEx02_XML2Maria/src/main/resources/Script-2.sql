create table EXAM_RESULT(
	idx int primary key auto_increment,
	STUDENT_NAME varchar(20) not null, 
	DOB date not null, 
	PERCENTAGE FlOAT(7,2) not null
);

drop table EXAM_RESULT;
select *from EXAM_RESULT;