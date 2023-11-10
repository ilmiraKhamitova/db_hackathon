create table colors(
	color varchar
);
insert into colors values ('red'), ('orange'), ('yellow'), ('green'), ('light-blue'), ('blue'), ('violet');

insert into lighting (color, intensity) select color, intensity from colors as c cross join generate_series(0, 100) as intensity;

