package controller;

import java.util.ArrayList;

import model.ContaBancaria;
import model.Pessoa;

public class GestaoContaBancaria {
	public void addConta(ArrayList<ContaBancaria> listaConta,float saldo,int numero,Pessoa titular){ //Adicionar Conta
		listaConta.add(new ContaBancaria(numero,saldo,titular));
	}
	
	public ContaBancaria listarConta(ArrayList<ContaBancaria> listaConta){
		for(int i=0;i<listaConta.size();i++)
		{
			
		}
	}
}
