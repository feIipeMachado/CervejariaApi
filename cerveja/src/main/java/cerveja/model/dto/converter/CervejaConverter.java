package cerveja.model.dto.converter;

import cerveja.model.dto.request.CervejaRequestDto;
import cerveja.model.dto.request.UsuarioRequestDto;
import cerveja.model.dto.response.CervejaResponseDto;
import cerveja.model.dto.response.UsuarioResponseDto;
import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CervejaConverter {

    public static Cerveja converterDtoPraEntidade (CervejaRequestDto dto) {
        Cerveja cervejaEntidade = new Cerveja();
        cervejaEntidade.setNomeMarca(dto.getNomeMarca());
        cervejaEntidade.setValor(dto.getValor());

        return cervejaEntidade;
    }

    public static CervejaResponseDto converterEntidadePraDto (Cerveja entidade) {
        CervejaResponseDto cervejaResponse = new CervejaResponseDto();
        cervejaResponse.setNomeMarca(entidade.getNomeMarca());
        cervejaResponse.setValor(entidade.getValor());

        return cervejaResponse;
    }

    public static List<CervejaResponseDto> converterListaEntidadePraDto (List<Cerveja> listaCervejas) {
        List<CervejaResponseDto> listaCervejasResponseDTO = new ArrayList<>();
        for (Cerveja u : listaCervejas) {
            listaCervejasResponseDTO.add(converterEntidadePraDto(u));
        }

        return listaCervejasResponseDTO;
    }
}
