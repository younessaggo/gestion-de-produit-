package com.sqli.gestiondeproduits.service;

import com.sqli.gestiondeproduits.dao.ProduitDao;
import com.sqli.gestiondeproduits.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private  ProduitDao produitDao;
    @Override
    public Optional<List<Produit>> getAllProduits() {
        try {
            List<Produit> produits= produitDao.findAll();
            return Optional.ofNullable(produits);
        }
        catch (Exception e){
            System.out.println(" Error in getting all Produits "+e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Produit> getProduitById(Integer id) {
        return produitDao.findById(id);
    }

    @Override
    public void ajouterProduit(Produit produit) {
        produit.setPrixProduit(produit.getPrixProduit());
        produitDao.save(produit);

    }

    @Override
    public void updateProduit(Integer idProduit, Produit produit) {
        produitDao.findById(idProduit).ifPresent(produit1 -> {
            produit1.setCodeProduit(produit.getCodeProduit());
            produit1.setLibelleProduit(produit.getLibelleProduit());
            produit1.setPrixProduit(produit.getPrixProduit());
            produitDao.save(produit1);
        });

    }

    @Override
    public void deleteProduit(Integer idProduit) {
        produitDao.deleteById(idProduit);
    }
}
