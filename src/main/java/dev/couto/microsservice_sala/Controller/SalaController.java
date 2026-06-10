package dev.couto.microsservice_sala.Controller;


import dev.couto.microsservice_sala.Dto.SalaRequestDto;
import dev.couto.microsservice_sala.Dto.SalaResponseDto;
import dev.couto.microsservice_sala.Service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<SalaResponseDto>> listarSalas( Pageable pageable){
        return ResponseEntity.ok(salaService.listarSalas(pageable));


    }
    @PatchMapping
    public ResponseEntity<SalaResponseDto> atualizarSala(@RequestBody SalaRequestDto request,@PathVariable Integer id){
        this.salaService.atualizarSala(request, id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(@PathVariable Integer id){
        this.salaService.inativarSala(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSala(Integer id){
        this.salaService.deletarSala(id);
        return ResponseEntity.noContent().build();    }

}
