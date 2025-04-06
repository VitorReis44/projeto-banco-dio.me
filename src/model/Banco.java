package model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import model.enums.BancoEnum;
import model.enums.TipoConta;

@Data
public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private BancoEnum nome;
    private TipoConta modeloConta;
    
    
    
    public Banco(BancoEnum nome) {
    	this.nome = nome;
    }
    
    public void adicionarConta(Conta conta) {
    	contas.add(conta);
    }
    
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void exibirClientes() {
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public void exibirContas() {
    	for(Conta cont : contas) {
    		System.out.println(cont);
    	}
    }
    public void buscarContaPorNumero(int numero, List<Conta> contas) {
        boolean contaEncontrada = false;  
        
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {  
                System.out.println("Conta encontrada aqui estão as informações da conta: ");
                conta.imprimirExtrato();
                contaEncontrada = true;  
                break;
            }
        }
        
        if (!contaEncontrada) {
            System.out.println("Conta não encontrada!");
        }
    }

    public static BancoEnum escolherBanco(int escolha) {
    	return switch(escolha) {
		case 1 ->  BancoEnum.ITAÚ;
		case 2 ->  BancoEnum.BRADESCO;
		case 3 -> BancoEnum.SANTANDER;
		case 4 ->BancoEnum.NUBANK;
		case 5 -> BancoEnum.INTER;
		default -> {
			System.out.println("Opção inválida. Banco padrão selecionado: ITAÚ");
            yield BancoEnum.ITAÚ;
		}
    	};
}
}