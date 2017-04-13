package model;

public class Carro {
	private String matricula;
	private int portas;
	private String combustivel;
	
	public Carro(String matricula, int portas, String combustivel) {
		super();
		this.matricula = matricula;
		this.portas = portas;
		this.combustivel = combustivel;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	
}
