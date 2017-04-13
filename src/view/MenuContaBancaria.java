package view;

import java.util.ArrayList;

import controller.GestaoContaBancaria;
import controller.GestaoEntidade;

import java.util.Scanner;

import model.ContaBancaria;
import model.Entidade;

public class MenuContaBancaria {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuContaBancaria(ArrayList<ContaBancaria> listaConta,ArrayList<Entidade> listaPessoa){
		int opc,numero;
		float saldo;
		String nome;
		
		do
		{
			System.out.println("1 - Criar Conta Bancária\n2 - Listar Contas Bancárias\n0 - Voltar\nInsira a opção: ");
			try{
				opc = read.nextInt();
			}catch(Exception e){
				System.out.println("Opção Inválida!");
				opc = 666;
				read.nextLine();
			}
			
			switch(opc)
			{
			case 1:
				read.nextLine();
				
				if(listaPessoa.size()!=0)
				{
					do
					{
						System.out.println("Insira o nome do titular: ");
						nome = read.nextLine();
					}while(new GestaoEntidade().procPessoa(listaPessoa, nome)==null);
						
					System.out.println("Insira o saldo: ");
					saldo = read.nextFloat();
					
					System.out.println("Insira o numero de conta: ");
					numero = read.nextInt();
					
					new GestaoContaBancaria().addConta(listaConta, saldo, numero, new GestaoEntidade().procPessoa(listaPessoa, nome));
				}
				else System.out.println("Insira primeiro clientes!");
				break;
				
			case 2:
				for(int i=0;i<listaConta.size();i++)
				{
					System.out.println("Nome do Titular: "+new GestaoContaBancaria().listarConta(listaConta, i).getTitular().getNome());
					System.out.println("Número de Conta: "+new GestaoContaBancaria().listarConta(listaConta, i).getNumero());
					System.out.println("Saldo: "+new GestaoContaBancaria().listarConta(listaConta, i).getSaldo());
				}
				break;
			}
			
		}while(opc!=0);
		
	}
}
