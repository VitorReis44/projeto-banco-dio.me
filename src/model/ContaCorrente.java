package model;

import model.enums.TipoConta;

public class ContaCorrente extends Conta {
	
	private double taxa = 0.50;
	
	public ContaCorrente(Cliente cliente) {
		super(cliente, TipoConta.CORRENTE);
		
	}
	
	@Override
	public void sacar(double valor) {
	    if (saldo >= valor + taxa) {
	        System.out.println("Aplicando taxa: " + taxa);
	        System.out.println("Fazendo saque: " + valor);
	        saldo -= (valor + taxa);
	    } else {
	        System.out.println("Saldo insuficiente!");
	    }
	}
	
  @Override
    public void imprimirExtrato() {
        System.out.println("IMPRIMINDO EXTRATO CONTA POUPANÇA...");
        System.out.println(this.toString());
    }
}
