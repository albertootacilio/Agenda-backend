package br.com.crud.backend.service;
import br.com.crud.backend.model.Agenda;
import br.com.crud.backend.repository.AgendaRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AgendaService {

    private AgendaRepository repository;

    public AgendaService(AgendaRepository repository) {this.repository = repository;}

    public List<Agenda> listaTodos(){
        return repository.findAll();
    }

    public Agenda buscarId(Long id) {return this.repository.findById(Agenda.class,id);}

    public Agenda salvar(Agenda agenda){return repository.save(agenda);}

    public void remover(Long id){this.repository.deleteById(id);}


}
