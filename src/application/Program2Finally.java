package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program2Finally 
{
	public static void main(String[] args) 
	{
		File file = new File("C:\\temp\\in.txt"); //passa o caminho do arquivo
		Scanner sc = null; //declarado um scanner
		try 
		{
			sc = new Scanner(file); //O scanner tambem  aponta e le arquivos
			/*A estrutura while abaixo vai mostrar o conteudo do arquivo, enquanto
			 * o scanner percorre o arquivo lendo*/
			while (sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
		} 
		catch (FileNotFoundException e) 
		{
			//Caso o arquivo não exista
			System.out.println("Erro opening file: "+ e.getMessage());
		}
		finally
		{
			//Esse bloco fecha o arquivo/scanner independe se deu certo ou não
			if(sc != null)
			{
				sc.close();
			}
			System.out.println("Finally block executed");
		}
		
		
	}
}
