package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation 
{
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) 
	{
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
	
	public String updateDates(Date checkIn, Date checkOut)
	{
		//Função para atualizar as datas
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now))
		{
			return "Error in reservation: Reservation dates for update must be future";
		}
		
	    if (!checkOut.after(checkIn))
		{
	    	return "Error in reservation: check-out date must be after check-in date";
		}
	    
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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
