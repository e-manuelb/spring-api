CREATE table teams
(
    id         int          NOT NULL AUTO_INCREMENT primary key,
    name       varchar(100) NOT NULL,
    year       varchar(4)   NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);