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
			System.out.println("1 - Criar Conta Banc�ria\n2 - Listar Contas Banc�rias\n0 - Voltar\nInsira a op��o: ");
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
				
				break;
				
			case 2:
				
				break;
			}
			
		}while(opc!=0);
		
	}
}
