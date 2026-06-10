package dev.couto.microsservice_sala.Controller;


import dev.couto.microsservice_sala.Dto.SalaRequestDto;
import dev.couto.microsservice_sala.Dto.SalaResponseDto;
import dev.couto.microsservice_sala.Service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sala")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;


    @PostMapping
    public ResponseEntity<SalaResponseDto> criarSala (@RequestBody SalaRequestDto dto){
        var request = salaService.criarSala(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
