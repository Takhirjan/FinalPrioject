
CREATE TABLE t_permission (
  id bigint auto_increment,
  role varchar(255),
  primary key (id)
);

CREATE TABLE t_users (
                         id bigint auto_increment,
                         email varchar(255),
                         full_name varchar(255),
                         password varchar(255),
                         primary key (id)
);

CREATE TABLE t_users_permissions (
 users_id bigint,
 permissions_id bigint
);

-- Add foreign key constraint for t_users_permissions -> t_users
ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_user_id
        FOREIGN KEY (users_id)
            REFERENCES t_users(id)
                ON DELETE CASCADE;

ALTER TABLE t_users_permissions
    ADD CONSTRAINT FK_t_users_permissions_permission_id
        FOREIGN KEY (permissions_id)
            REFERENCES t_permission(id)
            ON DELETE CASCADE;



CREATE TABLE t_apartaments(
                              id bigint auto_increment,
                              title varchar(255),
                              primary key (id)
);


CREATE TABLE t_service(
id bigint auto_increment,
service_name varchar(255),
has_options boolean,
primary key (id)
);

CREATE TABLE t_bookings(
   id bigint auto_increment,
   time datetime,
   uslugi_model_id bigint,
   primary key (id),
   foreign key (uslugi_model_id) references t_service(id)
);

CREATE TABLE t_hotels(
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

CREATE TABLE t_comments(
    id bigint auto_increment,
    comment varchar(255),
    post_date datetime,
    hotel_id bigint,
    primary key (id),
    foreign key (hotel_id) references t_hotels(id)
);

CREATE TABLE t_villa(
    id bigint auto_increment,
    description varchar(255),
    name varchar(255),
    price varchar(255),
    primary key (id)
);