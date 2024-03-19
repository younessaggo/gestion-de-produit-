package com.sqli.gestiondeproduits.Exception;

public class ProduitNExistePas extends RuntimeException{
    public ProduitNExistePas(String message){
        super(message);
    }
}
