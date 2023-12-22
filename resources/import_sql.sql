-- Füge diese Daten in die Datenbank ein NACHDEM du die Applikation zum ersten mal gestartet hast

INSERT INTO role (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO Status (id, name) VALUES (1, 'STATUS_OFFEN');
INSERT INTO Status (id, name) VALUES (2, 'STATUS_IN_BEARBEITUNG');
INSERT INTO Status (id, name) VALUES (3, 'STATUS_ABGESCHLOSSEN');
