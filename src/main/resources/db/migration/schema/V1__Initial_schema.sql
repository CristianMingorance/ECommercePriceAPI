CREATE TABLE prices (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        brand_id INT NOT NULL,
                        start_date TIMESTAMP NOT NULL,
                        end_date TIMESTAMP NOT NULL,
                        price_list INT NOT NULL,
                        product_id INT NOT NULL,
                        priority INT,
                        price DECIMAL(10, 2),
                        curr VARCHAR(3)
);
