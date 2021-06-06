package com.vektorel.controllers;

// Bu sınıfın bir controller olduğunu springe göstermek için
// @Controller annotasyonu eklenmelidir.
// Eğer RestFull web servisleri yazacak iseniz @RestCotroller
// Bu sınıfa URL ile kullanıcıların ulaşabilmesi içni
// @RequestMapping annotasyonu eklenir ve yol belirlenir.
import com.vektorel.dto.request.SaveMusteriRequestDto;
import com.vektorel.exceptions.ExampleManagerException;
import com.vektorel.mapper.MusteriMapper;
import com.vektorel.respository.entity.MongoMusteri;
import com.vektorel.respository.entity.Musteri;
import com.vektorel.services.MongoMusteriService;
import com.vektorel.services.MusteriService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/musteri")
@Api(value = "Müşteri Kontol Api si burada müşterilerin kayıt ve listeleme işlemleri yapılır")
public class MusteriController {

    @Autowired
    MusteriService musteriService;

    @Autowired
    MongoMusteriService mongoMusteriService;

    // Bir kullanıcı bu sınıfa istekte bulunduğunda
    // sınıf içindeki hangi methoda gitmek istiyor ise onun
    // istektürü belirtilerek adresi yazılır
    // GET: localhost:9090/v1/musteri/getname
    // YANLIŞ  @GetMapping(name = "/getname")
    @GetMapping("/getname")
    public String getName() {
        Musteri mst;
        Long start = System.currentTimeMillis();
        for (int i=0; i<10000;i++ ){
            mst = new Musteri();
            mst.setAd("Muhammet...: "+i);
            mst.setSoyad("HOCA....: "+i);
            mst.setTckimlik("11111111111");
            mst.setAciklama("Yok");
            mst.setAdres("Ankara");
            mst.setTelefon("0 555 555 5555");
            musteriService.update(mst);
        }
        Long end = System.currentTimeMillis();
        System.out.println("PosgreSave...: "+ (end-start));

        MongoMusteri mst1;
        start = System.currentTimeMillis();
        for (int i=0; i<10000;i++ ){
            mst1 = new MongoMusteri();
            mst1.setAd("Muhammet...: "+i);
            mst1.setSoyad("HOCA....: "+i);
            mst1.setTckimlik("11111111111");
            mst1.setAciklama("Yok");
            mst1.setAdres("Ankara");
            mst1.setTelefon("0 555 555 5555");
            mongoMusteriService.save(mst1);
        }
        end = System.currentTimeMillis();
        System.out.println("MongoSave...: "+ (end-start));
        return "Muhammet";
    }

    @PostMapping("/vucutkitleindexi")
    public Double hesapla(double boy, double kilo){
        double bmi = kilo /(boy*boy);
        return bmi;
    }

    @PostMapping("/resimyukle")
    public String resimyukle(MultipartFile file) throws ExampleManagerException
    {
        return "yüklendi";
    }

    @PostMapping("/saveMongoMusteri")
    public ResponseEntity<Void> saveMongoMusteri(@RequestBody MongoMusteri musteri){
        mongoMusteriService.save(musteri);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllMongoMusteri")
    public ResponseEntity<List<MongoMusteri>> getAllMongoMusteri()
    {
        Long start = System.currentTimeMillis();
        List<MongoMusteri> result = mongoMusteriService.getAll();
        Long end = System.currentTimeMillis();
        System.out.println("Mongo Müşteri Time...: "+(end-start));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllMusteri")
    public ResponseEntity<List<Musteri>> getAllMusteri(){
        Long start = System.currentTimeMillis();
        List<Musteri> result = musteriService.getAll();
        Long end = System.currentTimeMillis();
        System.out.println("Postgre Müşteri Time...: "+(end-start));
        return ResponseEntity.ok(result);
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

