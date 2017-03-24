package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.ContaBancaria;

public class MenuContaBancaria {
	
	Scanner read = (new Scanner(System.in));
	
	public void menuContaBancaria(ArrayList<ContaBancaria> listaConta){
		int opc;
		
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
				
				break;
				
			case 2:
				
				break;
			}
			
		}while(opc!=0);
		
	}
}
