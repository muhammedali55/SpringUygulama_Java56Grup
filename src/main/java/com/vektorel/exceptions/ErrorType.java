package com.vektorel.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

// ENUM -> her bir değerin karşılık geldiği bilgi öbeği
// kullanıcılar istekte bulunacak çoktan seçmeli olsun.
// 1,2,3,4,........100  seçim -> 56,43,66,34,78,35
// yüzme:1, futbol:2, kitapokuma:3........, okçuluk:100
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(2000,"Internal Server Error",INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001,"Invalid Parameter Error",BAD_REQUEST),
    JDBC_REQUEST_ERROR(2002,"DB Connection Error",BAD_REQUEST),
    GLOBAL_EXCEPTOIN_ERROR(2999,"Beklenmeyen bir şey oldu adamımı...",BAD_REQUEST);



    private int code;
    private String message;
    private HttpStatus httpStatus; // Kullanıcılar tarafıdan yapılan istelerin sonucunda oluşan durum bilgileri.
}
