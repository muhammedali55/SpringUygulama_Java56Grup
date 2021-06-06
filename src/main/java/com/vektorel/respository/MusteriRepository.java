package com.vektorel.respository;

import com.vektorel.respository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri,Long> {

    //Örnek
    /*
    public void save() {
        Musteri mst = Musteri.builder()
                        .ad("Ahmet")
                        .aciklama("Selam")
                        .id(1).build();

    }
    */
    List<Musteri> findAllByAdAndBySoyad(String Ad, String Soyad);
}
