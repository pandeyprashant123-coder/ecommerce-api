--sql formates liquibase
CREATE TABLE users (
    id UUID NOT NULL,
    email VARCHAR(20),
    user_name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(20),
    created_at TIMESTAMP,
    created_by UUID,
    updated_at TIMESTAMP,
    updated_by UUID
);