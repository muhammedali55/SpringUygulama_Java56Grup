package com.vektorel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class IlkspringApplication {
	// Spring Çalışmaya Başlayınca neler oluyor?
	// 1- Setting- Temel ayarların gelmesi ve ek olarak programcı tarfından girilen ayarları alınması gerekli
	//    Ayarlar 2 şekilde olur, @SpringConfig ayar sınıfları ile
	//    resources/ application.properties, application.yml dosyaları ile ayarlar eklenebilir.
	// 2- Uygulama hiyerarşisi içinde paket ve sınıfları ayarlar
	// NOT: Spring Run sınıfı her daim en üstte tek başına yer alsın.
	public static void main(String[] args) {
		SpringApplication.run(IlkspringApplication.class, args);
	}

}
