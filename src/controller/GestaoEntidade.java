package controller;

import java.util.ArrayList;

import model.Entidade;

public class GestaoEntidade {
	public void addPessoa(ArrayList<Entidade> listaPessoa,String nome){
		listaPessoa.add(new Entidade(nome));
	}
	
	public Entidade listarPessoa(ArrayList<Entidade> listaPessoa,int index){
		return listaPessoa.get(index);
	}
	
	public Entidade procPessoa(ArrayList<Entidade> listaPessoa,String nome){
		for(Entidade p : listaPessoa)
		{
			if(p.getNome().equals(nome))return p;
		}
		return null;
	}
}
