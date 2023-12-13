package br.edu.ifsul.cstsi.lpoo_objetivo_5.participantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    @Query(value = "SELECT p FROM Participante p where p.nome like ?1")
    List<Participante> findByNome(String nome);
    List<Participante> findByLogin(String login);

    @Query(value = "SELECT p FROM Participante p where p.id = ?1")
    Optional<Participante> findById(Long id);
}

