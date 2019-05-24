-- begin CEDE_CUSTOMER
create table CEDE_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TYPE_ID varchar(36),
    ACTIVE boolean not null,
    --
    primary key (ID)
)^
-- end CEDE_CUSTOMER
-- begin CEDE_CUSTOMER_TYPE
create table CEDE_CUSTOMER_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255),
    NAME varchar(255),
    ACTIVE boolean not null,
    --
    primary key (ID)
)^
-- end CEDE_CUSTOMER_TYPE
-- begin CEDE_ORDER
create table CEDE_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    CUSTOMER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CEDE_ORDER
