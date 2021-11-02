DROP TABLE IF EXISTS bookinfo;

CREATE TABLE bookinfo
(
   id INT NOT NULL AUTO_INCREMENT,
   genre VARCHAR(50) NOT NULL,
   bookname VARCHAR(100) NOT NULL,
   author VARCHAR(50) NOT NULL,
   publisher VARCHAR(50) NOT NULL,
   comment VARCHAR(1000) NOT NULL,
   PRIMARY KEY(id)
);