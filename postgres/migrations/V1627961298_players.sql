CREATE TABLE IF NOT EXISTS players (
	player_id		SERIAL	PRIMARY KEY,
	name 			VARCHAR	NOT NULL,
	country 		VARCHAR NOT NULL,
	date_of_birth 	VARCHAR NOT NULL
);