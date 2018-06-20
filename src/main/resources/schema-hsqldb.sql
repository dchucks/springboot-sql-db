CREATE SEQUENCE person_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE person(
        id bigint GENERATED BY DEFAULT AS SEQUENCE person_id_seq PRIMARY KEY,
	first_name 	VARCHAR(150),
	last_name 	VARCHAR(150),
	age					INTEGER,
	place				VARCHAR(100)
);
