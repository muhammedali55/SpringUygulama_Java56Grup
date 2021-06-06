package com.vektorel.mapper;

import com.vektorel.dto.request.SaveMusteriRequestDto;
import com.vektorel.respository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface MusteriMapper {

    @Mapping(source = "musteritel", target = "telefon")
    Musteri toMusteri(final SaveMusteriRequestDto musteriRequestDto);


}
