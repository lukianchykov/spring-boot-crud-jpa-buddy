# INSERT INTO project (name, end_date, start_date, manager_id)
# VALUES ('Palanuya', NOW(), NOW(), 0);
CREATE INDEX idx_project_name ON project (name);