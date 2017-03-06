alter table ROOM_DEVICE drop foreign key FKh9otjun05ojea3bx2kfcg2fmq
alter table ROOM_DEVICE drop foreign key FK3cx9lv9u3wmt4gjspfcwe70b7
alter table USER_ROOM drop foreign key FKomy1vcs2dq33v5lcp635nxk1x
alter table USER_ROOM drop foreign key FK9wjqe30lsmjdc50w9fyco1fb4
drop table if exists DEVICE
drop table if exists ROOM
drop table if exists ROOM_DEVICE
drop table if exists USER
drop table if exists USER_ROOM
create table DEVICE (devicetype varchar(31) not null, deviceID integer not null auto_increment, deviceMAC varchar(255), deviceName varchar(255), roomName varchar(255), currentTemp integer, hotplateTurnedOn bit, stoveTurnedOn bit, primary key (deviceID))
create table ROOM (roomID integer not null auto_increment, icon_path varchar(255), roomName varchar(255), primary key (roomID))
create table ROOM_DEVICE (Room_roomID integer not null, deviceList_deviceID integer not null)
create table USER (id integer not null auto_increment, authentificationToken varchar(255), lastUpdate datetime, userName varchar(255), userPassword varchar(255), primary key (id))
create table USER_ROOM (User_id integer not null, rooms_roomID integer not null)
alter table ROOM_DEVICE add constraint UK_dsfxaab5lwtrjikae02b0el7j unique (deviceList_deviceID)
alter table USER_ROOM add constraint UK_ls8r52yv5xbj8ltupplojtgrp unique (rooms_roomID)
alter table ROOM_DEVICE add constraint FKh9otjun05ojea3bx2kfcg2fmq foreign key (deviceList_deviceID) references DEVICE (deviceID)
alter table ROOM_DEVICE add constraint FK3cx9lv9u3wmt4gjspfcwe70b7 foreign key (Room_roomID) references ROOM (roomID)
alter table USER_ROOM add constraint FKomy1vcs2dq33v5lcp635nxk1x foreign key (rooms_roomID) references ROOM (roomID)
alter table USER_ROOM add constraint FK9wjqe30lsmjdc50w9fyco1fb4 foreign key (User_id) references USER (id)
