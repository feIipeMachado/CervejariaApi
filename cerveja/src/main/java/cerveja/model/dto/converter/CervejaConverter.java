package cerveja.model.dto.converter;

import cerveja.model.Cerveja;
import cerveja.model.dto.request.CervejaRequestDto;
import cerveja.model.dto.response.CervejaResponseDto;

public class CervejaConverter {

    public static Cerveja converterDtoPraEntidade (CervejaRequestDto dto) {
        Cerveja cervejaEntidade = new Cerveja();
        cervejaEntidade.setTipoCerveja(dto.getTipoCerveja());

        return cervejaEntidade;
    }

    public static CervejaResponseDto converterEntidadePraDto (Cerveja entidade) {
        CervejaResponseDto cervejaResponse = new CervejaResponseDto();
        cervejaResponse.setTipoCerveja(entidade.getTipoCerveja().getNomeMarca());
        cervejaResponse.setValor(entidade.getTipoCerveja().getValor());

        return cervejaResponse;
    }
}
