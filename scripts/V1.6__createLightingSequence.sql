create sequence lighting_seq;
alter table lighting alter column id set default nextval('lighting_seq');

