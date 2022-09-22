CREATE table users_scores
(
    id         int       NOT NULL AUTO_INCREMENT primary key,
    userId    int       NOT NULL,
    subjectId int       NOT NULL,
    score      float     NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
    foreign key (userId) references users (id),
    foreign key (subjectId) references subjects (id)
);