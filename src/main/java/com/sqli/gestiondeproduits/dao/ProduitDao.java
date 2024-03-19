package com.sqli.gestiondeproduits.dao;

import com.sqli.gestiondeproduits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitDao extends JpaRepository<Produit,Integer> {
    Optional<Produit> findByCodeProduit(String code);
}
