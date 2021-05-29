package com.vektorel.controllers;

// Bu sınıfın bir controller olduğunu springe göstermek için
// @Controller annotasyonu eklenmelidir.
// Eğer RestFull web servisleri yazacak iseniz @RestCotroller
// Bu sınıfa URL ile kullanıcıların ulaşabilmesi içni
// @RequestMapping annotasyonu eklenir ve yol belirlenir.
import com.vektorel.dto.request.SaveMusteriRequestDto;
import com.vektorel.mapper.MusteriMapper;
import com.vektorel.respository.entity.Musteri;
import com.vektorel.services.MusteriService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("v1/musteri")
@Api(value = "Müşteri Kontol Api si burada müşterilerin kayıt ve listeleme işlemleri yapılır")
public class MusteriController {

    @Autowired
    MusteriService musteriService;


    // Bir kullanıcı bu sınıfa istekte bulunduğunda
    // sınıf içindeki hangi methoda gitmek istiyor ise onun
    // istektürü belirtilerek adresi yazılır
    // GET: localhost:9090/v1/musteri/getname
    // YANLIŞ  @GetMapping(name = "/getname")
    @GetMapping("/getname")
    public String getName() {
        return "Muhammet";
    }

    @PostMapping("/vucutkitleindexi")
    public Double hesapla(double boy, double kilo){
        double bmi = kilo /(boy*boy);
        return bmi;
    }

    @PostMapping("/resimyukle")
    public String resimyukle(MultipartFile file){
        return "yüklendi";
    }

    @GetMapping("/getAllMusteri")
    public ResponseEntity<List<Musteri>> getAllMusteri(){
        return ResponseEntity.ok(musteriService.getAll());
    }

    @PostMapping("/savemusteri")
    public ResponseEntity<Void> saveMusteri(@RequestBody SaveMusteriRequestDto musteriRequestDto){

//        Musteri musteri = new Musteri();
//        musteri.setTckimlik(musteriRequestDto.getTckimlik());
//        musteri.setAd(musteriRequestDto.getAd());
//        musteri.setSoyad(musteriRequestDto.getSoyad());
//        musteriService.save(musteri);

        musteriService.save(musteriRequestDto);
        return ResponseEntity.ok().build();
    }
}

