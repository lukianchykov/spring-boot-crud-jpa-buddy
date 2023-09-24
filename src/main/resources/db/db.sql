create database managementdb;
create user 'managementuser' identified by 'managementpassword';
GRANT ALL PRIVILEGES ON managementdb.* TO 'managementuser'@'%';
FLUSH PRIVILEGES;