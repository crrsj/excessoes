package br.com.exercicio.servico;

import br.com.exercicio.dto.BuscarUsuarios;
import br.com.exercicio.dto.SalvarDTO;
import br.com.exercicio.excessoes.UsuarioNaoEncontrado;
import br.com.exercicio.repositorio.UsuarioRepositorio;
import br.com.exercicio.entidade.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServico {

    private final UsuarioRepositorio usuarioRepositorio;
    private final ModelMapper modelMapper;






    public Usuario salvarUsuario(SalvarDTO salvarDTO){
        return usuarioRepositorio.save(modelMapper.map(salvarDTO, Usuario.class));
    }








    public List<BuscarUsuarios> buscarTodos(){
        return usuarioRepositorio.findAll()
                .stream()
                .map(listar -> modelMapper
                .map(listar, BuscarUsuarios.class))
                .toList();

    }







    public Usuario buscarPorId(Long id){
        return usuarioRepositorio
                .findById(id)
                .orElseThrow(()-> new UsuarioNaoEncontrado("Usuário não encontrado !"));

    }
}
