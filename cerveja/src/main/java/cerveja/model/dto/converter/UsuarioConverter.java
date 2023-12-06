package cerveja.model.dto.converter;

import cerveja.model.Usuario;
import cerveja.model.dto.UsuarioRequestDto;
import cerveja.model.dto.response.UsuarioResponseDto;

public class UsuarioConverter {

    public static Usuario converterDtoPraEntidade (UsuarioRequestDto dto) {
        Usuario usuarioEntidade = new Usuario();
        usuarioEntidade.setNome(dto.getNome());
        usuarioEntidade.setSobrenome(dto.getSobrenome());
        usuarioEntidade.setCpf(dto.getCpf());
        usuarioEntidade.setDataNascimento(dto.getDataNascimento());

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
}
