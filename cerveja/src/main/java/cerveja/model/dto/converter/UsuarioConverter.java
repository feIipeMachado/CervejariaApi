package cerveja.model.dto.converter;

import cerveja.model.Usuario;
import cerveja.model.dto.request.UsuarioRequestDto;
import cerveja.model.dto.response.UsuarioResponseDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConverter {

    public static Usuario converterDtoPraEntidade (UsuarioRequestDto dto) {
        Usuario usuarioEntidade = new Usuario();
        usuarioEntidade.setNome(dto.getNome());
        usuarioEntidade.setSobrenome(dto.getSobrenome());
        usuarioEntidade.setCpf(dto.getCpf());
        usuarioEntidade.setDataNascimento(dto.getDataNascimento());
        usuarioEntidade.setUsername(dto.getUsername());
        usuarioEntidade.setSenha(dto.getSenha());

        return usuarioEntidade;
    }

    public static UsuarioResponseDto converterEntidadePraDto (Usuario entidade) {
        UsuarioResponseDto usuarioResponse = new UsuarioResponseDto();
        usuarioResponse.setNome(entidade.getNome());
        usuarioResponse.setSobrenome(entidade.getSobrenome());
        usuarioResponse.setCpf(entidade.getCpf());
        usuarioResponse.setDataNascimento(entidade.getDataNascimento());

        return usuarioResponse;
    }

    public static List<UsuarioResponseDto> converterListaEntidadePraDto (List<Usuario> listaUsuarios) {
        List<UsuarioResponseDto> listaUsuariosResponseDTO = new ArrayList<>();
        for (Usuario u : listaUsuarios) {
            listaUsuariosResponseDTO.add(converterEntidadePraDto(u));
        }

        return listaUsuariosResponseDTO;
    }

}
