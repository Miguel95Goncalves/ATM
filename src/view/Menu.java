package view;

import java.util.Scanner;
import java.util.ArrayList;

import model.*;

public class Menu {
	
	ArrayList<ContaBancaria> listaConta = new ArrayList<ContaBancaria>();
	Scanner read = (new Scanner(System.in));
	
	public void menu(){
		int opc;
		
		do
		{
			System.out.println("1 - ContaBancaria\n2 - Cliente\n0 - Sair\nInsira a op��o: ");
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