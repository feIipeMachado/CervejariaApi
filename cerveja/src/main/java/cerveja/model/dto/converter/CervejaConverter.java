package cerveja.model.dto.converter;

import cerveja.model.Cerveja;
import cerveja.model.Usuario;
import cerveja.model.dto.CervejaRequestDto;
import cerveja.model.dto.UsuarioRequestDto;
import cerveja.model.dto.response.CervejaResponseDto;
import jakarta.persistence.Converter;

@Converter
public class CervejaConverter {

    public static Cerveja converterDtoPraEntidade (CervejaRequestDto dto) {
        Cerveja cervejaEntidade = new Cerveja();
        cervejaEntidade.setMarca(dto.getMarca());
        cervejaEntidade.setValor(dto.getValor());

        return cervejaEntidade;
    }

    public static CervejaResponseDto converterEntidadePraDto (Cerveja entidade) {
        CervejaResponseDto cervejaResponse = new CervejaResponseDto();
        cervejaResponse.setMarca(entidade.getMarca());
        cervejaResponse.setValor(entidade.getValor());

        return cervejaResponse;
    }
}
