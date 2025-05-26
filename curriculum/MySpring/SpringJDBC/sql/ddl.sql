drop table if exists todo_items;
create table todo_items
(
    id int NOT NULL AUTO_INCREMENT,
    title VARCHAR(40),
    done_flag TINYINT(1) DEFAULT 0,
    time_limit DATE,
    primary key (id)
);
