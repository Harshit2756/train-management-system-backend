CREATE TABLE bookings (
    booking_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pnr VARCHAR(50) NOT NULL UNIQUE,
    customer_id BIGINT NOT NULL,
    train_id BIGINT NOT NULL,
    from_station_id BIGINT NOT NULL,
    to_station_id BIGINT NOT NULL,
    travel_date DATE NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    total_passengers INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    booking_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE seats (
    seat_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    passenger_id BIGINT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    seat_type VARCHAR(20) NOT NULL,
    seat_class VARCHAR(20) NOT NULL,
    fare DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- not needed
CREATE TABLE tickets (
    ticket_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    passenger_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE payments (
    payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    transaction_id VARCHAR(50) NOT NULL UNIQUE,
    amount DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    payment_date TIMESTAMP NOT NULL,
    gateway_response VARCHAR(255)
);

-- Dummy Data
INSERT INTO bookings (pnr, customer_id, train_id, from_station_id, to_station_id, travel_date, departure_time, arrival_time, total_passengers, total_amount, status, booking_date, created_at) VALUES
('PNR123456', 1, 101, 1, 5, '2024-12-25', '10:00:00', '18:00:00', 2, 1500.00, 'CONFIRMED', '2024-06-20 10:00:00', '2024-06-20 10:00:00'),
('PNR654321', 2, 102, 2, 6, '2024-12-26', '12:00:00', '20:00:00', 1, 800.00, 'CONFIRMED', '2024-06-21 11:00:00', '2024-06-21 11:00:00');

INSERT INTO seats (booking_id, passenger_id, seat_number, seat_type, seat_class, fare, status, created_at) VALUES
(1, 1, 'A1', 'WINDOW', 'AC', 750.00, 'CONFIRMED', '2024-06-20 10:00:00'),
(1, 2, 'A2', 'AISLE', 'AC', 750.00, 'CONFIRMED', '2024-06-20 10:00:00'),
(2, 3, 'B5', 'WINDOW', 'SLEEPER', 800.00, 'CONFIRMED', '2024-06-21 11:00:00');

INSERT INTO tickets (booking_id, passenger_id, start_date, end_date, status, created_at) VALUES
(1, 1, '2024-12-25', '2024-12-25', 'ACTIVE', '2024-06-20 10:00:00'),
(1, 2, '2024-12-25', '2024-12-25', 'ACTIVE', '2024-06-20 10:00:00'),
(2, 3, '2024-12-26', '2024-12-26', 'ACTIVE', '2024-06-21 11:00:00');

INSERT INTO payments (booking_id, transaction_id, amount, payment_method, status, payment_date) VALUES
(1, 'TXN123456', 1500.00, 'UPI', 'SUCCESS', '2024-06-20 10:01:00'),
(2, 'TXN654321', 800.00, 'CREDIT_CARD', 'SUCCESS', '2024-06-21 11:01:00');