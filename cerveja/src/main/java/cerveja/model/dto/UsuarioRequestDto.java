package cerveja.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDto {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String cpf;
    private String username;
    private String senha;



}
