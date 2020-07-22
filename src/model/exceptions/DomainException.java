package model.exceptions;

public class DomainException extends Exception 
{
	//Se colocarmos extends RuntimeException o compilador n�o obriga a tratar
	/*Essa classe � uma classe serializable, isto � tem um numero de vers�o
	 * no caso o Exception � serializable*/
	private static final long serialVersionUID = 1L; //valor de vers�o padr�o
	
	public DomainException(String msg)
	{
		/*Criado um construtor que para cada vez que for instanciada essa
		 * classe, passa um valor String, uma menssagem*/
		super(msg);
	}
}
