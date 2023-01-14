package br.com.crud.backend.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "agenda")
    public class Agenda  {

        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank
        @Column(name="nome")
        private String nome;

//      @Email
        @NotBlank
        @Column(name="email")
        private String email;

        @NotBlank
        @Column(name="telefone")
//      @Pattern(regexp="(\\d{2})\\d{4}-\\d{4}$")
        private String telefone;

    }

