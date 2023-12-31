create table sensor (
	id bigint primary key,
	type bigint references sensor_types (id) on delete cascade on update cascade,
	work boolean default false not null,
	date timestamp not null
);