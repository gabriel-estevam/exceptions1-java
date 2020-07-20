package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program 
{
	public static void main(String[] args)
	{
		//method2();
		method1();
		System.out.println("End of Program"); //Mostra essa msg se existir o try-catch
		
	}
	/*Foi criado dois metods a principio para mostrar o funcionamento do StackTrace
	 * Esse metodo vai mostrar a pilha de chamadas de metodos usadas que acarretou no erro
	 * do programa.
	 * No exemplo tentamos acessar uma posição do vetor que não existe
	 * Resultado: Mostra toda chamada de metodo envolvido naquele erro, começa pelo method2 que é aonde esta o try-catch
	 * em seguida mostra o method1 que que esta chamando o method2, e por fim o main
	 * O programa continua*/
	public static void method1() 
	{
		System.out.println("***METHOD1 START***");
		method2();
		System.out.println("***METHOD1 END***");
	}
	
	public static void method2()
	{
		System.out.println("***METHOD2 START***");
		Scanner sc = new Scanner(System.in);
		/*Se não envolvermos o codigo abaixo no try-catch ele para o sistema*/
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		//O catch captura o erro e não finaliza o programa, dentro dele temos
		//que tratar esse erro, no exemplo mandos menssagem na tela
		//e continua o programa
		catch(ArrayIndexOutOfBoundsException e) 
		{		
			System.out.println("Error! Invalid Position");
			e.printStackTrace();
			/*O stackTrace mostra toda a chamada de metodos que resultou na excessão
			 * ele mostra todos os metodos envolvidos
			 * Ele não termina o programa so mostra a pilha dos metodos para auxiliar
			 * a encontrar o erro */
			sc.next();
			
		}
		catch(InputMismatchException e) 
		{		
			System.out.println(" Erro! Enter with integer number");
		}
		
		sc.close();
		System.out.println("***METHOD2 END***");
	}
}
