CREATE TABLE manager(
    manager_id      NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    name            VARCHAR(30) NOT NULL,
    surname         VARCHAR(30) NOT NULL,
    spec            VARCHAR(5)  CHECK(spec IN ('rent', 'sale', 'buy', 'trade')) NOT NULL,
    comission       NUMBER      CHECK(comission > 0 AND comission < 100) NOT NULL,
    password        VARCHAR(70) NOT NULL
);  

CREATE TABLE room(
    room_id         NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    type            VARCHAR(10) CHECK(type IN('isolated', 'adjacent')) NOT NULL,
    area            NUMBER      CHECK(area > 0) NOT NULL
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

CREATE TABLE kitchen(
    kitchen_id      NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    area            NUMBER      CHECK(area > 0) NOT NULL,
    cooker_type     VARCHAR(10) CHECK(cooker_type IN('gas', 'electric')) NOT NULL
);

CREATE TABLE customer(
    customer_id     NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    name            VARCHAR(30) NOT NULL,
    surname         VARCHAR(30) NOT NULL
);

CREATE TABLE property(
    property_id     NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    house_id        NUMBER      REFERENCES house(house_id) NOT NULL,
    floor           NUMBER      CHECK(floor > 0) NOT NULL,
    apartments      NUMBER      CHECK(apartments > 0) NOT NULL,
    area            NUMBER      CHECK(area > 0) NOT NULL,
    num_of_rooms    NUMBER      CHECK(num_of_rooms > 0) NOT NULL,
    kitchen_id      NUMBER      REFERENCES kitchen(kitchen_id) NOT NULL,
    bathroom_type   VARCHAR(10) CHECK(bathroom_type IN ('combined', 'isolated')) NOT NULL,
    has_bath        VARCHAR(1)  CHECK(has_bath IN ('Y', 'N')) NOT NULL,
    has_balcony     VARCHAR(1)  CHECK(has_balcony IN ('Y', 'N')) NOT NULL 
);

CREATE TABLE property_room(
    property_room_id NUMBER     GENERATED AS IDENTITY PRIMARY KEY,
    property_id     NUMBER      REFERENCES property(property_id) NOT NULL,
    room_id         NUMBER      REFERENCES room(room_id) NOT NULL
);

CREATE TABLE exchange(
    exchange_id     NUMBER      GENERATED AS IDENTITY PRIMARY KEY,
    manager_id      NUMBER      REFERENCES manager(manager_id) NOT NULL,
    customer_id     NUMBER      REFERENCES customer(customer_id)  NOT NULL,
    property_id     NUMBER      REFERENCES property(property_id)  NOT NULL,
    worth           NUMBER      CHECK(worth > 0) NOT NULL,
    start_date      DATE        DEFAULT sysdate NOT NULL,
    expire_date     DATE        DEFAULT sysdate NOT NULL
);

DROP TABLE exchange;
DROP TABLE property_room;
DROP TABLE property;
DROP TABLE customer;
DROP TABLE kitchen;
DROP TABLE house;
DROP TABLE room;
DROP TABLE manager;
