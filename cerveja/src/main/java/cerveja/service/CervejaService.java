package cerveja.service;

import cerveja.model.dto.converter.CervejaConverter;
import cerveja.model.dto.request.CervejaRequestDto;
import cerveja.model.dto.response.CervejaResponseDto;
import cerveja.model.entity.Cerveja;
import cerveja.repository.CervejaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CervejaService {

    private CervejaRepository repository;

    public CervejaService (CervejaRepository repository) {
        this.repository = repository;
    }

    public List<CervejaResponseDto> buscarTodasAsCervejas() {
        List<Cerveja> listaCervejasEntity = repository.findAll();
        return CervejaConverter.converterListaEntidadePraDto(listaCervejasEntity);
    }

    public void adicionar(CervejaRequestDto cervejaDto) {
        String nomeMarcaCervejaAdicionada = cervejaDto.getNomeMarca();
        Optional<Cerveja> cervejaExistente = repository.findByNomeMarca(nomeMarcaCervejaAdicionada);

        if (!cervejaExistente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca " + cervejaExistente + " já está registrada");
        } else {
            Cerveja cervejaEntidade = CervejaConverter.converterDtoPraEntidade(cervejaDto);
            repository.save(cervejaEntidade);
        }
    }


    public CervejaResponseDto removerCervejaPorNomeMarca(String nomeMarca) {
        Optional<Cerveja> cervejaParaRemoverOptional = repository.findByNomeMarca(nomeMarca);
        if (cervejaParaRemoverOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca" + nomeMarca + " não existe");
        } else {
            Cerveja cervejaParaRemovereEntity = cervejaParaRemoverOptional.get();
            repository.delete(cervejaParaRemovereEntity);
            return CervejaConverter.converterEntidadePraDto(cervejaParaRemovereEntity);
        }
    }

    public Cerveja alterarValor(String nomeMarca, BigDecimal valor) {
        Cerveja cervejaEncontrada = repository.findByNomeMarca(nomeMarca).get();
        cervejaEncontrada.setValor(valor);
        repository.save(cervejaEncontrada);
        return cervejaEncontrada;
    }

}
