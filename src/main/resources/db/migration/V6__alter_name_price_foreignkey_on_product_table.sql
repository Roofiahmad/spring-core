ALTER TABLE products
    MODIFY name VARCHAR(255) NOT NULL;

ALTER TABLE products
    MODIFY price DECIMAL(10, 2) NOT NULL;

ALTER TABLE products
DROP FOREIGN KEY products_categories_id_fk;

ALTER TABLE products
    ADD CONSTRAINT products_categories_id_fk
        FOREIGN KEY (category_id) REFERENCES categories (id)
            ON DELETE RESTRICT;