package com.sqli.gestiondeproduits.dao;

import com.sqli.gestiondeproduits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitDao extends JpaRepository<Produit,Integer> {
}
