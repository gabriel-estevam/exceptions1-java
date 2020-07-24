package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountDomainException;

public class Program4 
{
	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
			
		Account acc = new Account(number, holder, initialBalance, withdrawLimit);
			
		System.out.println();
		System.out.print("Enter amount for withdraw: "); //pode gerar uma excessão
		double withdraw = sc.nextDouble();
		/*Nesse caso so envolvi o try na chamada do meteodo withdraw porque o exercicio pedia para tratar exceção nesse metodo,
		 * mas o try poderia ser nada demais entrada de dados, como por exemplo o numero da conta, no proprio deposito (initial balance),
		 * caso acontece uma entrada de dados errada o sistema vai parar*/
		try 
		{
			acc.withdraw(withdraw);
			System.out.println(acc);
		}
		
		catch(AccountDomainException e)
		{
			//esse catch esta chamando a excecão criada, isto é, personalizada
			System.out.println("Withdraw error: "+ e.getMessage());
		}
		
		sc.close();
	}
}
