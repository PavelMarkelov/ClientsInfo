DROP DATABASE IF EXISTS clientsInfo;
CREATE DATABASE clientsInfo;
USE clientsInfo;

CREATE TABLE client (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

CREATE TABLE phone (
                       id BIGINT NOT NULL,
                       phone VARCHAR(50) unique not null,
                       client_id BIGINT NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

CREATE TABLE email (
                       id BIGINT NOT NULL,
                       email VARCHAR(50)  unique not null,
                       client_id BIGINT NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;