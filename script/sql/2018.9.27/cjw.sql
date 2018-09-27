/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/27 14:02:41                           */
/*==============================================================*/


drop table if exists company;

drop table if exists file;

drop table if exists follow_company;

drop table if exists message;

drop table if exists position;

drop table if exists position_interest;

drop table if exists position_type;

drop table if exists see_company;

drop table if exists send_file;

drop table if exists static_data;

drop table if exists user;

/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/
create table company
(
   company_id           int not null auto_increment,
   company_name         varchar(100),
   description          varchar(1000),
   place                varchar(255),
   home_page_link       varchar(255),
   company_type         int,
   size                 varchar(50),
   state                int,
   primary key (company_id)
);

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   file_id              int not null auto_increment,
   user_id              int,
   file_name            varchar(255),
   path                 varchar(500),
   state                int,
   primary key (file_id)
);

/*==============================================================*/
/* Table: follow_company                                        */
/*==============================================================*/
create table follow_company
(
   id                   int not null auto_increment,
   user_id              int,
   company_id           int,
   create_time          datetime,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: message                                               */
/*==============================================================*/
create table message
(
   message_id           int not null auto_increment,
   user_id              int,
   accepter_id          int,
   message_type         int,
   content              varchar(500),
   position_id          int,
   create_time          datetime,
   if_read              int,
   state                int,
   primary key (message_id)
);

/*==============================================================*/
/* Table: position                                              */
/*==============================================================*/
create table position
(
   position_id          int not null auto_increment,
   user_id              int,
   position_name        varchar(255),
   company_id           int,
   position_type        int,
   place                varchar(255),
   educational_requirements varchar(50),
   experience_requirements varchar(50),
   salary               varchar(50),
   description          varchar(1000),
   state                int,
   create_time          datetime,
   update_time          datetime,
   primary key (position_id)
);

/*==============================================================*/
/* Table: position_interest                                     */
/*==============================================================*/
create table position_interest
(
   id                   int not null auto_increment,
   user_id              int,
   position_id          int,
   create_time          datetime,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: position_type                                         */
/*==============================================================*/
create table position_type
(
   position_type_id     int not null auto_increment,
   position_type_name   varchar(50),
   parent               int,
   state                int,
   primary key (position_type_id)
);

/*==============================================================*/
/* Table: see_company                                           */
/*==============================================================*/
create table see_company
(
   id                   int not null auto_increment,
   company_id           int,
   user_id              int,
   create_time          datetime,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: send_file                                             */
/*==============================================================*/
create table send_file
(
   id                   int not null auto_increment,
   user_id              int,
   accept_id            int,
   file_id              int,
   create_time          datetime,
   done_time            datetime,
   state                int,
   primary key (id)
);

/*==============================================================*/
/* Table: static_data                                           */
/*==============================================================*/
create table static_data
(
   id                   int not null auto_increment,
   type_code            varchar(255),
   type_value           varchar(255),
   type_name            varchar(255),
   state                int,
   parent               int,
   primary key (id)
);

alter table static_data comment '学校
公司类型';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int not null auto_increment,
   user_type            int,
   user_name            varchar(50),
   user_email           varchar(255),
   gender               int,
   join_work            date,
   birthday             date,
   open_id              varchar(255),
   session_key          varchar(255),
   my_advantage         varchar(1000),
   my_answer            varchar(1000),
   work_experience      varchar(1000),
   practice_experience  varchar(1000),
   project_experience   varchar(1000),
   educational_experience varchar(1000),
   job_intension        varchar(1000),
   user_setting         varchar(1000),
   state                int,
   education            int,
   phone                varchar(20),
   desired_working_place varchar(100),
   living_place varchar(100),
   primary key (user_id)
);

