CREATE TYPE message_status AS ENUM ('RECEIVED', 'DELIVERED');

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(50) NOT NULL UNIQUE,
                       phone_number VARCHAR(50) UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE messages (
                          id SERIAL PRIMARY KEY,
                          chat_id VARCHAR(255) NOT NULL,
                          sender_id INT NOT NULL,
                          recipient_id INT NOT NULL,
                          content TEXT NOT NULL,
                          timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          status message_status NOT NULL,
                          FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE,
                          FOREIGN KEY (recipient_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE chatrooms (
                           id SERIAL PRIMARY KEY,
                           chat_id VARCHAR(255) NOT NULL UNIQUE,
                           sender_id INT NOT NULL,
                           recipient_id INT NOT NULL,
                           FOREIGN KEY (sender_id) REFERENCES users(id) ON DELETE CASCADE,
                           FOREIGN KEY (recipient_id) REFERENCES users(id) ON DELETE CASCADE
);
