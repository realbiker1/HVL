DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;

CREATE TABLE Avdeling (
  Id         SERIAL,
  Navn       VARCHAR(30),
  Sjef_Id    INTEGER NOT NULL, -- En avdeling MÅ ha en sjef

  CONSTRAINT Avdeling_PK PRIMARY KEY (Id)
);

CREATE TABLE Ansatt
(
  Id         	SERIAL,
  Brukernavn 	VARCHAR(3),
  Fornavn    	VARCHAR(30),
  Etternavn  	VARCHAR(30),
  Ansdato    	DATE,
  Stilling   	VARCHAR(30),
  Maanedsloenn  INTEGER,
  Avd_Id      	INTEGER NOT NULL,
  Prosjekter    VARCHAR(100),
  
  CONSTRAINT Ansatt_PK PRIMARY KEY (Id),
  CONSTRAINT Avdeling_FK FOREIGN KEY (Avd_Id)
	REFERENCES Avdeling(Id)
);

INSERT INTO 
 Avdeling(Navn, Sjef_Id) 
VALUES
 ('Administrasjonen', 1),
 ('Dataavdelingen', 2),
 ('Salgsavdelingen', 3);

INSERT INTO Ansatt(Brukernavn, Fornavn, Etternavn, Ansdato, Stilling, Maanedsloenn, Avd_Id) VALUES
 ('KUL', 'Kurt', 'Lillebakke', '2016-11-04', 'CEO', '50000', '1'),
 ('ABC', 'Abel', 'Cellevåg', '2018-02-01', 'Programmerer', '41000', '2'),
 ('FIN', 'Kurt', 'Lillebakke', '2021-08-15', 'Salgssjef', '42000', '3');

ALTER TABLE Avdeling ADD CONSTRAINT Sjef_FK FOREIGN KEY (Sjef_Id) 
  		REFERENCES Ansatt(Id);

INSERT INTO
  Ansatt(Brukernavn, Fornavn, Etternavn, Ansdato, Stilling, Maanedsloenn, Avd_Id)
VALUES
 ('LAV', 'Laila', 'Vilhelmsen', '2020-09-11', 'HR-Ansvarlig', '45000', '1'),
 ('HET', 'Hector', 'Trabajo', '2018-11-03', 'HR-Ansatt', '41000', '1'),
 ('ERT', 'Erdogan', 'Turkye', '2018-01-10', 'Programmerer', '33000', '2'),
 ('BEN', 'Bente', 'Nilsen', '2017-10-16', 'Webdesigner', '40000', '2'),
 ('TUR', 'Turid', 'Roheim', '2019-03-29', 'Webdesigner', '28000', '2'),
 ('NIS', 'Nils', 'Skills', '2017-12-18', 'Selger', '40000', '3'),
 ('LIM', 'Lise', 'Monsen', '2018-05-23', 'Selger', '38000', '3');