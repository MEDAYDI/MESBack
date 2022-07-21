package com.example.stageWeb.produit.controller;

import com.example.stageWeb.produit.Model.Produit;
import com.example.stageWeb.produit.Service.ProduitSercive;
import com.example.stageWeb.produit.dto.ProduitRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api/produit")
public class MicroServiceController {
    RestTemplate restTemplate = new RestTemplate() ;


    ProduitSercive produitSercive ;

    public MicroServiceController(ProduitSercive produitSercive) {
        this.produitSercive = produitSercive;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public  void createProduit(@RequestBody ProduitRequest produitRequest){
           produitSercive.createProduit(produitRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getAllProducts(){
     return  produitSercive.findAllProduit() ;
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delProduit(@PathVariable("id") Long id){
         produitSercive.deleteProduitById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduit(@PathVariable("id") Long id , @RequestBody Produit response){
       int update = produitSercive.updateProduitBy(id ,response);
    }
}
