package Project;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class TrainService {
    //Linked list
	private static List<Train> allTrains = new LinkedList<>();
	static int siz = 0;
    
    static {
    	System.out.println("--------------------------------------------------------------------------------------");
    	LocalDate today = LocalDate.now();
    	allTrains.add(new Train(101,"Train-one", "Hyd", "Bnglr", 100, 800, LocalDate.now()));
        allTrains.add(new Train(102,"Train-two", "Bnglr", "Hyd", 100, 800, LocalDate.now()));
        allTrains.add(new Train(103,"Train-three", "Hyd", "Kochi", 80, 600, LocalDate.now()));
        allTrains.add(new Train(104,"Train-four", "Kochi", "Hyd", 80, 600, LocalDate.now()));
        allTrains.add(new Train(105,"Train-five", "Hyd", "Chn", 100, 900, LocalDate.now()));
        allTrains.add(new Train(106,"Train-six", "Chn", "Hyd", 100, 900, LocalDate.now()));
        allTrains.add(new Train(106,"Train-seven", "Chn", "Kochi", 100, 900, LocalDate.now()));
        
    	allTrains.add(new Train(101,"Train-one", "Hyd", "Bnglr", 100, 800, today.plusDays(1)));
        allTrains.add(new Train(102,"Train-two", "Bnglr", "Hyd", 100, 800, today.plusDays(1)));
        allTrains.add(new Train(103,"Train-three", "Hyd", "Kochi", 80, 600, today.plusDays(1)));
        allTrains.add(new Train(104,"Train-four", "Kochi", "Hyd", 80, 600, today.plusDays(1)));
        allTrains.add(new Train(105,"Train-five", "Hyd", "Chn", 100, 900, today.plusDays(1)));
        allTrains.add(new Train(106,"Train-six", "Chn", "Hyd", 100, 900, today.plusDays(1)));
        allTrains.add(new Train(106,"Train-seven", "Chn", "Kochi", 100, 900, today.plusDays(1)));
        
    	allTrains.add(new Train(101,"Train-one", "Hyd", "Bnglr", 100, 800, today.plusDays(2)));
        allTrains.add(new Train(102,"Train-two", "Bnglr", "Hyd", 100, 800, today.plusDays(2)));
        allTrains.add(new Train(103,"Train-three", "Hyd", "Kochi", 80, 600, today.plusDays(2)));
        allTrains.add(new Train(104,"Train-four", "Kochi", "Hyd", 80, 600, today.plusDays(2)));
        allTrains.add(new Train(105,"Train-five", "Hyd", "Chn", 100, 900, today.plusDays(2)));
        allTrains.add(new Train(106,"Train-six", "Chn", "Hyd", 100, 900, today.plusDays(2)));
        allTrains.add(new Train(106,"Train-seven", "Chn", "Kochi", 100, 900, today.plusDays(2)));
        
    	allTrains.add(new Train(101,"Train-one", "Hyd", "Bnglr", 100, 800, today.plusDays(3)));
        allTrains.add(new Train(102,"Train-two", "Bnglr", "Hyd", 100, 800, today.plusDays(3)));
        allTrains.add(new Train(103,"Train-three", "Hyd", "Kochi", 80, 600, today.plusDays(3)));
        allTrains.add(new Train(104,"Train-four", "Kochi", "Hyd", 80, 600, today.plusDays(3)));
        allTrains.add(new Train(105,"Train-five", "Hyd", "Chn", 100, 900, today.plusDays(3)));
        allTrains.add(new Train(106,"Train-six", "Chn", "Hyd", 100, 900, today.plusDays(3)));
        allTrains.add(new Train(106,"Train-seven", "Chn", "Kochi", 100, 900, today.plusDays(3)));
        
    	allTrains.add(new Train(101,"Train-one", "Hyd", "Bnglr", 100, 800, today.plusDays(4)));
        allTrains.add(new Train(102,"Train-two", "Bnglr", "Hyd", 100, 800, today.plusDays(4)));
        allTrains.add(new Train(103,"Train-three", "Hyd", "Kochi", 80, 600, today.plusDays(4)));
        allTrains.add(new Train(104,"Train-four", "Kochi", "Hyd", 80, 600, today.plusDays(4)));
        allTrains.add(new Train(105,"Train-five", "Hyd", "Chn", 100, 900, today.plusDays(4)));
        allTrains.add(new Train(106,"Train-six", "Chn", "Hyd", 100, 900, today.plusDays(4)));
        allTrains.add(new Train(106,"Train-seven", "Chn", "Kochi", 100, 900, today.plusDays(4)));

        }
    
    public TrainService() {
    	super();
    	}
    public static Train findTrain(int trainNumber) {
    	Train temp = null;
    	for(Train t : allTrains) {
    		if(t.getTrainNumber() == trainNumber) {
    			temp = t;
    			break;
    			}
    		}
    	return temp;
    	}
    public static void searchTrainsBetweenStations(String fromStation, String toStation, LocalDate doj, int numOfSeats) {
    	List<Train> searchTrainList = new LinkedList<>();
    	for(Train t : allTrains) {
    		if(t.getFromStation().equals(fromStation) &&
    				t.getToStation().equals(toStation) &&
    				t.getDoj().equals(doj) &&
    				t.getSeatsAvailable() > numOfSeats) {
    			searchTrainList.add(t);
    			}
    		}
    	siz = searchTrainList.size();
    	if(searchTrainList.size()==0) {
    		System.out.println("Sorry, no matching trains available for the search criteria...");
    		}
    	else {
    		System.out.println("Train.No.\tTrain Name\tFrom Station\tTo Station\tDoj\tSeats Available\tFare");
    		System.out.println();
    		for(Train t : searchTrainList) {
    			System.out.printf("%4d%20s%15s%15s%12s%4d%5d",t.getTrainNumber(),t.getTrainName(),t.getFromStation(),t.getToStation(),t.getDoj(),t.getSeatsAvailable(),t.getFare());
    			System.out.println();
    			}
    		}
    	}
    public static void bookTickets(int trainNumber,List<Passenger> passengerList) {
    	// step-1 we need to subtract the train fare for all passengers together from the bank account object 
    	int numOfSeats = passengerList.size(); 
	   
    	/* Passenger tempPassenger = passengerList.get(0); 
	    * BankAccount account = tempPassenger.getBankAccount();*/
	   BankAccount account = passengerList.get(0).getBankAccount(); 
	   Train tempTrain = findTrain (trainNumber);
	   int fare = tempTrain.getFare(); 
	   int totalFare = fare * numOfSeats; account.withdraw(totalFare);

	   // step-2 we need to subtract the number of seats that are being booked, from the actual available no of seats 
	   tempTrain.setSeatsAvailable(tempTrain.getSeatsAvailable()- numOfSeats);

	   // step-3. we need to add one entry (one record) into tickets collection.

	   TicketService.addNewTicket(trainNumber,passengerList);
	   }
    }
