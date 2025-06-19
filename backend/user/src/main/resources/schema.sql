CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    contact_number VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    user_type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE login (
    login_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE passenger_details (
    passenger_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    id_proof_type VARCHAR(50),
    id_proof_number VARCHAR(50),
    nationality VARCHAR(50),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Sample data for users table
INSERT INTO users (name, email, contact_number, address, user_type, status, created_at, updated_at) VALUES
('John Doe', 'john.doe@example.com', '1234567890', '123 Main St, City', 'CUSTOMER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jane Smith', 'jane.smith@example.com', '9876543210', '456 Oak Ave, Town', 'CUSTOMER', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Admin User', 'admin@trainservice.com', '5555555555', 'Admin Office', 'ADMIN', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Sample data for login table (password: 'password123' - you should use encrypted passwords in production)
INSERT INTO login (email, password, user_type, status, created_at) VALUES
('john.doe@example.com', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'CUSTOMER', 'ACTIVE', CURRENT_TIMESTAMP),
('jane.smith@example.com', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'CUSTOMER', 'ACTIVE', CURRENT_TIMESTAMP),
('admin@trainservice.com', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'ADMIN', 'ACTIVE', CURRENT_TIMESTAMP);

-- Sample data for passenger_details table
INSERT INTO passenger_details (user_id, full_name, age, gender, id_proof_type, id_proof_number, nationality, created_at, updated_at) VALUES
(1, 'John Doe', 35, 'MALE', 'PASSPORT', 'P123456789', 'American', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Sarah Doe', 30, 'FEMALE', 'PASSPORT', 'P987654321', 'American', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Jane Smith', 28, 'FEMALE', 'DRIVING_LICENSE', 'DL123456', 'British', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Tom Smith', 32, 'MALE', 'NATIONAL_ID', 'ID789012', 'British', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 