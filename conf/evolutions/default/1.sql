# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table channel (
  id                        bigint not null,
  channel_id                varchar(255),
  body                      varchar(255),
  created                   timestamp not null,
  constraint pk_channel primary key (id))
;

create sequence channel_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists channel;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists channel_seq;

