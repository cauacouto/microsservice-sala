package dev.couto.microsservice_sala.Repository;


import dev.couto.microsservice_sala.domin.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Integer> {
}
