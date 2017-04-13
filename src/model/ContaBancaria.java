package model;

public class ContaBancaria {
	private int numero;
	private float saldo;
	private Entidade titular;
	
	public ContaBancaria(int numero, float saldo, Entidade titular) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Entidade getTitular() {
		return titular;
	}
	public void setTitular(Entidade titular) {
		this.titular = titular;
	}
	
}
