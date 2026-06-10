package dev.couto.microsservice_sala.domin;


import dev.couto.microsservice_sala.Enum.StatusSala;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sala")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nomeSala;
    private int capacidade;
    private boolean ativa;
    @Enumerated(EnumType.STRING)
    private StatusSala statusSala;



}

