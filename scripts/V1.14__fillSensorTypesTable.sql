alter table sensor_types drop constraint sensor_types_table_name_key;

insert into sensor_types (type, table_name) values ('motion sensor', 'boolean_result'),
('water leak sensor', 'boolean_result'),
('door opening sensor', 'boolean_result'),
('shutter control sensor', 'boolean_result'),
('smoke sensor', 'boolean_result'),
('light sensor', 'lighting');
