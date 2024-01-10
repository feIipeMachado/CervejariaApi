package cerveja.controller.v1;

import cerveja.model.Usuario;
import cerveja.model.dto.request.UsuarioRequestDto;
import cerveja.model.dto.response.UsuarioResponseDto;
import cerveja.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    private UsuarioService service;
    public UsuarioController (UsuarioService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Void> adicionarUsuario(@RequestBody UsuarioRequestDto usuario) {
        service.adicionar(usuario);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> buscarTodosOsUsuarios() {
        return ResponseEntity.ok(this.service.buscarTodos());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UsuarioResponseDto> removerUsuarioPorUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(service.removerPorUsername(username));
    }

    @PutMapping("/username/{username}")
    public ResponseEntity<Void> alterarNomeSobrenomeDoUsuarioPorUsername(@PathVariable("username") String username,
                                                                         @RequestBody Usuario usuario) {
        Usuario usuarioAlterado = service.alterarNomeSobrenomePorUsername(username, usuario);
        return ResponseEntity.noContent().build();
    }


}
