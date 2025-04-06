package app;

import java.util.Scanner;
import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.enums.BancoEnum;
import model.enums.TipoConta;
import validador.Validador;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Escolha o Banco que deseja criar a conta: ");
		System.out.printf("1 - ITAÚ\n2 - BRADESCO\n3 - SANTANDER\n4 - NUBANK\n5 - INTER\n");
		
		int escolha;
		escolha = sc.nextInt();
		sc.nextLine();
		
		Validador.validadorEscolha(sc, escolha);
		
		BancoEnum bancoEscolhido = Banco.escolherBanco(escolha);
		
		
		
		Banco banco = new Banco(bancoEscolhido);
		

		cadastrarClientes( sc, banco, bancoEscolhido);
		
		banco.exibirClientes();
		banco.exibirContas();
		
		
        System.out.println("Digite o número da agência que você deseja buscar:");
        int numero = sc.nextInt();
		
		banco.buscarContaPorNumero(numero, banco.getContas());
		
	}
	
	public static void cadastrarClientes(Scanner sc, Banco banco, BancoEnum bancoEscolhido) {
		System.out.println("Quantos clientes deseja cadastrar?");
		int qtdClientes = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < qtdClientes; i++) {
			System.out.println("Digite seu nome:");
			String nome = sc.nextLine();
						
			String cpf;
			
			do {
			    System.out.println("Digite somente os números do seu CPF:");
			    cpf = sc.next();
			    sc.nextLine();

			    if (!Validador.validarCPF(cpf)) {
			        System.out.println("CPF inválido! Tente novamente.");
			        continue;
			    }

			    if (Validador.validarCPFIgual(cpf, banco.getClientes())) {
			        System.out.println("CPF já cadastrado! Digite outro CPF.");
			        continue;
			    }

			    break; 

			} while (true);
			
			System.out.println("Digite seu email:");
			String email;
			
			do {
				email = sc.next();
				sc.nextLine();
				
				if(!Validador.validarEmail(email)) {
					System.out.println("Digite um email válido!");
				}
			}while(!Validador.validarEmail(email));
			
			System.out.println("Digite sua data de nascimento:");
			String dataNascimento = sc.next();
			sc.nextLine();
			
			Cliente clientes = new Cliente(nome, cpf, email, dataNascimento, bancoEscolhido);
			
			banco.adicionarCliente(clientes);
			
			System.out.println("Escolha o tipo de conta que deseja criar: ");
	        System.out.printf("1 - CORRENTE\n2 - POUPANÇA\n");

	        int contaEscolhida= sc.nextInt();
	        sc.nextLine();

	        Validador.validadorContaEscolhida(sc, contaEscolhida);

	        TipoConta tipoDaConta = contaEscolhida == 1 ? TipoConta.CORRENTE : TipoConta.POUPANÇA;

	        
	        Conta conta;
	        if (tipoDaConta == TipoConta.CORRENTE) {
	            conta = new ContaCorrente(clientes); 
	        } else if (tipoDaConta == TipoConta.POUPANÇA) {
	            conta = new ContaPoupanca(clientes);  
	        } else {
	            throw new IllegalArgumentException("Tipo de conta desconhecido.");
	        }
	        
	        

	        banco.adicionarConta(conta);
	        conta.imprimirExtrato();
	    }
	}
}
	