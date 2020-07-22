package model.exceptions;

public class DomainException extends Exception 
{
	//Se colocarmos extends RuntimeException o compilador não obriga a tratar
	/*Essa classe é uma classe serializable, isto é tem um numero de versão
	 * no caso o Exception é serializable*/
	private static final long serialVersionUID = 1L; //valor de versão padrão
	
	public DomainException(String msg)
	{
		/*Criado um construtor que para cada vez que for instanciada essa
		 * classe, passa um valor String, uma menssagem*/
		super(msg);
	}
}
