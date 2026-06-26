CREATE TABLE IF NOT EXISTS phones (
                                      id BIGSERIAL PRIMARY KEY,
                                      brand_name VARCHAR(255),
                                      memory INTEGER,
                                      price BIGINT
);