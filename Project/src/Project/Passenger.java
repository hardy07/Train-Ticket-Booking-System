package Project;

public class Passenger {
	private long passengerId;
	private String passengerName;
	private int age;
	private BankAccount bankAccount   ;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
		}
	public Passenger(long passengerId, String passengerName, int age, BankAccount bankAccount) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
		this.bankAccount = bankAccount;
		}
	public long getPassengerId() {
		return passengerId;
		}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
		}
	public String getPassengerName() {
		return passengerName;
		}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
		}
	public int getAge() {
		return age;
		}
	public void setAge(int age) {
		this.age = age;
		}
	public BankAccount getBankAccount() {
		return bankAccount;
		}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
		}
	}
