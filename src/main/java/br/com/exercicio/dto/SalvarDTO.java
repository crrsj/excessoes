package br.com.exercicio.dto;

import br.com.exercicio.entidade.Contato;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class SalvarDTO {
     private String nome;
     private List<Contato>contatos = new ArrayList<>();
}
