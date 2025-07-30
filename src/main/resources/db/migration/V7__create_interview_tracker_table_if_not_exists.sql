-- V7__create_interview_tracker_table.sql

CREATE TABLE IF NOT EXISTS interview_tracker (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sl_no INT,
    candidate_id BIGINT,
    candidate_name VARCHAR(255),
    skill VARCHAR(255),
    vendor VARCHAR(255),
    recruiter VARCHAR(255),

    client VARCHAR(50),

    date_of_interview DATE,
    time VARCHAR(100),
    invite_status VARCHAR(255),
    interviewed_by VARCHAR(255),

    r1_status VARCHAR(50),
    r2_status VARCHAR(50),
    client1_status VARCHAR(50),
    client2_status VARCHAR(50),

    onboarding VARCHAR(50),
    onboarding_date DATE,

    CONSTRAINT fk_candidate FOREIGN KEY (candidate_id) REFERENCES candidate_details_and_status_tracker(id)
);
