create table grade1
(
	gid int primary key,
	gname varchar(20) not null,
	gdesc varchar(50) 
);
create table student1
(
	sid int primary key,
	sname varchar(20) not null,
	sex char(2),
	gid int 
	
);
alter table student1 add constraint Fk_GID  foreign key (gid)
references grade1(gid);