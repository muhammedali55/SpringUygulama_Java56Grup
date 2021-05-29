package com.vektorel.dto.request;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveMusteriRequestDto implements Serializable {
    String tckimlik;
    String ad;
    String soyad;
}
