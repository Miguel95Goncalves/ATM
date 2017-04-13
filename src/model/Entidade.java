package model;

import java.util.ArrayList;

public class Entidade {
	private String nome;
	private ArrayList<Carro> listaCarros = new ArrayList<Carro>();

	public Entidade(String nome) {
		super();
		this.nome = nome;
		listaCarros = new ArrayList<Carro>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}
	
}
