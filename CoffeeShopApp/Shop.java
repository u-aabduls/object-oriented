
public class Shop {
	
	Member[] members;
	private int nom;
	
	public Shop() {
		this.members = new Member[30];
		this.nom = 0;
	}
	
	public Member[] getMembers() {
		
		Member[] ms = new Member[nom];
		for(int i = 0; i < nom; i++) {
			ms[i] = members[i];
		}
		
		return ms;
	}
	
	public int indexOf(String Id) {
		
		int index = -1;
		boolean found = false;
		
		for(int i = 0; i < nom && !found; i++) {
			if(Id.equals(members[i].getId())) {
				index = i;
				found = true;
			}
			else {
				found = false;
			}
		}
		
		return index;
		
	}
	
	public boolean hasMember(String Id) {
		return indexOf(Id) >= 0;
	}
	
	public void addMember(Member m) {
		members[nom] = m;
		nom++;
	}
	
	public void checkOut(String Id) {

		int index = indexOf(Id);
		
		if(index >= 0) {
			double amount = members[index].getAmountToPay();
			members[index].setBalance(members[index].getBalance() - amount);
			Order[] os = new Order[1];
			members[index].setNoo(0);
		}
		
	}

}
