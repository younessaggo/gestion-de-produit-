package com.sqli.gestiondeproduits.service;

import com.sqli.gestiondeproduits.model.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {

    Optional<List<Produit>> getAllProduits();

    Optional<Produit> getProduitById(Integer id);

    void ajouterProduit(Produit produit);

    void  updateProduit(Integer idProduit ,Produit produit);

    void deleteProduit(Integer idProduit );

}
