package br.com.exercicio.controle;

import br.com.exercicio.dto.SalvarContatoDTO;
import br.com.exercicio.servico.ContatoServico;
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

@RestController
@RequestMapping("api/contatos")
@RequiredArgsConstructor
public class ContatoControle {

    private final ContatoServico contatoServico;
    private final ModelMapper modelMapper;

    @PostMapping("/{usuarioId}")
    @Operation(summary = "Endpoint responsável por salvar contatos.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<SalvarContatoDTO>salvarContato(@PathVariable Long usuarioId,
            @RequestBody SalvarContatoDTO dto){
        var salvar = contatoServico.salvarContato(usuarioId,dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(modelMapper.map(salvar, SalvarContatoDTO.class));
    }
}
