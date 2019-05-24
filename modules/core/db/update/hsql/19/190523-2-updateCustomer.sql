alter table CEDE_CUSTOMER add column ACTIVE boolean ^
update CEDE_CUSTOMER set ACTIVE = false where ACTIVE is null ;
alter table CEDE_CUSTOMER alter column ACTIVE set not null ;
