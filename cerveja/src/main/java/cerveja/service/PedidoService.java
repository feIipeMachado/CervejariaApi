package cerveja.service;

import cerveja.integration.response.WeatherResponse;
import cerveja.integration.service.TemperaturaIntegrationService;
import cerveja.model.dto.converter.PedidoConverter;
import cerveja.model.dto.converter.UsuarioConverter;
import cerveja.model.dto.request.PedidoRequestDto;
import cerveja.model.dto.response.PedidoResponseDto;
import cerveja.model.entity.Cerveja;
import cerveja.model.entity.Pedido;
import cerveja.model.entity.Usuario;
import cerveja.repository.CervejaRepository;
import cerveja.repository.PedidoRepository;
import cerveja.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;
    private CervejaRepository cervejaRepository;
    private TemperaturaIntegrationService temperaturaService;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, CervejaRepository cervejaRepository, TemperaturaIntegrationService temperaturaService) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cervejaRepository = cervejaRepository;
        this.temperaturaService = temperaturaService;
    }


    public BigDecimal adicionar(Pedido pedido) {
        Usuario usuarioPedido = pedido.getUsuario();
        Optional<Usuario> verificarExistenciaUsuario = usuarioRepository.findById(usuarioPedido.getId());

        if (verificarExistenciaUsuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario " + usuarioPedido.getUsername() + " não existe");
        }

        LocalDate dataNascimentoUsuario = verificarExistenciaUsuario.get().getDataNascimento();

        if (!menorDeIdade(dataNascimentoUsuario)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario " + usuarioPedido.getUsername() + " é menor de idade");
        }

        List<Cerveja> listaCervejas = pedido.getCervejas();
        for (Cerveja cerveja: listaCervejas) {
            Optional<Cerveja> verificarExistenciaCerveja = cervejaRepository.findByNomeMarca(cerveja.getNomeMarca());
            if (verificarExistenciaCerveja.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cerveja pedida não está no nosso cardápio");
            }
        }


        return calcularValor(pedido);
    }

    public boolean menorDeIdade(LocalDate dataNascimento) {
        Period calculo = Period.between(LocalDate.now(), dataNascimento);
        return calculo.getYears() < 18;
    }

    public BigDecimal calcularValor(Pedido pedido) {
        List<Cerveja> listaCervejas = pedido.getCervejas();
        BigDecimal valorBase = BigDecimal.valueOf(0);
        BigDecimal desconto = BigDecimal.valueOf(0);

        for (Cerveja cerveja: listaCervejas) {
            valorBase = valorBase.add(cerveja.getValor());
        }

        WeatherResponse temperatura = temperaturaService.buscarTemperatura();

        if (temperatura.getCurrent().getTemp_c() <= 22) {
            System.out.println("Aplicando desconto");
            desconto = desconto.add(BigDecimal.valueOf(20));
        }

        if (listaCervejas.stream().count() > 10) {
            desconto = desconto.add(BigDecimal.valueOf(10));
        }

        BigDecimal descontoCalculado = valorBase.multiply(desconto).divide(BigDecimal.valueOf(100));
        BigDecimal valorCalculado = valorBase.subtract(descontoCalculado);

        return valorCalculado;
    }
}
