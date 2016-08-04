-- USERS
CREATE USER IF NOT EXISTS SA
  SALT '6a0e04afeac6bccc' HASH '065c94fe8fb12546403bd50ab883a59cd664b25ceb9f7bd8a1420a74099d0d3b' ADMIN;

-- SEQUENCE
CREATE SEQUENCE event_type_seq INCREMENT BY 1;
CREATE SEQUENCE event_seq INCREMENT BY 1;

-- TABLES
CREATE TABLE event_types(
  id INT NOT NULL DEFAULT nextval('event_type_seq') PRIMARY KEY,
  type VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE events(
  id BIGINT NOT NULL DEFAULT nextval('event_seq') PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  event_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  event INT NOT NULL,
  description VARCHAR(100),
  FOREIGN KEY (event) REFERENCES event_types(id)
);