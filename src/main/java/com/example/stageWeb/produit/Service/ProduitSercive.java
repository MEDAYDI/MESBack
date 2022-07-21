package com.example.stageWeb.produit.Service;

import com.example.stageWeb.produit.Model.Produit;
import com.example.stageWeb.produit.dto.ProduitRequest;

import java.util.List;

public interface ProduitSercive {
    List<Produit> findAllProduit();
    Produit addProduit(Produit produit);
    int updateProduitBy(Long id , Produit produit);
    Produit findProduitById(Long id);
    public void deleteProduitById(Long id);
    public List<Produit> findProduitByOf(String of);
    public List<Produit> findProduitByClient(String client);
    // micro service
    public  void createProduit( ProduitRequest produitRequest);

}
