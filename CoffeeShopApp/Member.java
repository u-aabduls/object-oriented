
public class Member {
	
	private String mem = "mem";
	private static int counter = 1;
	private String Id = mem;
	private double balance;
	private Order[] orders;
	private int noo;
	
	public Member(double balance) {
		this.Id = this.mem + counter; 
		counter++;
		this.balance = balance;
		this.orders = new Order[10];
		this.noo = 0;
	}
	
	public Member() {
		this.Id = this.mem + counter; 
		counter++;
		this.balance = 0.0;
		this.orders = new Order[10];
		this.noo = 0;
	}

	public String getId() {
		return Id;
	}

	public void setID(String iD) {
		Id = iD;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getNoo() {
		return noo;
	}

	public void setNoo(int noo) {
		this.noo = noo;
	}

	public Order[] getOrders() {
		
		Order[] os = new Order[noo];
		for(int i = 0; i < noo; i++) {
			os[i] = orders[i];
		}
		
		return os;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}
	
	public double getAmountToPay() {
		
		double amount = 0.0;
		
		for (int i = 0; i < noo; i++) {
			amount += orders[i].getQuantity() * orders[i].getPrice();
		}
		
		return amount;
		
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void addOrder(Order o) {
		orders[noo] = o;
		noo++;
	}
	
	public void addOrder(String product, double price, int quantity) {
		Order o = new Order(product, price, quantity);
		orders[noo] = o;
		noo++;
	}
	
	
}
