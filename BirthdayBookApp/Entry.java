
public class Entry {

	private String name;
	private Birthday birthday;
	
	public Entry (String n, Birthday bd) {
		this.name = n;
		this.birthday = bd;
	}
	
	public Entry (String n, int m, int d) {
		this.name = n;
		Birthday bd = new Birthday(m, d);
		this.birthday = bd;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Birthday getBirthday() {
		return this.birthday;
	}
	
	public String toString() {
		String m = this.name + " was born on " + this.birthday.toString();
		return m;
	}
	
	public void setName (String n) {
		this.name = n;
	}
	
	public void setBirthday (int m, int d) {
		Birthday bd = new Birthday (m, d);
		this.birthday = bd;
	}
	
	public void setBirthday (Birthday bd) {
		this.birthday = bd;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) { return false; }
		Entry other = (Entry) obj;
		
		return this.getName().equals(other.getName()) && this.getBirthday().equals(other.getBirthday());
	}
}
