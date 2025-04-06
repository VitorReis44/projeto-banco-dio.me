package model;

import model.enums.TipoConta;

public class ContaPoupanca extends Conta{
	
	private double taxaMes = 0.5;

	public ContaPoupanca(Cliente cliente) {
		super(cliente, TipoConta.POUPANÇA);
	}
	
	public void mostrarRendimentos(double saldoAntes, double juros, double saldoDepois) {
	    System.out.printf("Saldo anterior: R$ %.2f\n", saldoAntes);
	    System.out.printf("Juros aplicados: R$ %.2f\n", juros);
	    System.out.printf("Novo saldo: R$ %.2f\n", saldoDepois);
	}

	@Override
	public void renderJuros() {
	    double saldoAntes = saldo;
	    double juros = saldo * taxaMes;
	    double novoSaldo = saldoAntes + juros;

	    saldo = novoSaldo;

	    mostrarRendimentos(saldoAntes, juros, novoSaldo);
	}

	
	  @Override
	    public void imprimirExtrato() {
	        System.out.println("IMPRIMINDO EXTRATO CONTA POUPANÇA...");
	        System.out.println(this.toString());  
	    }
	}