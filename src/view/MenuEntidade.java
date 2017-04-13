package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GestaoEntidade;
import model.Entidade;

public class MenuEntidade {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuPessoa(ArrayList<Entidade> listaPessoa){
		int opc;
		String nome;
		
		do
		{
			System.out.println("1 - Adicionar Pessoa\n2 - Listar Pessoas\n3 - Procurar Pessoa\n0 - Voltar\nInsira a opção: ");
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
			}
			
		}while(opc!=0);
	}
}
