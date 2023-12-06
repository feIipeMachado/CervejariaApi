package cerveja.model.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data

public class UsuarioResponseDto {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;

}
