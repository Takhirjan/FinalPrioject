create table t_permission(
    id bigint auto_increment,
    role varchar(255),
    primary key (id)
);

create table t_users(
    id bigint auto_increment,
    email varchar(255),
    full_name varchar(255),
    password varchar(255),
    primary key (id)
);

create table t_users_permissions(
    user_id bigint,
    permission_id bigint
);

ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_user_id
        FOREIGN KEY (user_id)
            REFERENCES t_users(id)
                ON DELETE CASCADE;

ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_permission_id
        FOREIGN KEY (permission_id)
            REFERENCES t_permission(id)
                ON DELETE CASCADE;

 create table t_hotels(
     id bigint auto_increment,
     description varchar(255),
     name varchar(255),
     price varchar(255),
     rating varchar(255),
     text varchar(255),
     city varchar(255),
     address varchar(255),
     primary key (id)
 );