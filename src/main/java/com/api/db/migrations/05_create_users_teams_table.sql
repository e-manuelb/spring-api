CREATE table users_teams
(
    id         int       NOT NULL AUTO_INCREMENT primary key,
    userId    int       NOT NULL,
    teamId    int       NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    foreign key (userId) references users (id),
    foreign key (teamId) references teams (id)
);