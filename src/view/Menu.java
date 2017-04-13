package view;

import java.util.Scanner;

import controller.GestaoCarro;
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
		String nome = null;
		
		do
		{
			if(conta==0)
			{
				System.out.println("1 - ContaBancaria\n2 - Cliente\n3 - Entrar\n4 - Listar Carros\n0 - Sair\nInsira a op��o: ");
				try{
					opc = read.nextInt();
				}catch(Exception e){
					System.out.println("Op��o Inv�lida!");
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
						nome=new GestaoContaBancaria().procTitular(listaConta, numero).getNome();
						System.out.println("Bem Vindo "+nome);
					}
					else System.out.println("A conta n�o existe!");
					break;
				}
			}
			else //Se entrar na Conta
			{
				System.out.println("1 - Levantar\n2 - Depositar\n3 - Transferir\n4 - Listar Carros\n5 - Sair da Conta\n0 - Sair\nInsira a op��o: ");
				try{
					opc = read.nextInt();
				}catch(Exception e){
					System.out.println("Op��o Inv�lida!");
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
					ArrayList<Carro> listaCarros = new GestaoCarro().listarCarros(listaPessoa, nome);
					
					for(Carro c : listaCarros)
					{
						System.out.println("Matricula: "+c.getMatricula()+"\nPortas: "+c.getPortas()+"\nCombustivel: "+c.getCombustivel());
					}
					break;
					
				case 5:
					conta=0;
					break;
					
				}
			}
		}while(opc!=0);
	}
}
