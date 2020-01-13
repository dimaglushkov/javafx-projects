CREATE TABLE manager(
    manager_id      NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    name            VARCHAR(30) NOT NULL,
    surname         VARCHAR(30) NOT NULL,
    spec            VARCHAR(5)  CHECK(spec IN ('rent', 'sale', 'buy', 'trade')) NOT NULL,
    comission       NUMBER      CHECK(comission > 0 AND comission < 100) NOT NULL,
    password        VARCHAR(70) NOT NULL
);  

CREATE TABLE house(
    house_id        NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    district        VARCHAR(30) NOT NULL,
    street          VARCHAR(30) NOT NULL,
    num             NUMBER      CHECK(num > 0) NOT NULL,
    type            VARCHAR(10) CHECK(type IN ('panel', 'bricks', 'blocks', 'ship', 'monolit')) NOT NULL,
    num_of_floors   NUMBER      CHECK(num_of_floors > 0) NOT NULL,
    series          VARCHAR(10) NOT NULL
);

CREATE TABLE property(
    property_id     NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    house_id        NUMBER      REFERENCES house(house_id) NOT NULL,
    floor           NUMBER      CHECK(floor > 0) NOT NULL,
    apartments      NUMBER      CHECK(apartments > 0) NOT NULL,
    area            NUMBER      CHECK(area > 0) NOT NULL,
    num_of_rooms    NUMBER      CHECK(num_of_rooms > 0) NOT NULL,
    has_bath        VARCHAR(1)  CHECK(has_bath IN ('Y', 'N')) NOT NULL,
    has_balcony     VARCHAR(1)  CHECK(has_balcony IN ('Y', 'N')) NOT NULL 
);

----
-- DROP TABLE property;
-- DROP TABLE house;
-- DROP TABLE manager;
