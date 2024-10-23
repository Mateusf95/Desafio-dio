package one.digitalinovation.gof.controller;

import one.digitalinovation.gof.model.Cliente;
import one.digitalinovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    @Operation(summary = "Listar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saudação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saudação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> buscarPorId(Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Inserir usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário inserido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saudação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Cliente> atualizar(Long id, Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "DFeletar usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saudação bem-sucedida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity deletar(Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
}
}
