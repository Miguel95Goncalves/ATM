package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GestaoCarro;
import controller.GestaoEntidade;
import model.Entidade;

public class MenuEntidade {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuPessoa(ArrayList<Entidade> listaPessoa){
		int opc;
		String nome;
		
		do
		{
			System.out.println("1 - Adicionar Entidade\n2 - Listar Entidades\n3 - Procurar Entidade\n4 - Adicionar Carro\n0 - Voltar\nInsira a opção: ");
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
				
				System.out.println("Insira o nome: ");
				nome = read.nextLine();
				
				new GestaoEntidade().addPessoa(listaPessoa, nome);
				break;
				
			case 2:
				for(int i=0;i<listaPessoa.size();i++)
				{
					System.out.println("Nome: "+new GestaoEntidade().listarPessoa(listaPessoa, i).getNome());
				}
				break;
				
			case 3:
				read.nextLine();
				
				System.out.println("Insira o nome da pessoa: ");
				nome = read.nextLine();
				
				if(new GestaoEntidade().procPessoa(listaPessoa, nome)!=null)
				{
					System.out.println(new GestaoEntidade().procPessoa(listaPessoa, nome).getNome());
				}
				break;
				
			case 4:
				read.nextLine();
				
				System.out.println("Insira o nome da entidade: ");
				nome = read.nextLine();
				
				if(new GestaoEntidade().procPessoa(listaPessoa, nome)!=null)
				{
					String matricula,combustivel;
					int portas,esc;
					
					System.out.print("Insira a matricula do carro: ");
					matricula = read.nextLine();
					System.out.print("Insira o número de portas: ");
					portas = read.nextInt();
					
					do
					{
						System.out.print("1 - Diesel\n2 - Gasolina\n3 - Elétrico");
						esc = read.nextInt();
					}while(esc<1 || esc>3);
					
					if(esc==1){
						combustivel="Diesel";
					}else if(esc==2){
						combustivel="Gasolina";
					}else{
						combustivel="Elétrico";
					}
					new GestaoCarro().addCarro(listaPessoa, nome, matricula, portas, combustivel);
				}
				else System.out.println("Entidade Inexistente!");
				break;
			}
			
		}while(opc!=0);
	}
}
