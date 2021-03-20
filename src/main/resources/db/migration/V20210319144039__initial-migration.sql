create table articles
(
    id          serial        not null,
    title       varchar(1024) not null,
    description text,
    content     text          not null,
    author_name varchar(1024) not null
);

create
unique index articles_id_uindex
	on articles (id);

create
unique index articles_title_uindex
	on articles (title);

alter table articles
    add constraint articles_pk
        primary key (id);
