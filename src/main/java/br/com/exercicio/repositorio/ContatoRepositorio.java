package br.com.exercicio.repositorio;

import br.com.exercicio.entidade.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepositorio extends JpaRepository<Contato,Long> {
}
