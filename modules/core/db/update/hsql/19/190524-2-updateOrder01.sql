alter table CEDE_ORDER add constraint FK_CEDE_ORDER_CUSTOMER foreign key (CUSTOMER_ID) references CEDE_CUSTOMER(ID);
create index IDX_CEDE_ORDER_CUSTOMER on CEDE_ORDER (CUSTOMER_ID);
