//creer table produit:

create table produit(
        idproduit SERIAL primary key,
        nomproduit varchar(30),
        prix NUMERIC(9,2),
        quantite int);

//inserttest 

insert into produit (idproduit,nomproduit,prix,quantite) values (1,'le java de j-m',32,44);

//creer table achat:

CREATE TABLE achat (
    idproduit int REFERENCES produit(idproduit),
    fournisseur varchar(30),
    date Date DEFAULT current_timestamp,
    nbrachat int,
    livre bool DEFAULT false
);

//inserttest :

insert into achat (idproduit,fournisseur,date,nbrachat) values (1,'java.com','13-12-2022',23);

//test liaison:

select nomproduit,prix from achat inner join produit on produit.idproduit=achat.idproduit;

//test ajout prod :

UPDATE produit
SET quantite = quantite + achat.nbrachat
FROM achat
WHERE produit.idproduit = achat.idproduit
AND achat.livre = false;

//passer en false quand produit ajouter

UPDATE achat
SET livre = true
FROM produit
WHERE achat.livre = false 
AND achat.idproduit = produit.idproduit;

//creer la table panier

create table panier (
idproduit int references produit(idproduit));

//insert:

insert into panier values (1);

//test:

select nomproduit,prix from panier inner join produit on produit.idproduit=panier.idproduit; 

//creer table vente

create table vente (
idproduit int references produit (idproduit),
dateachat date);


//passer les données de panier vers vente

INSERT INTO vente (idproduit, dateachat)
SELECT idproduit, CURRENT_DATE
FROM panier;

//vider le panier

TRUNCATE TABLE panier;

