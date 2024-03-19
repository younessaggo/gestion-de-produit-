package com.sqli.gestiondeproduits.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;

    @Column(unique = true)
    private String codeProduit;

    private String libelleProduit;

    private double prixProduit;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public void setPrixProduit(double prixProduit) {
        if(prixProduit > 0){
            this.prixProduit=prixProduit;
        }
        else {
            throw new IllegalArgumentException("le prix doit etre superieur a 0");
        }
    }
}
