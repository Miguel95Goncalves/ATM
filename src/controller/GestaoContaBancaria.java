package controller;

import java.util.ArrayList;

import model.ContaBancaria;
import model.Pessoa;

public class GestaoContaBancaria {
	public void addConta(ArrayList<ContaBancaria> listaConta,float saldo,int numero,Pessoa titular){ //Adicionar Conta
		listaConta.add(new ContaBancaria(numero,saldo,titular));
	}
	
	public ContaBancaria listarConta(ArrayList<ContaBancaria> listaConta,int index){
		return listaConta.get(index);
	}
	
	public Pessoa procTitular(ArrayList<ContaBancaria> listaConta,int numero){
		for(ContaBancaria cb : listaConta)
		{
			if(cb.getNumero()==numero) return cb.getTitular();
		}
		return null;
	}
	
	public void levantar(ArrayList<ContaBancaria> listaConta,int numero,float valor){
		for(ContaBancaria cb : listaConta)
		{
			if(cb.getNumero()==numero)
			{
				if(cb.getSaldo()>=valor)
				{
					cb.setSaldo(cb.getSaldo()-valor);
				}
			}
		}
	}
	
	public void depositar(ArrayList<ContaBancaria> listaConta,int numero,float valor){
		for(ContaBancaria cb : listaConta)
		{
			if(cb.getNumero()==numero) cb.setSaldo(cb.getSaldo()+valor);
		}
	}
	
	public void transferir(ArrayList<ContaBancaria> listaConta,int numero,int numero2,float valor){
		boolean t=false;
		
		for(ContaBancaria cb : listaConta)
		{
			if(cb.getNumero()==numero)
			{
				if(cb.getSaldo()>=valor)
				{
					cb.setSaldo(cb.getSaldo()-valor);
					
					for(ContaBancaria cb2 : listaConta)
					{
						if(cb2.getNumero()==numero2)
						{
							cb2.setSaldo(cb2.getSaldo()+valor);
							t=true;
						}
					}
				}
				if(t==false) cb.setSaldo(cb.getSaldo()+valor);
			}
		}
	}
}
