create table users (
    id integer not null,
    username varchar(150) not null,
    password varchar(150) not null,
    email varchar(150) not null,
    created_at timestamp,
    primary key (id)
);
create sequence rol_sequence as integer increment 1;

insert

