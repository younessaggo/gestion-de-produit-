package com.sqli.gestiondeproduits.controllor;

import com.sqli.gestiondeproduits.Exception.DuplicateProductException;
import com.sqli.gestiondeproduits.Exception.PrixProduitException;
import com.sqli.gestiondeproduits.Exception.ProduitNExistePas;
import com.sqli.gestiondeproduits.model.Produit;
import com.sqli.gestiondeproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public Optional<List<Produit>> recupererTousLesProduits(){
        return produitService.recupererTousLesProduits();
    }
    @PostMapping("/")
    public String ajouterProduit(@RequestBody Produit produit){
        try {
            produitService.ajouterProduit(produit);
            return "produit ajouter avec succe";
        }catch (DuplicateProductException duplicateProductException){
           return duplicateProductException.getMessage();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> recupererProduitParId(@PathVariable Integer id){
        Optional<Produit> produit=produitService.recupererProduitById(id);
        if(produit.isPresent()){
            return ResponseEntity.ok(produit.get());

        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public String mettreAJourProduit(@PathVariable Integer id ,@RequestBody Produit produit){
        try {
            produitService.mettreAJourProduit(id,produit);
            return "produit mit a jour avec succes";
        } catch (PrixProduitException | DuplicateProductException exception){
           return  exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String supprimerProduit(@PathVariable Integer id){
        try {
            produitService.supprimerProduit(id);

            return "produit supprimier avec succes";
        }catch (ProduitNExistePas produitExistePas){
            return produitExistePas.getMessage();
        }


    }

}
