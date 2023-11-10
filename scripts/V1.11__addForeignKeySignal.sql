alter table signal
add foreign key (sensor_id) references sensor(id) on delete restrict on update cascade;


