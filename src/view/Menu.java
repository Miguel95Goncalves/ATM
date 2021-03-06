package view;

import java.util.Scanner;

import controller.GestaoCarro;
import controller.GestaoContaBancaria;
import controller.GestaoEntidade;

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
		ArrayList<Carro> listaCarros = new ArrayList<Carro>();
		
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
				System.out.println("1 - Levantar\n2 - Depositar\n3 - Transferir\n4 - Listar Carros\n5 - Vender Carro\n6 - Comprar Carro\n7 - Sair da Conta\n0 - Sair\nInsira a op��o: ");
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
					listaCarros = new GestaoCarro().listarCarros(listaPessoa, nome);
					
					for(Carro c : listaCarros)
					{
						System.out.println("Matricula: "+c.getMatricula()+"\nPortas: "+c.getPortas()+"\nCombustivel: "+c.getCombustivel());
					}
					break;
					
				case 5:
					listaCarros = new GestaoCarro().listarCarros(listaPessoa, nome);
					if(listaCarros.size()!=0)
					{
						read.nextLine();
					
						System.out.println("Insira o nome da entidade que ir� comprar o ve�culo: ");
						String nome2 = read.nextLine();
						
						if(new GestaoEntidade().procPessoa(listaPessoa, nome2)!=null)
						{
							System.out.println("Insira a matricula do carro que quer vender: ");
							String matricula = read.nextLine();
							
							System.out.println("Insira o valor: ");
							valor = read.nextFloat();
							
							new GestaoCarro().venderCarro(listaConta, listaPessoa, nome, nome2, matricula, valor);
						}
						else System.out.println("Entidade Inexistente!");
					}else System.out.println("N�o possui veiculos para vender!");
					break;
					
				case 6:
					listaCarros = new GestaoCarro().listarCarros(listaPessoa, nome);
					if(listaCarros.size()!=0)
					{
						read.nextLine();
					
						System.out.println("Insira o nome da entidade que ir� vender o ve�culo: ");
						String nome2 = read.nextLine();
						
						if(new GestaoEntidade().procPessoa(listaPessoa, nome2)!=null)
						{
							System.out.println("Insira a matricula do carro que quer vender: ");
							String matricula = read.nextLine();
							
							System.out.println("Insira o valor: ");
							valor = read.nextFloat();
							
							new GestaoCarro().venderCarro(listaConta, listaPessoa, nome2, nome, matricula, valor);
						}
						else System.out.println("Entidade Inexistente!");
					}else System.out.println("N�o possui veiculos para vender!");
					break;
					
				case 7:
					conta=0;
					break;
					
				}
			}
		}while(opc!=0);
	}
}
