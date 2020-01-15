create table contacts(
	cid	int	primary key,
	cnm	varchar(25) not null,
	mno	char(10) not null,
	mail varchar(50) not null
); 

insert into contacts
values(1,'App Developer','9052224753','a.vamc.it@gmail.com');