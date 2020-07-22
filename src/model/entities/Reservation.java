package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation 
{
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException 
	{
		/*No construtor tambem foi usado a mesma logica de check do metodo updateDates,
		 * pois queremos garantir que o usuario não digitou uma data inferior na data de check-out
		 * so que a difereça que aqui eu usei o checkOut.before(checkIn) a logica é mesma
		 * uma data de saida não pode ser anterior a de entrada*/
			if (checkOut.before(checkIn))
			{
		    	/*Caso a data de check-out (saida) seja uma data inferior ao de check-in(entrada), lança a excessão abaixo*/		    	
		    	//Usando a classe personalizada criada
		    	throw new DomainException("Error in reservation: check-out date must be after check-in date");
			}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	public Integer getRoomNumber() 
	{
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) 
	{
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() 
	{
		return checkIn;
	}
	
	public Date getCheckOut() 
	{
		return checkOut;
	}
	
	public long duration()
	{
		long diff = checkOut.getTime() - checkIn.getTime(); //Aqui pegamos a diferença entra as duas datas em milisegundos
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS); 
		/*Aqui primeiro converte o valor em milisegundos em dias, dai temos a diferença entre as duas datas*/
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException
	{
		/*Esse metodo esta propagando uma excessão, no caso a DomainExcption, portanto
		 * estamos "avisando" que esse metodo pode lançar uma exception e que precisa ser tratada*/
		//Metodo para atualizar as datas
		Date now = new Date(); //instancia a data atual
		if(checkIn.before(now) || checkOut.before(now))
		{
			/*Caso o check-in seja antes da data atual ou o check-out seja antes data atual, vai lança excessão abaixo*/
			/*IllegalArgumentException é uma classe pronta do java, que caso o parametro do metodo, no caso updaDates, for
			 * invalido vai lançar o argumento abaixo*/
			//throw new IllegalArgumentException( "Error in reservation: Reservation dates for update must be future");

			//Usando a classe personalizada criada
			throw new DomainException("Error in reservation: Reservation dates for update must be future");
			
		}
		
	    if (!checkOut.after(checkIn))
		{
	    	/*Caso a data de check-out (saida) seja uma data inferior ao de check-in(entrada), lança a excessão abaixo*/
	    	//throw new IllegalArgumentException("Error in reservation: check-out date must be after check-in date");
	    	
	    	//Usando a classe personalizada criada
	    	throw new DomainException("Error in reservation: check-out date must be after check-in date");
		}
	    
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString()
	{
		return "Room "
			    +roomNumber
			    +", ckeck-in: "
			    +sdf.format(checkIn)
			    +", check-out: "
			    +sdf.format(checkOut)
			    +", "
			    +this.duration()
			    +" nights";
	}
	
	
	
}
