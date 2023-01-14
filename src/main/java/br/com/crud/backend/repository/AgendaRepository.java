package br.com.crud.backend.repository;
import br.com.crud.backend.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Long> {

    Agenda findById(Class<Agenda> agendaClass, Long id);
}

