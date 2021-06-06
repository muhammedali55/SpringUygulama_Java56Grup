package com.vektorel.respository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblmusteri")
@Entity
public class Musteri implements Serializable {
    // Lombok Project
    // bir pojo içinde get,set paraetleri kullanılır. ve bu iş zahmetlidir.
    // lombok get,set,constructor gibi bileşenleri otomatik ekler

    // AllArgsConstructor nedir
    /*
    public Musteri(long id, String aciklama, String ad, String adres, String soyad, String tckimlik, String telefon) {
        this.id = id;
        this.aciklama = aciklama;
        this.ad = ad;
        this.adres = adres;
        this.soyad = soyad;
        this.tckimlik = tckimlik;
        this.telefon = telefon;
    }
    */
    // NoArgsConstructor nedir?
    /*
    public Musteri(){

    }
    */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String aciklama;
    String ad;
    String adres;
    String soyad;
    String tckimlik;
    String telefon;

}
