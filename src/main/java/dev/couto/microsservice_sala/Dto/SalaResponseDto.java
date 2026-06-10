package dev.couto.microsservice_sala.Dto;

import dev.couto.microsservice_sala.Enum.StatusSala;

public record SalaResponseDto(
        Integer id,
        String nomeSala,
        int capacidade,
        StatusSala status
) {
}
