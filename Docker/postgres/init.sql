GRANT ALL PRIVILEGES ON DATABASE user_subscription TO postgres;
create table "user"
(
    id      integer
        not null
        primary key
        unique
        generated always as ( 0 ) STORED,
    name    varchar,
    sername varchar,
    birsday varchar
);
create table "subscription"
(
    id        integer,
    user_id   integer,
    start_day date,
    constraint id
        primary key (id),
    constraint subscription___fk
        foreign key (user_id) references "user" (id)
)