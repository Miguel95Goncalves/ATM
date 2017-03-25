package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GestaoPessoa;
import model.Pessoa;

public class MenuPessoa {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuPessoa(ArrayList<Pessoa> listaPessoa){
		int opc;
		String nome;
		
		do
		{
			System.out.println("1 - Adicionar Pessoa\n2 - Listar Pessoas\n3 - Procurar Pessoa\n0 - Voltar\nInsira a op��o: ");
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
				read.nextLine();
				
				System.out.println("Insira o nome: ");
				nome = read.nextLine();
				
				new GestaoPessoa().addPessoa(listaPessoa, nome);
				break;
				
			case 2:
				for(int i=0;i<listaPessoa.size();i++)
				{
					System.out.println("Nome: "+new GestaoPessoa().listarPessoa(listaPessoa, i).getNome());
				}
				break;
				
			case 3:
				read.nextLine();
				
				System.out.println("Insira o nome da pessoa: ");
				nome = read.nextLine();
				
				if(new GestaoPessoa().procPessoa(listaPessoa, nome)!=null)
				{
					System.out.println(new GestaoPessoa().procPessoa(listaPessoa, nome).getNome());
				}
				break;
			}
			
		}while(opc!=0);
	}
}
