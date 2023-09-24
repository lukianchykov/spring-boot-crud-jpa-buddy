USE managementdb;
CREATE TABLE project
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(255)          NOT NULL,
    start_date datetime              NULL,
    end_date   datetime              NULL,
    manager_id BIGINT                NULL,
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE task
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(255)          NULL,
    start_date  datetime              NULL,
    end_date    datetime              NULL,
    assignee_id BIGINT                NULL,
    project_id  BIGINT                NULL,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(255)          NOT NULL,
    password VARCHAR(255)          NOT NULL,
    email    VARCHAR(255)          UNIQUE,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE INDEX idx_project_name ON project (name);

ALTER TABLE project
    ADD CONSTRAINT project_user_id_fk FOREIGN KEY (manager_id) REFERENCES user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ASSIGNEE FOREIGN KEY (assignee_id) REFERENCES user (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);