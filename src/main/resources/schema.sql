create table if not exists users (
    id serial,
    username varchar(60) not null primary key,
    password varchar(60) not null,
    enabled boolean not null
);

create table if not exists authorities (
    username varchar(60) not null primary key references public.users(username),
    authority varchar(60)
);

create table if not exists files (
    id serial primary key,
    date date not null,
    description varchar(200),
    size int not null,
--  user_id int not null references public.users(id)
    username varchar(60) not null references public.users(username)
);