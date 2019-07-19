package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
private Integer numQuarto;
private Date checkIn;
private Date checkOut;
private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DomainException {
	if(!checkOut.after(checkIn)){
		throw new DomainException("A data de check-out deve ser posterior ao check-in.");
	}
	this.numQuarto = numQuarto;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
}
public Integer getNumQuarto() {
	return numQuarto;
}
public void setNumQuarto(Integer numQuarto) {
	this.numQuarto = numQuarto;
}
public Date getCheckIn() {
	return checkIn;
}
public Date getCheckOut() {
	return checkOut;
}
public long duracao() {
	long dif = checkOut.getTime()-checkIn.getTime();
	return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
}
public void atualizarReserva(Date checkIn , Date checkOut)throws DomainException {
	Date now = new Date();
	if(checkIn.before(now)|| checkOut.before(now)) {
		throw new DomainException( "As datas para reserva devem ser futuras.");
	}
	if(!checkOut.after(checkIn)){
		throw new DomainException("A data de check-out deve ser posterior ao check-in.");
	}
	this.checkIn= checkIn;
	this.checkOut= checkOut;
}
@Override
public String toString() {
	return " quarto " + numQuarto + " , Check-in: "+
sdf.format(checkIn)+", Check-out: "+sdf.format(checkOut)+", "+duracao ()+
" noites.";
}
}
