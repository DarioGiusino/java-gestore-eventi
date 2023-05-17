package org.java.main;

import java.time.LocalDate;
import java.util.Scanner;

import org.java.obj.Event;

public class Main {
	public static void main(String[] args) {
		// open scanner
		Scanner sc = new Scanner(System.in);

		System.out.print("Benvenuto, inserisci un nuovo evento:" + "\nTitolo: ");
		String title = sc.nextLine();

		System.out.println("Data: (formato dd-MM-yyyy)");
		String date = sc.nextLine();
		String[] dateArr = date.split("-");
		Integer day = Integer.valueOf(dateArr[0]);
		Integer month = Integer.valueOf(dateArr[1]);
		Integer year = Integer.valueOf(dateArr[2]);

		System.out.print("Totale posti disponibili: ");
		int totalSeats = sc.nextInt();

		try {
			Event event = new Event(title, LocalDate.of(year, month, day), totalSeats);
			System.out.println(event);

			boolean ask = true;

			while (ask) {
				System.out.println(
						"Cosa vuoi fare?" + "\n[1]Prenota posti" + "\n[2]Disdici posti" + "\n[3]Esci e Stampa");
				int choice = sc.nextInt();

				if (choice < 1 || choice > 3) {
					System.err.println("Selezione non valida");
					continue;
				}

				switch (choice) {
				case 1: {
					System.out.println("Quanti posti vuoi prenotare?");
					int seats = sc.nextInt();

					try {
						for (int i = 0; i < seats; i++) {
							event.AddSeats();
						}
						
						System.out.println("Totale posti prenotati: "
								+ event.getReservedSeats() + "\nTotale posti disponibili: "
								+ (event.getTotalSeats() - event.getReservedSeats()));
					} catch (Exception e) {
						System.err.println(e);
						continue;
					}
				}
					break;

				case 2: {
					System.out.println("Quanti posti vuoi disdire?");
					int seats = sc.nextInt();

					try {
						for (int i = 0; i < seats; i++) {
							event.RemoveSeats();
						}
						
						System.out.println("Totale posti prenotati: "
								+ event.getReservedSeats() + "\nTotale posti disponibili: "
								+ (event.getTotalSeats() - event.getReservedSeats()));
					} catch (Exception e) {
						System.err.println(e);
						continue;
					}
				}
					break;

				case 3:
					ask = false;
					System.out.println("\n-------------------------------\n");
					System.out.println("Grazie e arrivederci, ecco un riepilogo:");
					System.out.println("Totale posti prenotati: "
							+ event.getReservedSeats() + "\nTotale posti disponibili: "
							+ (event.getTotalSeats() - event.getReservedSeats()));
				}

			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

	}
}
