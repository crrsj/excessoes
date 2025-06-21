package br.com.exercicio.servico;

import br.com.exercicio.dto.SalvarContatoDTO;
import br.com.exercicio.entidade.Contato;
import br.com.exercicio.entidade.Usuario;
import br.com.exercicio.excessoes.OperacaoNaoPermitida;
import br.com.exercicio.repositorio.ContatoRepositorio;
import br.com.exercicio.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContatoServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final ModelMapper modelMapper;
    private final ContatoRepositorio contatoRepositorio;

    public Contato salvarContato(Long usuarioId,SalvarContatoDTO dto){
        var  usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new OperacaoNaoPermitida("usuário ausente ou nulo !"));
        var contato = modelMapper.map(dto,Contato.class);
        contato.setUsuario(usuario);
        return contatoRepositorio.save(contato);
    }
}
