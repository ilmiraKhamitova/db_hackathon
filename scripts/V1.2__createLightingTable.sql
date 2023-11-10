create table lighting (
	id bigint primary key,
	color varchar(20) not null,
	intensity int not null check(intensity between 0 and 100)
);
