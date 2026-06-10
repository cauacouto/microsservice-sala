package dev.couto.microsservice_sala.Service;


import dev.couto.microsservice_sala.Dto.SalaRequestDto;
import dev.couto.microsservice_sala.Dto.SalaResponseDto;
import dev.couto.microsservice_sala.Enum.StatusSala;
import dev.couto.microsservice_sala.Mapper.SalaMapper;
import dev.couto.microsservice_sala.Repository.SalaRepository;
import dev.couto.microsservice_sala.domin.Sala;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;
    private  final SalaMapper salaMapper;

    public SalaResponseDto criarSala(SalaRequestDto dto){
        Sala sala = salaMapper.toEntity(dto);
        sala.setNomeSala(dto.nomeSala());
        sala.setStatusSala(StatusSala.ATIVA);
        sala.setAtiva(true);
        sala.setCapacidade(dto.capacidade());
        if (sala.getCapacidade() <= 0){
            throw new IllegalArgumentException("sala não pode possuir capacidade menor ou igual a zero.");
        }
            var salvar = salaRepository.save(sala);
        return salaMapper.toDto(salvar);
    }


    public void inativarSala(Integer id){
        Sala sala = salaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("sala não encontrada"));
        sala.setAtiva(false);
        salaRepository.save(sala);
    }

}
