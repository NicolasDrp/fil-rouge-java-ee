//creer table produit:

create table produit(
        idproduit SERIAL primary key,
        nomproduit varchar(30),
        prix NUMERIC(9,2),
        quantite int);


//creer table achat:

create table achat(
    idproduit int REFERENCES produit(idproduit),
    fournisseur varchar(30),
    date Date,
    nbrachat int,
    livré bool default false);

//inserttest :

insert into achat (idproduit,fournisseur,date,nbrachat) values (1,'java.com','13-12-2022',23);

//test liaison:

select nomproduit,prix from achat inner join produit on produit.idproduit=achat.idproduit;

//test ajout prod :

UPDATE produit
SET quantite = quantite + achat.nbrachat
FROM achat
WHERE produit.idproduit = achat.idproduit
AND achat.livré = false;

//passer en false quand produit ajouter

UPDATE achat
SET livré = true
FROM produit
WHERE achat.livré = false 
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

