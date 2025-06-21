package br.com.exercicio.dto;

import br.com.exercicio.entidade.Contato;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class BuscarUsuario {
    private Long id;
    private String nome;
    private List<Contato>contatos;
}
