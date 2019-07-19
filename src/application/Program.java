package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
		System.out.println("Informe o número do quarto :");
		int numQuarto = sc.nextInt();
		System.out.println("Informe a data de check-in: (dd/mm/aaaa ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Informe a data de check-out: (dd/mm/aaaa ");
		Date checkOut = sdf.parse(sc.next());

		Reserva reserva = new Reserva(numQuarto, checkIn, checkOut);
		System.out.println("Reserva:" + "\n" + reserva);
		System.out.println(" ");
		System.out.println("Informe os dados de atualização da reserva :");
		System.out.println("Informe a data de check-in: (dd/mm/aaaa ");
		checkIn = sdf.parse(sc.next());
		System.out.println("Informe a data de check-out: (dd/mm/aaaa ");
		checkOut = sdf.parse(sc.next());

		reserva.atualizarReserva(checkIn, checkOut);
		System.out.println("Reserva:" + "\n" + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data inválida ");
		}
		catch (DomainException e ) {
			System.out.println("erro na reserva "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("erro inesperado.");
		}
		sc.close();
	}

}
