package com.sqli.gestiondeproduits.dao;

import com.sqli.gestiondeproduits.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie,Integer> {
}
