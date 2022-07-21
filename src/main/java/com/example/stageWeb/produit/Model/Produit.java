package com.example.stageWeb.produit.Model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Produit")
@DynamicUpdate
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String of ;
    private String client ;
    private String lot ;
    private Integer qteLot ;
    private Integer qteFabriquer;
    private Date createDate =new Date(System.currentTimeMillis()) ;

    public Produit(){}

    public Produit(String of, String client, String lot, Integer qteLot, Integer qteFabriquer) {

       this.of=of;
        this.client = client;
        this.lot = lot;
        this.qteLot = qteLot;
        this.qteFabriquer=qteFabriquer;

    }
    public Produit(Long id, String of, String client, String lot, Integer qteLot, Integer qteFabriquer) {
        this.id=id;
        this.of=of;
        this.client = client;
        this.lot = lot;
        this.qteLot = qteLot;
        this.qteFabriquer=qteFabriquer;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOF() {
        return of;
    }

    public void setOF(String OF) {
        this.of = OF;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Integer getQteLot() {
        return qteLot;
    }

    public void setQteLot(Integer qteLot) {
        this.qteLot = qteLot;
    }

    public Integer getQteFabriquer() {
        return qteFabriquer;
    }

    public void setQteFabriquer(Integer qteFabriquer) {
        this.qteFabriquer = qteFabriquer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
