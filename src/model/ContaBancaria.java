package model;

public class ContaBancaria {
	private int numero;
	private float saldo;
	private Pessoa titular;
	
	public ContaBancaria(int numero, float saldo, Pessoa titular) {
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
	public Pessoa getTitular() {
		return titular;
	}
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}
	
}
