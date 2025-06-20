-- Placeholder for custom schema DDL if needed 

DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS food_orders;
DROP TABLE IF EXISTS food_item;

CREATE TABLE food_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    available BOOLEAN NOT NULL
);

CREATE TABLE food_orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    order_date TIMESTAMP NOT NULL,
    estimated_delivery_time TIMESTAMP
);

CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    food_item_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES food_orders(id),
    FOREIGN KEY (food_item_id) REFERENCES food_item(id)
);

-- Dummy Data
INSERT INTO food_item (name, description, price, available) VALUES
('Vegetarian Thali', 'A complete meal with rice, roti, dal, and vegetables.', 250.00, true),
('Non-Vegetarian Thali', 'A complete meal with rice, roti, chicken curry, and salad.', 350.00, true),
('Biryani', 'Aromatic rice dish with spices and meat or vegetables.', 300.00, true),
('Masala Dosa', 'A South Indian fermented crepe made from rice batter and black lentils.', 150.00, true);

INSERT INTO food_orders (booking_id, customer_id, total_amount, status, order_date, estimated_delivery_time) VALUES
(1, 1, 600.00, 'DELIVERED', '2024-06-20 12:00:00', '2024-06-20 13:00:00'),
(2, 2, 300.00, 'CONFIRMED', '2024-06-21 13:00:00', '2024-06-21 14:00:00');

INSERT INTO order_items (order_id, food_item_id, quantity, price) VALUES
(1, 1, 1, 250.00),
(1, 4, 1, 150.00),
(2, 3, 1, 300.00); 