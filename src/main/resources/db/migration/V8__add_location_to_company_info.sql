ALTER TABLE company_info
    ADD COLUMN address VARCHAR(255),
    ADD COLUMN latitude DOUBLE PRECISION,
    ADD COLUMN longitude DOUBLE PRECISION;

UPDATE company_info
SET address = 'Portoviejo, Manabí, Ecuador',
    latitude = -1.0546,
    longitude = -80.4530
WHERE id = 1;