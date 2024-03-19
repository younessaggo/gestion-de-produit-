package com.sqli.gestiondeproduits.controllor;

import com.sqli.gestiondeproduits.model.Produit;
import com.sqli.gestiondeproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public Optional<List<Produit>> getAllProduit(){
        return produitService.getAllProduits();
    }
    @PostMapping("/")
    public void ajouterProduit(@RequestBody Produit produit){
        produitService.ajouterProduit(produit);
    }

}
