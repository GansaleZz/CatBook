drop table if exists CB_BookUserMap cascade ;
drop table if exists CB_Book cascade;
drop table if exists CB_BookType cascade;
drop table if exists CB_UserRoleMap cascade;
drop table if exists CB_User cascade;
drop table if exists CB_UserRole cascade;

create table CB_User
(
    ID           bigint auto_increment
        primary key,
    UserName     varchar(16)                          not null,
    Login        varchar(16)                          not null,
    Password     varchar(16)                          not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_User_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_User_2
        foreign key (ModifiedByID) references CB_User (ID)
);

create table CB_BookType
(
    ID           bigint auto_increment
        primary key,
    BookTypeName varchar(100)                         not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_BookType_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_BookType_2
        foreign key (ModifiedByID) references CB_User (ID)
);

create table CB_Book
(
    ID           bigint auto_increment
        primary key,
    BookName     varchar(100)                         not null,
    BookTypeID   bigint                               not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_Book_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_Book_2
        foreign key (ModifiedByID) references CB_User (ID),
    constraint fk_CB_Book_3
        foreign key (BookTypeID) references CB_BookType (ID)
);

create table CB_BookUserMap
(
    ID           bigint auto_increment
        primary key,
    UserID       bigint                               not null,
    BookID       bigint                               not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_BookUserMap_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_BookUserMap_2
        foreign key (ModifiedByID) references CB_User (ID),
    constraint fk_CB_BookUserMap_3
        foreign key (UserID) references CB_User (ID),
    constraint fk_CB_BookUserMap_4
        foreign key (BookID) references CB_Book (ID)
);

create table CB_UserRole
(
    ID           bigint auto_increment
        primary key,
    UserRoleName varchar(32)                          not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_UserRole_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_UserRole_2
        foreign key (ModifiedByID) references CB_User (ID)
);

create table CB_UserRoleMap
(
    ID           bigint auto_increment
        primary key,
    UserID       bigint                               not null,
    UserRoleID   bigint                               not null,
    CreatedDate  datetime   default CURRENT_TIMESTAMP null comment 'Define the date of record creating.',
    ModifiedDate datetime   default CURRENT_TIMESTAMP null comment 'Define the date of the last updating of record.',
    CreatedByID  bigint     default -1                null comment 'User who created the record. FK to CB_User table.',
    ModifiedByID bigint     default -1                null comment 'Last user which updated the record. FK to CB_User table.',
    ActiveFlag   varchar(1) default 'Y'               null comment 'Define if record is active.',
    constraint fk_CB_UserRoleMap_1
        foreign key (CreatedByID) references CB_User (ID),
    constraint fk_CB_UserRoleMap_2
        foreign key (ModifiedByID) references CB_User (ID),
    constraint fk_CB_UserRoleMap_3
        foreign key (UserID) references CB_User (ID),
    constraint fk_CB_UserRoleMap_4
        foreign key (UserRoleID) references CB_UserRole (ID)
);

insert into CB_User(ID, UserName, Login, Password) values (-1, 'SystemTestName', 'SystemTestLogin', 'testPassword');

insert into CB_BookType (BookTypeName) values ('TEST1');
insert into CB_BookType (BookTypeName) values ('TEST2');
insert into CB_BookType (BookTypeName) values ('TEST3');
insert into CB_BookType (BookTypeName) values ('TEST4');
insert into CB_BookType (BookTypeName, ActiveFlag) values ('TEST5', 'N');

insert into CB_Book (BookName, BookTypeID) values ('TEST1', 1);
insert into CB_Book (BookName, BookTypeID) values ('TEST2', 2);
insert into CB_Book (BookName, BookTypeID) values ('TEST3', 3);
insert into CB_Book (BookName, BookTypeID, ActiveFlag) values ('TEST4', 4, 'N');
insert into CB_Book (BookName, BookTypeID) values ('TEST5', 5);