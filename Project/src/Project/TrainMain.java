package Project;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

public class TrainMain {
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		Scanner ar = new Scanner(System.in);
		 System.out.println("Now searching for train...");
		 System.out.println("Enter Boarding station");
		String from = sr.nextLine();
		System.out.println("Enter the destination ");
		String To = sr.nextLine();
		System.out.println("Enter date in the format yyyy-MM-dd");
		String date = ar.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate loc = LocalDate.parse(date, formatter);
		System.out.println("Enter number of tickets ");
		int nooftic = sr.nextInt();
		TrainService.searchTrainsBetweenStations(from,To,loc,nooftic);
		if(TrainService.siz!=0) {
			BankAccount b1 = new BankAccount();
			b1.setActNumber(999);
			b1.setActBalance (10000);
			List<Passenger> passengerList = new LinkedList<>();
			for(int i =0;i<nooftic;i++) {
				System.out.println("\nEnter the name of the passenger");
				String name = ar.nextLine();
				System.out.println("Enter ID number");
				long ID = sr.nextLong();
				System.out.println("Enter the age of the passenger");
				int age = sr.nextInt();
				Passenger p = new Passenger(ID,name,age, b1);
				passengerList.add(p);
				}
			int initialBalance = b1.getActBalance();
			System.out.println("Enter train number");
			int trainno = sr.nextInt();
	        TrainService.bookTickets(trainno,passengerList);
	        System.out.println("--------------------------------------------------------------------------");
			//System.out.println("now printing the ticket details...\n");
			TicketService.showTicketDetails(1);
			
			//System.out.println("\n\n");
			TrainService.searchTrainsBetweenStations(from,To,loc,nooftic);
			System.out.println("--------------------------------------------------------------------------------------------");
			
			int balanceAfterBookingTickets = b1.getActBalance();
			System.out.println();
			System.out.println("Bank Statement:");
			System.out.println("----------------------------");
			System.out.println("Initial balance =" + initialBalance);
			System.out.println("Balance after booking =" + balanceAfterBookingTickets );
			System.out.println("----------------------------");
	        sr.close();
	        ar.close();
	        }
		}
	}