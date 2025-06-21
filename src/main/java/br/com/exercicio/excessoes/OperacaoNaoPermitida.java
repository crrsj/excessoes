package br.com.exercicio.excessoes;

public class OperacaoNaoPermitida extends RuntimeException {
    public OperacaoNaoPermitida(String mensagem) {
        super(mensagem);
    }
    public OperacaoNaoPermitida(){
        super("Usuario ausente ou nulo !");
    }
}
