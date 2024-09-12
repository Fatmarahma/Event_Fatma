-- Tabel Commitee (Panitia)
CREATE TABLE commitee (
	id SERIAL PRIMARY KEY,
	commitee_name VARCHAR(250) NOT NULL,
	commite_position VARCHAR(250)
);

DROP TABLE commitee


-- Tabel Event
CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    start_on TIMESTAMP NOT NULL,
    complete_on TIMESTAMP NOT NULL,
    participant INT NOT NULL,
    location VARCHAR(250) NOT NULL,
    commitee_id INT,
    version INT,
    FOREIGN KEY (commitee_id) REFERENCES commitee(id) ON DELETE CASCADE
);

-- Tabel participants
CREATE TABLE participants (
	id SERIAL PRIMARY KEY,
	event_id INT,
	participant_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE
);
