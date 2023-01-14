package br.com.crud.backend.controller;
import java.util.List;
import br.com.crud.backend.model.Agenda;
import br.com.crud.backend.service.AgendaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agenda/")
public class AgendaController {

   private AgendaService service;

    public AgendaController(AgendaService service) {this.service = service;}

    @GetMapping()
    public List<Agenda> listar() {
     return service.listaTodos();
    }

    @GetMapping( "{id}")
    public ResponseEntity<Agenda> obterId(@PathVariable Long id)  {
        Agenda agenda =  this.service.buscarId(id);

        if(agenda !=null){
            return ResponseEntity.ok(agenda);
        }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda criar(@RequestBody  Agenda agenda) {
        Agenda obj = this.service.salvar(agenda);
        return obj;
    }

    @PutMapping( "{id}")
    public ResponseEntity<Agenda> atualizar(@PathVariable Long id ,@RequestBody Agenda agenda){
        Agenda obj = this.service.buscarId(id);

        if (obj != null){
            BeanUtils.copyProperties(agenda,obj,"id");
            this.service.salvar(obj);
            return ResponseEntity.ok(obj);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping( "{id}")
    public ResponseEntity<Agenda> deletar(@PathVariable Long id) {
        Agenda obj = this.service.buscarId(id);
        if (obj != null) {
            this.service.remover(obj.getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}