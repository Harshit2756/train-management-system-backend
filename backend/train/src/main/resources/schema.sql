CREATE TABLE trains (
    train_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_number VARCHAR(50) NOT NULL UNIQUE,
    train_name VARCHAR(255) NOT NULL,
    train_type VARCHAR(50) NOT NULL,
    total_seats INT NOT NULL,
    ac_seats INT NOT NULL,
    sleeper_seats INT NOT NULL,
    general_seats INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE stations (
    station_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_code VARCHAR(20) NOT NULL UNIQUE,
    station_name VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zone VARCHAR(50),
    status VARCHAR(20) NOT NULL
);

CREATE TABLE routes (
    route_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_id BIGINT NOT NULL,
    from_station_id BIGINT NOT NULL,
    to_station_id BIGINT NOT NULL,
    distance INT NOT NULL,
    sequence_number INT NOT NULL,
    arrival_time TIME NOT NULL,
    departure_time TIME NOT NULL,
    stop_duration INT NOT NULL,
    ac_fare DECIMAL(10,2) NOT NULL,
    sleeper_fare DECIMAL(10,2) NOT NULL,
    general_fare DECIMAL(10,2) NOT NULL
);

CREATE TABLE schedules (
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_id BIGINT NOT NULL,
    travel_date DATE NOT NULL,
    available_ac_seats INT NOT NULL,
    available_sleeper_seats INT NOT NULL,
    available_general_seats INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Dummy Data
INSERT INTO stations (station_code, station_name, city, state, zone, status) VALUES
('NDLS', 'New Delhi', 'New Delhi', 'Delhi', 'NR', 'ACTIVE'),
('BCT', 'Mumbai Central', 'Mumbai', 'Maharashtra', 'WR', 'ACTIVE'),
('HWH', 'Howrah Junction', 'Kolkata', 'West Bengal', 'ER', 'ACTIVE'),
('MAS', 'Chennai Central', 'Chennai', 'Tamil Nadu', 'SR', 'ACTIVE'),
('SBC', 'Bengaluru City', 'Bengaluru', 'Karnataka', 'SWR', 'ACTIVE'),
('HYB', 'Hyderabad Deccan', 'Hyderabad', 'Telangana', 'SCR', 'ACTIVE');

INSERT INTO trains (train_number, train_name, train_type, total_seats, ac_seats, sleeper_seats, general_seats, status, created_at, updated_at) VALUES
('12001', 'Shatabdi Express', 'Express', 500, 100, 200, 200, 'ACTIVE', '2024-06-20 10:00:00', '2024-06-20 10:00:00'),
('12002', 'Rajdhani Express', 'Express', 600, 150, 250, 200, 'ACTIVE', '2024-06-20 10:00:00', '2024-06-20 10:00:00');

INSERT INTO routes (train_id, from_station_id, to_station_id, distance, sequence_number, arrival_time, departure_time, stop_duration, ac_fare, sleeper_fare, general_fare) VALUES
(1, 1, 2, 1400, 1, '10:00:00', '10:05:00', 5, 2000.00, 1000.00, 500.00),
(1, 2, 3, 1500, 2, '20:00:00', '20:05:00', 5, 2200.00, 1100.00, 550.00),
(2, 4, 5, 350, 1, '08:00:00', '08:05:00', 5, 800.00, 400.00, 200.00),
(2, 5, 6, 600, 2, '14:00:00', '14:05:00', 5, 1200.00, 600.00, 300.00);

INSERT INTO schedules (train_id, travel_date, available_ac_seats, available_sleeper_seats, available_general_seats, status, created_at, updated_at) VALUES
(1, '2024-12-25', 98, 198, 200, 'ON_TIME', '2024-06-20 10:00:00', '2024-06-20 10:00:00'),
(2, '2024-12-26', 150, 249, 200, 'ON_TIME', '2024-06-21 11:00:00', '2024-06-21 11:00:00'); 