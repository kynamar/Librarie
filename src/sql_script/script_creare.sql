/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Marian
 * Created: 21-Sep-2021
 */
drop table app.autori;
CREATE TABLE app.autori (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50),
data_nasteri date
);

insert into app.autori(nume,data_nasteri) values ('C. Marcel','1990-09-12');
insert into app.autori(nume,data_nasteri) values ('V. Aurel','1990-02-25');
select * from app.autori;
////
SELECT * FROM APP.EDITURI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.EDITURI;


CREATE TABLE app.edituri (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50)
);

insert into app.edituri(nume) values ('Squars');
insert into app.edituri(nume) values ('Romburi');
select * from app.edituri;
////
SELECT * FROM APP.CATEGORII FETCH FIRST 100 ROWS ONLY;

drop TABLE app.CATEGORII;


CREATE TABLE app.categorii (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50),
descriere varchar(200)
);
alter table categorii add constraint categorii_nume unique (nume);
insert into app.categorii(nume, descriere) values ('Actiune','');
insert into app.categorii(nume, descriere) values ('Educativ','');
select * from app.categorii;
////
SELECT * FROM APP.CARTI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.CARTI;


CREATE TABLE app.carti (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
id_editura INTEGER NOT NULL,
isbn varchar(50) NOT NULL,
nume varchar(50) NOT NULL,
descriere varchar(200),
pret double
);
Alter Table APP.CARTI
Add FOREIGN KEY (ID_EDITURA)
References APP.EDITURI (ID);
alter table carti add constraint carti_isbn unique (isbn);
insert into app.carti(id_editura,isbn,nume, descriere,pret) values (2,'ab0001','Pere','',12.4);
insert into app.carti(id_editura,isbn,nume, descriere,pret) values (1,'ab0002','Carnage','',36.99);
select * from app.carti;
////
SELECT * FROM APP.RAFTURI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.rafturi;


CREATE TABLE app.rafturi (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50) NOT NULL,
nr_linii INTEGER NOT NULL,
nr_coloane INTEGER NOT NULL
);
alter table rafturi add constraint rafturi_nume unique (nume);
insert into app.rafturi(nume,nr_linii,nr_coloane) values ('B1',2,2);
insert into app.rafturi(nume,nr_linii,nr_coloane) values ('B2',2,2);
select * from app.rafturi;
////
SELECT * FROM APP.RANDURI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.randuri;


CREATE TABLE app.randuri (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50) NOT NULL,
id_rafturi INTEGER NOT NULL
);
Alter Table APP.RANDURI
Add FOREIGN KEY (ID_RAFTURI)
References APP.RAFTURI (ID);
insert into app.randuri(nume,id_rafturi) values ('A1',1);
insert into app.randuri(nume,id_rafturi) values ('A2',2);
select * from app.randuri;
////
SELECT * FROM APP.AUTORI_CARTI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.AUTORI_CARTI;


CREATE TABLE app.AUTORI_CARTI (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
id_autor INTEGER NOT NULL,
id_carte INTEGER NOT NULL
);
Alter Table APP.AUTORI_CARTI
Add FOREIGN KEY (ID_AUTOR)
References APP.AUTORI (ID);
Alter Table APP.AUTORI_CARTI
Add FOREIGN KEY (ID_CARTE)
References APP.CARTI (ID);
insert into app.autori_carti(id_autor,id_carte) values (1,1);
insert into app.autori_carti(id_autor,id_carte) values (2,2);
select * from app.autori_carti;
////
SELECT * FROM APP.TIPURI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.TIPURI;


CREATE TABLE app.TIPURI (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50) NOT NULL
);
insert into app.tipuri(nume) values ('Pensionar');
insert into app.tipuri(nume) values ('Elev');
select * from app.tipuri;
////
SELECT * FROM APP.PERSOANE FETCH FIRST 100 ROWS ONLY;

drop TABLE app.PERSOANE;


CREATE TABLE app.PERSOANE (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50) NOT NULL,
cnp varchar(13) NOT NULL
);
alter table persoane add constraint persoane_cnp unique (cnp);
insert into app.persoane(nume,cnp) values ('Ianis','0203410203412');
insert into app.persoane(nume,cnp) values ('Ion','0001930203416');
select * from app.persoane;
////
SELECT * FROM APP.TIPURI_PERSOANE FETCH FIRST 100 ROWS ONLY;

