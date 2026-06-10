package dev.couto.microsservice_sala.Mapper;

import dev.couto.microsservice_sala.Dto.SalaRequestDto;
import dev.couto.microsservice_sala.Dto.SalaResponseDto;
import dev.couto.microsservice_sala.domin.Sala;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaMapper {



  SalaResponseDto toDto(Sala entity);


  Sala toEntity(SalaRequestDto dto);


}
