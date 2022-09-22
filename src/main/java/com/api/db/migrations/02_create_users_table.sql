CREATE table users
(
    id         int          NOT NULL AUTO_INCREMENT primary key,
    name       varchar(100) NOT NULL,
    email      varchar(100) NOT NULL,
    roleId    int          NOT NULL,
    password   varchar(100) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    foreign key (roleId) references roles (id)
);