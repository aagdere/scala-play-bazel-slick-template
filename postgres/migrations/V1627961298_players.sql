CREATE TABLE IF NOT EXISTS players (
	player_id		SERIAL	PRIMARY KEY,
	name 			VARCHAR	NOT NULL,
	country 		VARCHAR NOT NULL,
	date_of_birth 	DATE NOT NULL,
	created			TIMESTAMPTZ NOT NULL
);