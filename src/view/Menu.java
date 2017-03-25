package view;

import java.util.Scanner;
import java.util.ArrayList;

import model.*;

public class Menu {
	
	ArrayList<ContaBancaria> listaConta = new ArrayList<ContaBancaria>();
	ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	Scanner read = (new Scanner(System.in));
	
	public void menu(){
		int opc;
		
		do
		{
			System.out.println("1 - ContaBancaria\n2 - Cliente\n0 - Sair\nInsira a opção: ");
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
				new MenuPessoa().menuPessoa(listaPessoa);
				break;
			}
			
		}while(opc!=0);
	}
}
