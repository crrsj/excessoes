package br.com.exercicio.tratamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensagem {
    HttpStatus status;
    String mensagem;
}
