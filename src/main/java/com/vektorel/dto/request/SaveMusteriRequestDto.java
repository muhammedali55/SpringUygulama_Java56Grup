package com.vektorel.dto.request;

import lombok.*;

import javax.validation.constraints.Max;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveMusteriRequestDto implements Serializable {

    String tckimlik;
    String ad;
    String soyad;
    @Max(value = 140, message = "Kişi yaşını 140 tan fazla giremezsiniz")
    Integer yas;
    String musteritel;
}
