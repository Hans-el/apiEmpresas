CREATE TABLE job_offers (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    location VARCHAR(150) NOT NULL,
    modality VARCHAR(20) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT true,
    published_at TIMESTAMP NOT NULL DEFAULT now(),
    expires_at TIMESTAMP
);