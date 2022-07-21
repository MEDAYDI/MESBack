package com.example.stageWeb.produit.Service;

import com.example.stageWeb.produit.Model.Produit;
import com.example.stageWeb.produit.Repository.ProduitRepo;
import com.example.stageWeb.produit.dto.ProduitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduitServiceImpl implements  ProduitSercive{

    ProduitRepo produitRepo;


    @Autowired
    public ProduitServiceImpl(ProduitRepo produitRepo) {
        this.produitRepo = produitRepo;
    }

    @Override
    public List<Produit> findAllProduit() {

        return produitRepo.findAll();
    }

    @Override
    public Produit findProduitById(Long id) {
        return produitRepo.findProduitById(id);
    }

    @Override
    public List<Produit> findProduitByOf(String of){
        return produitRepo.findProduitByOf(of);
    }

    @Override
     public List<Produit> findProduitByClient(String client){
        return  produitRepo.findProduitByClient(client); }

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }

   @Override
    public int updateProduitBy(Long id , Produit produit) {
         Produit newProduit =new Produit(produit.getOF(),produit.getClient(), produit.getLot(), produit.getQteLot(),produit.getQteFabriquer());
         return produitRepo.updateProduitBy(id,newProduit.getClient(),newProduit.getLot(), newProduit.getOF(), newProduit.getQteLot(),newProduit.getQteFabriquer() , newProduit.getCreateDate());
    }



    @Override
    public void deleteProduitById(Long id) {
            produitRepo.deleteProduitById(id);
    }


    // micro service
    @Override
    public void createProduit(ProduitRequest produitRequest) {
        Produit produit= new Produit(produitRequest.getOf(),produitRequest.getClient(),produitRequest.getLot(),produitRequest.getQteLot(),produitRequest.getQteFabriquer()) ;
        produitRepo.save(produit);


    }


}
