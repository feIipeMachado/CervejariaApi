package cerveja.service;

import cerveja.model.TipoCerveja;
import cerveja.repository.CervejaRepository;
import cerveja.repository.TipoCervejaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CervejaService {

    private CervejaRepository cervejaRepository;
    private TipoCervejaRepository tipoCervejaRepository;

    public CervejaService (CervejaRepository cervejaRepository, TipoCervejaRepository tipoCervejaRepository) {
        this.cervejaRepository = cervejaRepository;
        this.tipoCervejaRepository = tipoCervejaRepository;
    }

    public List<TipoCerveja> buscarTodosTiposDeCerveja() {
        List<TipoCerveja> listaTiposDeCerveja = tipoCervejaRepository.findAll();
        return listaTiposDeCerveja;
    }

    public void adicionarTipoCerveja(TipoCerveja tipoCerveja) {
        String tipoCervejaAdicionado = tipoCerveja.getNomeMarca();
        Optional<TipoCerveja> tipoCervejaExistente = tipoCervejaRepository.findByNomeMarca(tipoCervejaAdicionado);

        if (!tipoCervejaExistente.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca " + tipoCervejaAdicionado + " já está registrada");
        } else {
            tipoCervejaRepository.save(tipoCerveja);
        }
    }

    public TipoCerveja removerTipoCervejaPorNomeMarca(String nomeMarca) {
        Optional<TipoCerveja> tipoCervejaParaRemoverOptional = tipoCervejaRepository.findByNomeMarca(nomeMarca);
        if (tipoCervejaParaRemoverOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Marca" + nomeMarca + " não existe");
        } else {
            TipoCerveja tipoCervejaParaRemover = tipoCervejaParaRemoverOptional.get();
            tipoCervejaRepository.delete(tipoCervejaParaRemover);
            return (tipoCervejaParaRemover);
        }
    }

    public TipoCerveja alterarValor(String nomeMarca, BigDecimal valor) {
        TipoCerveja tipoCervejaEncontrado = tipoCervejaRepository.findByNomeMarca(nomeMarca).get();
        tipoCervejaEncontrado.setValor(valor);
        tipoCervejaRepository.save(tipoCervejaEncontrado);
        return tipoCervejaEncontrado;
    }

}
