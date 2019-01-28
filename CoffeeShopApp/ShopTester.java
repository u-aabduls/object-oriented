
public class ShopTester {
	
	public static void main(String[] args) {
		System.out.println("(1.1)-------------------------------");
		Order o1 = new Order("Americano", 4.7, 2);
		System.out.println(o1.getProduct());
		System.out.println(o1.getPrice());
		System.out.println(o1.getQuantity());
		System.out.println();
		
        System.out.println("(1.2)-------------------------------");
        Order o2 = new Order();
        System.out.println(o2.getProduct());
        System.out.println(o2.getPrice());
        System.out.println(o2.getQuantity());
        o2.setProduct("Americano");
        o2.setPrice(4.7);
        o2.setQuantity(2);
        System.out.println(o2.getProduct());
        System.out.println(o2.getPrice());
        System.out.println(o2.getQuantity());
        System.out.println();

		System.out.println("(2)-------------------------------");
		Member alan = new Member(20.0); /* a member with initial balance 20.0 */
		System.out.println(alan.getId());
		System.out.println(alan.getBalance());
		Order[] alanOrders = alan.getOrders();
		System.out.println("Alan's number of orders: " + alanOrders.length);
		double alanPay = alan.getAmountToPay();
		System.out.println("Alan needs to pay: " + alanPay);
        System.out.println();

		System.out.println("(3)-------------------------------");
		Member mark = new Member(); /* a member with initial balance 0.0 */
		System.out.println(mark.getId());
		System.out.println(mark.getBalance());
		Order[] markOrders = mark.getOrders();
		System.out.println("Mark's number of orders: " + markOrders.length);
		double markPay = mark.getAmountToPay();
		System.out.println("Mark needs to pay: " + markPay);
		mark.deposit(40.0);
		System.out.println(mark.getBalance());
        System.out.println();

		System.out.println("(4)-------------------------------");
		alan.addOrder(o1);
		alanOrders = alan.getOrders();
		System.out.println("Alan's number of orders: " + alanOrders.length);
		Order alanOrder1 = alanOrders[0];
		System.out.println("Product of Alan's 1st order: " + alanOrder1.getProduct());
		System.out.println("Price of Alan's 1st order: " + alanOrder1.getPrice());
		System.out.println("Quantity of Alan's 1st order: " + alanOrder1.getQuantity());
		alanPay = alan.getAmountToPay();
		System.out.println("Alan needs to pay: " + alanPay);
        System.out.println();

		System.out.println("(5)-------------------------------");
		alan.addOrder("Caffe Latte", 5.5, 1);
		alanOrders = alan.getOrders();
		System.out.println("Alan's number of orders: " + alanOrders.length);
		alanOrder1 = alanOrders[0];
		System.out.println("Product of Alan's 1st order: " + alanOrder1.getProduct());
		System.out.println("Price of Alan's 1st order: " + alanOrder1.getPrice());
		System.out.println("Quantity of Alan's 1st order: " + alanOrder1.getQuantity());
		Order alanOrder2 = alanOrders[1];
		System.out.println("Product of Alan's 2nd order: " + alanOrder2.getProduct());
		System.out.println("Price of Alan's 2nd order: " + alanOrder2.getPrice());
		System.out.println("Quantity of Alan's 2nd order: " + alanOrder2.getQuantity());
		alanPay = alan.getAmountToPay();
		System.out.println("Alan needs to pay: " + alanPay);
        System.out.println();

		System.out.println("(6)-------------------------------");
		Shop hollys = new Shop();
		Member[] members = hollys.getMembers();
		System.out.println("Number of members: " + members.length);
		System.out.println("Alan is a member: " + hollys.hasMember(alan.getId()));
		System.out.println("Mark is a member: " + hollys.hasMember(mark.getId()));
        System.out.println();

		System.out.println("(7)-------------------------------");
		hollys.addMember(alan);
		hollys.addMember(mark);
		members = hollys.getMembers();
		System.out.println("Number of members: " + members.length);
		System.out.println("Member 1's id: " + members[0].getId());
		System.out.println("Member 2's id: " + members[1].getId());
		System.out.println("Alan is a member: " + hollys.hasMember(alan.getId()));
		System.out.println("Mark is a member: " + hollys.hasMember(mark.getId()));
        System.out.println();

		System.out.println("(8)-------------------------------");
		/* charge an existing member: deduct their balance */
		hollys.checkOut(alan.getId());
		hollys.checkOut(mark.getId());
		System.out.println("Member with id \"mem3\" exists: " + hollys.hasMember("mem3"));
		/* charge a non-existing member: do nothing */
		hollys.checkOut("mem3");
		System.out.println("Alan's new balance: " + alan.getBalance());
		System.out.println("Mark's new balance: " + mark.getBalance());
        System.out.println();

		/* After charging a member with their current orders,
		 * we also clear all those orders. */
		System.out.println("(9)-------------------------------");
		alanOrders = alan.getOrders();
		System.out.println("Alan's number of orders: " + alanOrders.length);
		alanPay = alan.getAmountToPay();
		System.out.println("Alan needs to pay: " + alanPay);
	}
	
}
