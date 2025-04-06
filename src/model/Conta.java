package model;
import interfaces.IConta;
import model.enums.TipoConta;

public abstract class Conta implements IConta{


	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected TipoConta tipoConta;
	
	public Conta(Cliente cliente, TipoConta tipoConta) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++; 
		this.cliente = cliente;
		this.tipoConta = tipoConta;
				
	}
	
	
	public void sacar(double valor) {
		saldo -= valor;
	}

	
	public void depositar(double valor) {
		saldo += valor;
	}

	
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public int getAgencia() {
		return agencia;
	}

	
	public int getNumero() {
		return numero;
	}

	
	public double getSaldo() {
		return saldo;
	}
	
	
	
    public void renderJuros() {
        System.out.println("Essa conta não possui rendimento.");
    }
    
    @Override
    public String toString() {
        return String.format("Conta{titular='%s', agencia=%d, numero=%d, saldo=%.2f, tipoConta=%s, banco=%s}", 
                             this.cliente.getNome(), 
                             this.agencia, 
                             this.numero, 
                             this.saldo, 
                             this.tipoConta, 
                             this.cliente.getBanco().name()); 
    }

}


