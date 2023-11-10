create sequence sensor_types_seq;
alter table sensor_types alter column id set default nextval('sensor_types_seq');