drop TABLE app.tipuri_persoane;


CREATE TABLE app.tipuri_persoane (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
id_persoane INTEGER NOT NULL,
id_tipuri INTEGER NOT NULL,
date_start date NOT NULL,
date_end date NOT NULL
);
Alter Table APP.TIPURI_PERSOANE
Add FOREIGN KEY (ID_PERSOANE)
References APP.PERSOANE (ID);
Alter Table APP.TIPURI_PERSOANE
Add FOREIGN KEY (ID_TIPURI)
References APP.TIPURI (ID);
insert into app.tipuri_persoane(id_persoane,id_tipuri,date_start,date_end) values (1,1,'2000-02-12','2005-02-12');
insert into app.tipuri_persoane(id_persoane,id_tipuri,date_start,date_end) values (2,2,'2000-04-14','2005-04-14');
select * from app.tipuri_persoane;
////
SELECT * FROM APP.ABONAMENTE FETCH FIRST 100 ROWS ONLY;

drop TABLE app.abonamente;


CREATE TABLE app.abonamente (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50) NOT NULL,
durata INTEGER NOT NULL,
tip INTEGER NOT NULL,
pret double not null
);

Alter Table APP.ABONAMENTE
Add FOREIGN KEY (TIP)
References APP.TIPURI (ID);
insert into app.abonamente(nume,durata,tip,pret) values ('Basic',150,3,50);
insert into app.abonamente(nume,durata,tip,pret) values ('Stunet Only',360,4,80);
select * from app.abonamente;
////
SELECT * FROM APP.IMPRUMUTURI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.IMPRUMURI;


CREATE TABLE app.IMPRUMUTURI (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
id_persoane INTEGER NOT NULL,
id_carti INTEGER NOT NULL,
data_imprumut DATE NOT NULL,
data_returnare DATE NOT NULL,
descriere varchar(100)
);
Alter Table APP.IMPRUMUTURI
Add FOREIGN KEY (id_persoane)
References APP.PERSOANE (ID);
Alter Table APP.IMPRUMUTURI
Add FOREIGN KEY (id_carti)
References APP.CARTI (ID);
insert into app.imprumuturi(id_persoane,id_carti,data_imprumut,data_returnare,descriere) values (1,1,'2003-06-12','2003-08-11','');
insert into app.imprumuturi(id_persoane,id_carti,data_imprumut,data_returnare,descriere) values (2,2,'2004-04-15','2005-03-12','');
select * from app.imprumuturi;
////
SELECT * FROM APP.PERSOANE_ABONAMENTE FETCH FIRST 100 ROWS ONLY;

drop TABLE app.persoane_abonamente;


CREATE TABLE app.persoane_abonamente (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
id_persoane INTEGER NOT NULL,
id_abonamente INTEGER NOT NULL,
id_operatori integer not null,
data_incepere date not null,
data_incheiere date not null
);
Alter Table APP.PERSOANE_ABONAMENTE
Add FOREIGN KEY (id_persoane)
References APP.PERSOANE (ID);
Alter Table APP.PERSOANE_ABONAMENTE
Add FOREIGN KEY (id_abonamente)
References APP.ABONAMENTE (ID);
Alter Table APP.PERSOANE_ABONAMENTE
Add FOREIGN KEY (id_operatori)
References APP.OPERATORI (ID);
insert into app.persoane_abonamente(id_persoane,id_abonamente,id_operatori,data_incepere,data_incheiere) values (1,1,1,'2000-04-21','2000-07-21');
insert into app.persoane_abonamente(id_persoane,id_abonamente,id_operatori,data_incepere,data_incheiere) values (2,2,2,'2000-03-01','2000-09-11');
select * from app.persoane_abonamente;
////
SELECT * FROM APP.OPERATORI FETCH FIRST 100 ROWS ONLY;

drop TABLE app.operatori;


CREATE TABLE app.operatori (
id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nume varchar(50)not null,
parola varchar(50)not null,
id_persoane INTEGER NOT NULL,
activ boolean not null
);
Alter Table APP.OPERATORI
Add FOREIGN KEY (id_persoane)
References APP.PERSOANE (ID);
insert into app.operatori(nume,parola,id_persoane,activ) values ('Andrei','CeVa',1,true);
insert into app.operatori(nume,parola,id_persoane,activ) values ('Ion','ion',2,true);
select * from app.operatori;

