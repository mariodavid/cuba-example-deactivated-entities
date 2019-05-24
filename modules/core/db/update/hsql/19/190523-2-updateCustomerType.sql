alter table CEDE_CUSTOMER_TYPE add column ACTIVE boolean ^
update CEDE_CUSTOMER_TYPE set ACTIVE = false where ACTIVE is null ;
alter table CEDE_CUSTOMER_TYPE alter column ACTIVE set not null ;
