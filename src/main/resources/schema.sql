--This file used only for history purpose.

--DROP TABLE IF EXISTS items_seasons;
--DROP TABLE IF EXISTS items_reliefs;
--drop table if exists season;
--DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS testas;
--drop table if exists classificator;


--To store classifier values
--CREATE TABLE classificator (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    domain varchar(20),
--    code varchar(20),
--    meaning varchar(20),
--    description varchar(300)
--);
--
--For possibility to recommend items by season
--CREATE TABLE items_seasons (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    item_id INT,
--    classificator_id INT,
--    FOREIGN KEY (item_id) REFERENCES item(id),
--    FOREIGN KEY (classificator_id) REFERENCES classificator(id)
--);

--For possibility to recommend items by relief
--CREATE TABLE items_reliefs (
--    id INT AUTO_INCREMENT PRIMARY KEY,
--    item_id INT,
--    classificator_id INT,
--    FOREIGN KEY (item_id) REFERENCES item(id),
--    FOREIGN KEY (classificator_id) REFERENCES classificator(id)
--);

--CREATE TABLE items_seasons (
--    item_id INT,
--    season_code varchar(20),
--    FOREIGN KEY (item_id) REFERENCES item(id)
--);
--
CREATE TABLE testas (
    id INT AUTO_INCREMENT PRIMARY KEY,
   domain varchar(20),
   code varchar(20),
   meaning varchar(20),
   description varchar(300)
);
