package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
Scanner sc = new Scanner (System.in);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
System.out.println("Informe o número do quarto :");
int numQuarto = sc.nextInt();
System.out.println("Informe a data de check-in: (dd/mm/aaaa ");
Date checkIn = sdf.parse(sc.next());
System.out.println("Informe a data de check-out: (dd/mm/aaaa ");
Date checkOut = sdf.parse(sc.next());
if(!checkOut.after(checkIn)) {
	System.out.println("Erro na reserva : A data de check-out deve ser posterior ao check-in. ");
}
else {
	Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
	System.out.println("Reserva:"+"\n"+ reserva);
	System.out.println(" ");
	System.out.println("Informe os dados de atualização da reserva :");
	System.out.println("Informe a data de check-in: (dd/mm/aaaa ");
	checkIn = sdf.parse(sc.next());
	System.out.println("Informe a data de check-out: (dd/mm/aaaa ");
	checkOut = sdf.parse(sc.next());
	Date now = new Date();
	if(checkIn.before(now)|| checkOut.before(now)) {
		System.out.println("As datas para reserva devem ser futuras.");
	}
	else if(!checkOut.after(checkIn)){
		System.out.println("Erro na reserva : A data de check-out deve ser posterior ao check-in. ");
	}
	else {
	reserva.atualizarReserva(checkIn, checkOut);
	System.out.println("Reserva:"+"\n"+ reserva);
	}
}
sc.close();
	}

}
