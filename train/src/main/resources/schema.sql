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