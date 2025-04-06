package model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.enums.BancoEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	private String nome;
	private String cpf;
	private String email;
	private String dataNascimento;
	private BancoEnum banco;
}