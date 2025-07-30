CREATE TABLE IF NOT EXISTS open_requirement (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    serial_no BIGINT NOT NULL,
    role VARCHAR(255),
    number_of_positions INT,
    skills VARCHAR(500),
    years_of_experience DOUBLE,
    client_name VARCHAR(255),
    budget VARCHAR(100),
    location VARCHAR(255),
    work_timings VARCHAR(50),
    priority VARCHAR(50),
    position_status VARCHAR(50)
);
