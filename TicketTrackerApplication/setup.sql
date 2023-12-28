-- Creating the DATABASE
CREATE DATABASE if NOT EXISTS ticket_tracker;

-- Creating Table Ticket
CREATE TABLE
    IF NOT EXISTS ticket_tracker.ticket (
        id INT PRIMARY KEY AUTO_INCREMENT,
        title VARCHAR(100) NOT NULL,
        short_description VARCHAR(255),
        content TEXT,
        created_on DATE DEFAULT (CURRENT_DATE)
    )