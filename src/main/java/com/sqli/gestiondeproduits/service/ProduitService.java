package com.sqli.gestiondeproduits.service;

import com.sqli.gestiondeproduits.model.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    Optional<List<Produit>> recupererTousLesProduits();

    Optional<Produit> recupererProduitById(Integer id);

    void ajouterProduit(Produit produit);

    void  mettreAJourProduit(Integer idProduit ,Produit produit);

    void supprimerProduit(Integer idProduit );

}
