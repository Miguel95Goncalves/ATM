package controller;

import java.util.ArrayList;

import model.Pessoa;

public class GestaoPessoa {
	public void addPessoa(ArrayList<Pessoa> listaPessoa,String nome){
		listaPessoa.add(new Pessoa(nome));
	}
	
	public Pessoa listarPessoa(ArrayList<Pessoa> listaPessoa,int index){
		return listaPessoa.get(index);
	}
	
	public Pessoa procPessoa(ArrayList<Pessoa> listaPessoa,String nome){
		for(Pessoa p : listaPessoa)
		{
			if(p.getNome().equals(nome))return p;
		}
		return null;
	}
}
