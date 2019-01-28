
public class Order {

	private String product;
	private double price;
	private int quantity;
	
	public Order(String product, double price, int quantity) {
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Order() {
		this.product = null;
		this.price = 0.0;
		this.quantity = 0;
	}
	
	public String getProduct() {
		return this.product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
