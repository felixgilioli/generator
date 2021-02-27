drop table if exists category CASCADE;
drop table if exists input CASCADE;
drop table if exists input_group CASCADE;
drop table if exists template CASCADE;
drop table if exists template_entity_export_type_set CASCADE;
create table category (id uuid not null, description varchar(255), name varchar(50) not null, primary key (id));
create table input (id uuid not null, label varchar(255) not null, mask varchar(255), name varchar(100) not null, ordem integer not null, placeholder varchar(255), required boolean, title varchar(255), type varchar(255) not null, input_group_id uuid not null, primary key (id));
create table input_group (id uuid not null, legend varchar(255) not null, ordem integer not null, template_id uuid not null, primary key (id));
create table template (id uuid not null, description varchar(255) not null, img_location varchar(255) not null, location varchar(255) not null, title varchar(100) not null, category_id uuid not null, primary key (id));
create table template_entity_export_type_set (template_entity_id uuid not null, export_type_set varchar(255));
alter table input add constraint FKpmhhr9htclf8cqudgfd2v3n3l foreign key (input_group_id) references input_group;
alter table input_group add constraint FKega1hdcnqm15qcd9uboinxa1l foreign key (template_id) references template;
alter table template add constraint FKfke34lch7qf4xixqnyj3h12m7 foreign key (category_id) references category;
alter table template_entity_export_type_set add constraint FKl0ix8kghltexdl76g260sd833 foreign key (template_entity_id) references template;