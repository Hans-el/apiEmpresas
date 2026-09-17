CREATE TABLE applications (
    id BIGSERIAL PRIMARY KEY,
    job_offer_id BIGINT NOT NULL REFERENCES job_offers(id),
    applicant_name VARCHAR(150) NOT NULL,
    applicant_email VARCHAR(150) NOT NULL,
    resume_url VARCHAR(500),
    applied_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_applications_job_offer_id ON applications(job_offer_id);