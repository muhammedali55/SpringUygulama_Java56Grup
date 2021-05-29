package com.vektorel.config.swagger;

import static springfox.documentation.builders.RequestHandlerSelectors.any;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;
import static com.google.common.base.Predicates.not;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerCofig {
    // Buradaki tüm api handler lar spring in çalışmasını raporlayan restapiler
    // bu nedenle bu apilerin ayrıca swagger tarafından dinlenmesine ve görselleştirilmesine gerek yoktur.
    private static final String PATHS = "(/info|/health|/health/.*|/metrics|/error|/env|/env/.*)";

    @Bean
    public Docket api(){
        return new Docket(SWAGGER_2)
                    .select() // seçim yap
                    .apis(any()) // spring içinde tüm yayın yapan ve istekleri dinleren apileri seç
                    .paths(not(regex(PATHS))) // ancak, spring in kendi apilerini seçme
                    .build().apiInfo(apiInfo());
    }

    // Swagger Uİ için de arayüzün tanıtımı ve programcılar tarafından görülen
    // kısımlarına bilgilendirme yazıları yazmak önemli dir bu nedenle swagger info ekliyoruz
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("JAVA 56. Grup Swagger UI")
                .description("Bizim grubun yazmış olduğu apilerin dökümü")
                .contact(new Contact("Muhammet Ali HOCA","www.vektorelbilisim.com","info@vektorel.com"))
                .version("V.0.1.9")
                .build();
    }

}
