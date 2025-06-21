package br.com.exercicio.dto;

import br.com.exercicio.entidade.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalvarContatoDTO {
    private Long id;
    private String fone;
    private String email;
    private Usuario usuario;

}
