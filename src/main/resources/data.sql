DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS location;


CREATE TABLE user (
    userId INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    password VARCHAR(30)
);

CREATE TABLE location (
	id INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	userId INTEGER UNSIGNED,
    deviceName VARCHAR(30),
    latitude INTEGER,
    longitude INTEGER,
    FOREIGN KEY (userId) REFERENCES user(userId)
);