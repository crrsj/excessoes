package br.com.exercicio.tratamento;

import br.com.exercicio.excessoes.OperacaoNaoPermitida;
import br.com.exercicio.excessoes.UsuarioNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratandoExcessoes {

    @ExceptionHandler(UsuarioNaoEncontrado.class)
    public ResponseEntity<Mensagem>usuarioNaoEncontrado(){
       var msg = new Mensagem(HttpStatus.BAD_REQUEST,"Usuário não encontrado !");
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(OperacaoNaoPermitida.class)
    public ResponseEntity<Mensagem>operacaoNaoPermitida(){
        var msg = new Mensagem(HttpStatus.BAD_REQUEST,"Usuário nulo ou ausente !");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }
}
