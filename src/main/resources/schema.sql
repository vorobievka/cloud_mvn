create table if not exists users (
    id serial primary key,
    login varchar(60) not null,
    password varchar(60) not null
);
create table if not exists files (
    id serial primary key,
    date date not null,
    description varchar(200),
    size int not null,
    user_id int not null references public.users(id)
);