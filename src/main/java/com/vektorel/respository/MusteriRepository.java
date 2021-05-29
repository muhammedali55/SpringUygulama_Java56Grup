package com.vektorel.respository;

import com.vektorel.respository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;

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

}
