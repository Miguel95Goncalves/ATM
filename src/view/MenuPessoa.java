package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Pessoa;

public class MenuPessoa {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuPessoa(ArrayList<Pessoa> listaPessoa){
		int opc;
		
		do
		{
			System.out.println("1 - Adicionar Pessoa\n2 - Listar Pessoas\n0 - Voltar\nInsira a opção: ");
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
				
				break;
				
			case 2:
				
				break;
			}
			
		}while(opc!=0);
		
	}
}
