package br.com.exercicio.controle;

import br.com.exercicio.dto.BuscarUsuario;
import br.com.exercicio.dto.BuscarUsuarios;
import br.com.exercicio.dto.SalvarDTO;
import br.com.exercicio.servico.UsuarioServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioControle {

    private final UsuarioServico usuarioServico;
    private final ModelMapper modelMapper;

    @PostMapping
    @Operation(summary = "Endpoint responsável por cadastrar usuários.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<SalvarDTO>salvarUsuario(@RequestBody SalvarDTO salvarDTO){
        var salvar = usuarioServico.salvarUsuario(salvarDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(salvar, SalvarDTO.class));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável por buscar usuários.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<BuscarUsuarios>>buscarTodos(){
        var listar = usuarioServico.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listar);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsável por buscar usuário pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<BuscarUsuario>buscarPorId(@PathVariable Long id){
        var buscar = usuarioServico.buscarPorId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modelMapper.map(buscar,BuscarUsuario.class));
    }

}
