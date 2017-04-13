package controller;

import java.util.ArrayList;

import model.Entidade;
import model.Carro;
import model.ContaBancaria;

public class GestaoCarro {
	public void addCarro(ArrayList<Entidade> listaEntidades,String nomeEntidade,String matricula,int portas,String combustivel){
		for(Entidade e : listaEntidades)
		{
			if(e.getNome().equals(nomeEntidade)) e.getListaCarros().add(new Carro(matricula,portas,combustivel));
		}
	}
	
	public ArrayList<Carro> listarCarros(ArrayList<Entidade> listaEntidades){
		ArrayList<Carro> todosCarros = new ArrayList<Carro>();
		
		for(Entidade e : listaEntidades)
		{
			for(int i=0;i<e.getListaCarros().size();i++)
			{
				todosCarros.add(e.getListaCarros().get(i));
			}
		}
		
		return todosCarros;
	}
	
	public ArrayList<Carro> listarCarros(ArrayList<Entidade> listaEntidades,String nomeEntidade){
		for(Entidade e : listaEntidades)
		{
			if(e.getNome()==nomeEntidade) return e.getListaCarros();
		}
		return null;
	}
	
	public void venderCarro(ArrayList<ContaBancaria> listaContas,ArrayList<Entidade> listaEntidades,String vendedor,String comprador,String matricula,float valor){
		for(Entidade v : listaEntidades)
		{
			if(v.getNome().equals(vendedor))
			{
				for(Entidade c : listaEntidades)
				{
					if(c.getNome().equals(comprador))
					{
						if(new GestaoContaBancaria().procTitular(listaContas, c).getSaldo()>=valor)
						{
							for(Carro car : v.getListaCarros())
							{
								if(car.getMatricula().equals(matricula))
								{
									c.getListaCarros().add(car);
									v.getListaCarros().remove(car);
									new GestaoContaBancaria().procTitular(listaContas, c).setSaldo(new GestaoContaBancaria().procTitular(listaContas, c).getSaldo()-valor);
									new GestaoContaBancaria().procTitular(listaContas, v).setSaldo(new GestaoContaBancaria().procTitular(listaContas, v).getSaldo()+valor);
									break;
								}
							}
						}
					}
				}
			}
		}
	}
}
