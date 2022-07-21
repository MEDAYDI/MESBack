package com.example.stageWeb.produit.controller;

import com.example.stageWeb.produit.Model.Produit;
import com.example.stageWeb.produit.Service.ProduitSercive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/produit")
public class ProduitController {
    ProduitSercive produitSercive ;
    RestTemplate restTemplate = new RestTemplate() ;
    private String baseUrl="http://localhost:8081";

    public ProduitController(ProduitSercive produitSercive) {
        this.produitSercive = produitSercive;
    }

    @GetMapping()
    public ResponseEntity<List<Produit>> getAll(){
        List<Produit> produits=produitSercive.findAllProduit();
        return  new ResponseEntity<>(produits , HttpStatus.OK);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable("id") Long id){
        Produit produit = produitSercive.findProduitById(id);
        return  new ResponseEntity<>(produit,HttpStatus.OK);
    }
    @GetMapping("/findOf/{of}")
    public  ResponseEntity<List<Produit>> getProduitByOf(@PathVariable("of") String of){
        List<Produit> produit=produitSercive.findProduitByOf( of) ;
        return  new ResponseEntity<>(produit,HttpStatus.OK);
    }

    @GetMapping("/findClient/{client}")
    public  ResponseEntity<List<Produit>> getProduitByClient(@PathVariable("client") String client){
        List<Produit> produit=produitSercive.findProduitByClient(client) ;
        return  new ResponseEntity<>(produit,HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Produit> addProduit (@RequestBody Produit produit){
        Produit newProduit=produitSercive.addProduit(produit);
        ResponseEntity<List> resProduit =restTemplate.postForEntity(baseUrl+"/api/order/addmicro" ,produit,List.class );
        return  new ResponseEntity<>(newProduit,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable("id") Long id , @RequestBody Produit produit){
            int res =produitSercive.updateProduitBy(id ,produit);
             restTemplate.put(baseUrl+"/api/order/updatemicro/"+id,produit);
                    return  new ResponseEntity<>(produit,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteProduit(@PathVariable("id") Long id){
       produitSercive.deleteProduitById(id);
       restTemplate.delete(baseUrl+"/api/order/delmicro/"+id);
       return  new ResponseEntity<>(HttpStatus.OK);
    }


}
