create sequence sensor_seq;
alter table sensor alter column id set default nextval('sensor_seq');