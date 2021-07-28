package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Room;

public class Program_Room {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Room[] vect= new Room[10];
		
		System.out.printf("How many rooms will be rented? ");
		int op = sc.nextInt();
		int n = 1;
		for(int x=0; x<op; x++ ) {
			System.out.println("\nRent #"+n);
			sc.nextLine();
			System.out.printf("Name: ");
			String name = sc.nextLine();
			System.out.printf("Email: ");
			String email = sc.nextLine();
			System.out.printf("Room: ");
			int room = sc.nextInt();
			
			vect[room] = new Room(name, email, room);
			n++;
		}
		System.out.println("\nBusy rooms:");
		for( int x=0; x<vect.length; x++) {
			if(vect[x] != null) {
				System.out.println(vect[x]);
			}
		}
		sc.close();
	}
}
