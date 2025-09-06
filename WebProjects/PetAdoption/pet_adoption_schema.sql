use pet_adoption;
CREATE TABLE users(
id int AUTO_INCREMENT PRIMARY KEY,
username VARCHAR( 50)  NOT NULL UNIQUE,
password VARCHAR (255) NOT NULL ,
role ENUM('admin','user') DEFAULT 'user',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
-- Pet Table
CREATE TABLE pets(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
type ENUM('dog','cat','bird','other') NOT NULL,
breed VARCHAR(100),
age INT,
description TEXT,
status ENUM('adopted', 'available') DEFAULT 'available',
photo_url VARCHAR(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);
-- Adoption table
CREATE TABLE adoption(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
pet_id INT NOT NULL,
status ENUM('pending','approved','rejected') DEFAULT 'pending',
applied_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY(pet_id) REFERENCES pets(id) ON DELETE CASCADE
);
INSERT INTO users( username,password,role)
VALUES ('admin1','adminpass','admin'),
('john_doe','12345','user');
INSERT INTO pets(name,type,breed,age,description)
VALUES('BELLA', 'dog','Labrador', 3,'Friendly and active'),
('Milo','cat','persian',2,'Loves cuddles');
INSERT INTO adoptions(user_id,pet_id)
VALUES(2,1);

