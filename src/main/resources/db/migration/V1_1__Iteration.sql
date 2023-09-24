INSERT INTO user (username, password, email)
VALUES ('John Doe', 'password1', 'john.doe@example.com'),
       ('Jane Smith', 'password2', 'jane.smith@example.com'),
       ('Robert Johnson', 'password3', 'robert.johnson@example.com'),
       ('Sarah Williams', 'password4', 'sarah.williams@example.com'),
       ('Michael Brown', 'password5', 'michael.brown@example.com');

INSERT INTO project (name, start_date, end_date, manager_id)
VALUES ('Software Development Project', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 1),
       ('Marketing Campaign', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 2),
       ('Product Launch', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 3),
       ('Research and Development', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 4),
       ('Customer Support Initiative', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 5);

INSERT INTO task (project_id, name, start_date, end_date, assignee_id)
VALUES (1, 'Design User Interface', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 1),
       (2, 'Create Marketing Materials', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 2),
       (3, 'Coordinate Product Launch Event', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 3),
       (4, 'Conduct Research Experiments', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 4),
       (5, 'Resolve Customer Issues', NOW(), DATE_ADD(NOW(), INTERVAL 2 DAY), 5);