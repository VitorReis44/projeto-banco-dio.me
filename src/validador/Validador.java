package validador;

import java.util.Scanner;
import java.util.List;
import model.Cliente;

public class Validador {

	Scanner sc = new Scanner(System.in);
	
    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    public static boolean validarEmail(String email) {
        return email != null && email.contains("@");
    }
    
    public static boolean validarCPFIgual(String cpf, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false; 
    }
    
    public static boolean validadorEscolha(Scanner sc, int escolha) {
        while (escolha < 1 || escolha > 5) {
            System.out.println("Opção inválida! Escolha novamente entre 1 e 5.");
            escolha = sc.nextInt(); 
            sc.nextLine();
        }
        return true;
    }

    // 
    public static boolean validadorContaEscolhida(Scanner sc, int contaEscolhida) {
        while (contaEscolhida < 1 || contaEscolhida > 2) {
            System.out.println("Opção inválida! Escolha novamente entre 1 e 2.");
            contaEscolhida = sc.nextInt(); // Recebe novamente a entrada
            sc.nextLine();
        }
        return true; 
    }
}