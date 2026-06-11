package dev.couto.microsservice_sala.Mapper;

import dev.couto.microsservice_sala.Dto.SalaRequestDto;
import dev.couto.microsservice_sala.Dto.SalaResponseDto;
import dev.couto.microsservice_sala.domin.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalaMapper {



  @Mapping(target = "status",source = "statusSala")
  SalaResponseDto toDto(Sala entity);


  Sala toEntity(SalaRequestDto dto);


}
