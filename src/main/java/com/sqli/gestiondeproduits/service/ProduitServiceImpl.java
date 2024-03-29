package com.sqli.gestiondeproduits.service;

import com.sqli.gestiondeproduits.Exception.DuplicateProductException;
import com.sqli.gestiondeproduits.Exception.PrixProduitException;
import com.sqli.gestiondeproduits.Exception.ProduitNExistePas;
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
    public Optional<List<Produit>> recupererTousLesProduits() {
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
    public Optional<Produit> recupererProduitById(Integer id) {
        if(produitDao.findById(id).isEmpty()){
            throw new ProduitNExistePas("le produit que vous voulez supprimer n'exitse pas ");
        }
        return produitDao.findById(id);
    }

    @Override
    public void ajouterProduit(Produit produit) {
        if(produit.getPrixProduit()<=0){
            throw  new PrixProduitException("le prix d'un produit doit etre superieur a 0");
        }
        if (produitDao.findByCodeProduit(produit.getCodeProduit()).isPresent()){
            throw new DuplicateProductException("un produit avec le meme code deja existe");
        }
        produit.setPrixProduit(produit.getPrixProduit());
        produitDao.save(produit);

    }

    @Override
    public void mettreAJourProduit(Integer idProduit, Produit produit) {
        if(produit.getPrixProduit()<=0){
            throw  new PrixProduitException("le prix d'un produit doit etre superieur a 0");
        }
        if (produitDao.findByCodeProduit(produit.getCodeProduit()).isPresent()){
            throw new DuplicateProductException("un produit avec le meme code deja existe");
        }
        produitDao.findById(idProduit).ifPresent(produit1 -> {
            produit1.setCodeProduit(produit.getCodeProduit());
            produit1.setLibelleProduit(produit.getLibelleProduit());
            produit1.setPrixProduit(produit.getPrixProduit());
            produitDao.save(produit1);
        });

    }

    @Override
    public void supprimerProduit(Integer idProduit) {
        if(produitDao.findById(idProduit).isEmpty()){
            throw new ProduitNExistePas("le produit que vous voulez supprimer n'exitse pas ");
        }
        produitDao.deleteById(idProduit);
    }
}
