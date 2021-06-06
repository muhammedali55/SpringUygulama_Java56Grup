package com.vektorel.respository.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.UUID;

@Document
public class MongoMusteri implements Serializable {

    // Döküman tipi pojo sınıflarında,Lombok Kullanmayın.
    // Get ve Set methodlarını uygulama görmüyor. bu nedenle kayıt ve okuma işlemlerinde sorun yaşanıyor.
    @MongoId
    String id;
    String aciklama;
    String ad;
    String adres;
    String soyad;
    String tckimlik;
    String telefon;

    public MongoMusteri() {
    }

    @JsonCreator
    public MongoMusteri(String id, String aciklama, String ad, String adres, String soyad, String tckimlik, String telefon) {
        this.id = UUID.randomUUID().toString();
        this.aciklama = aciklama;
        this.ad = ad;
        this.adres = adres;
        this.soyad = soyad;
        this.tckimlik = tckimlik;
        this.telefon = telefon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTckimlik() {
        return tckimlik;
    }

    public void setTckimlik(String tckimlik) {
        this.tckimlik = tckimlik;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
