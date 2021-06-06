package com.vektorel.services;

import com.vektorel.dto.request.SaveMusteriRequestDto;
import com.vektorel.mapper.MusteriMapper;
import com.vektorel.respository.MusteriRepository;
import com.vektorel.respository.entity.Musteri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

// Bir servis' in spring tarafından tanına bilmesi için onun
// @Service annotasyonu ile işaretlenmesi gereklidir.
@Service
public class MusteriService {
    // tanımlanan bir interface nin kullanılabimesi için içinin
    // ilgili veriler ile doldurulması gereklidir. bunu spring
    // tarafında yöneten kodlama @Autowired annoatasyonudur
    @Autowired
    private MusteriRepository repository;

    @Autowired
    private MusteriMapper musteriMapper;

    public void save(SaveMusteriRequestDto mst){
        // Eğer nesne içindeki primary key(id) null ise
        // kayıt işlemi gerçekleşir
        repository.save(musteriMapper.toMusteri(mst));
    }
    public void update(Musteri mst){
        // id bilgisi null değil ise güncelleme işlemi gerçekleşir.
        // hangi bilgiler güncellnir.
        // null olanlar sabir kalır, olmayanlar değişir.
        repository.save(mst);
    }
    public void delete(Musteri mst){
        repository.delete(mst);
    }

    @Cacheable(cacheNames = "postgresqlGetAll")
    public List<Musteri> getAll(){
        return repository.findAll();
    }


}
