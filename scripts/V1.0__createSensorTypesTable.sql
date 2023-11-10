create table sensor_types (
	id bigint primary key,
	type varchar unique not null, 
	table_name varchar unique not null
);