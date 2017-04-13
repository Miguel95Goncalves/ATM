package view;

import java.util.Scanner;

import controller.GestaoContaBancaria;

import java.util.ArrayList;

import model.*;

public class Menu {
	
	ArrayList<ContaBancaria> listaConta = new ArrayList<ContaBancaria>();
	ArrayList<Entidade> listaPessoa = new ArrayList<Entidade>();
	Scanner read = (new Scanner(System.in));
	public static int conta=0;
	
	public void menu(){
		int opc,numero,numero2;
		float valor;
		
		do
		{
			if(conta==0)
			{
				System.out.println("1 - ContaBancaria\n2 - Cliente\n3 - Entrar\n0 - Sair\nInsira a opção: ");
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
					new MenuContaBancaria().menuContaBancaria(listaConta,listaPessoa);
					break;
					
				case 2:
					new MenuEntidade().menuPessoa(listaPessoa);
					break;
					
				case 3:
					System.out.println("Introduza o numero: ");
					numero = read.nextInt();
					
					if(new GestaoContaBancaria().procTitular(listaConta, numero)!=null)
					{
						conta=numero;
						System.out.println("Bem Vindo "+new GestaoContaBancaria().procTitular(listaConta, numero).getNome());
					}
					else System.out.println("A conta não existe!");
					break;
				}
			}
			else //Se entrar na Conta
			{
				System.out.println("1 - Levantar\n2 - Depositar\n3 - Transferir\n4 - Sair da Conta\n0 - Sair\nInsira a opção: ");
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
					
					System.out.println("Insira o valor a levantar: ");
					valor = read.nextFloat();
					
					new GestaoContaBancaria().levantar(listaConta, conta, valor);
					break;
					
				case 2:
					System.out.println("Insira o valor a depositar: ");
					valor = read.nextFloat();
					
					new GestaoContaBancaria().depositar(listaConta, conta, valor);
					break;
					
				case 3:
					System.out.println("Insira o numero de conta que quer transferir: ");
					numero2 = read.nextInt();
					
					System.out.println("Insira o valor a transferir: ");
					valor = read.nextFloat();
					
					new GestaoContaBancaria().transferir(listaConta, conta,numero2, valor);
					break;
					
				case 4:
					conta=0;
					break;
					
				}
			}
		}while(opc!=0);
	}
}
