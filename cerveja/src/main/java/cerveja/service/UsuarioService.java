package cerveja.service;

import cerveja.model.Usuario;
import cerveja.model.dto.UsuarioRequestDto;
import cerveja.model.dto.converter.UsuarioConverter;
import cerveja.model.dto.response.UsuarioResponseDto;
import cerveja.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponseDto> buscarTodos() {
        List<Usuario> listaUsuarios = repository.findAll();
        return UsuarioConverter.converterListaEntidadePraDto(listaUsuarios);
    }

    public Usuario removerPorUsername(String username) {
        Optional<Usuario> usuarioParaRemover = repository.findByUsername(username);
        if (usuarioParaRemover.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario com username " + username + " não existe");
        } else {
            repository.delete(usuarioParaRemover.get());
            return usuarioParaRemover.get();
        }
    }

    public void adicionar(UsuarioRequestDto usuarioDto) {
        String nomeUsuarioAdicionado = usuarioDto.getNome();
        Optional<Usuario> usuarioExistente = repository.findByNome(nomeUsuarioAdicionado);

        if (!usuarioExistente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário " + nomeUsuarioAdicionado + " já existe");
        } else {
            Usuario usuarioEntidade = UsuarioConverter.converterDtoPraEntidade(usuarioDto);

            repository.save(usuarioEntidade);

        }
    }

    public Usuario alterarNomeSobrenomePorUsername(String username, Usuario usuario) {
        Usuario usuarioEncontrado = repository.findByUsername(username).get();
        usuarioEncontrado.setNome(usuario.getNome());
        usuarioEncontrado.setSobrenome(usuario.getSobrenome());
        repository.save(usuarioEncontrado);
        return usuarioEncontrado;
    }
}
