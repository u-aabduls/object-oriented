
public class Entry {
	
	private String name;
	private Birthday birthday;
	
	public Entry(String name, Birthday birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public Entry(String name, int month, int day) {
		this.name = name;
		Birthday birthday = new Birthday(month, day);
		this.birthday = birthday;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Birthday getBirthday() {
		return this.birthday;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(int month, int day) {
		Birthday birthday = new Birthday (month, day);
		this.birthday = birthday;
	}
	
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return this.name + " was born on " + this.birthday.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) { return true; }
		if (obj == null || this.getClass() != obj.getClass()) { return false; }
		
		Entry other = (Entry) obj;
		
		return this.name.equals(other.name) && this.birthday.equals(other.getBirthday());
	}
}
