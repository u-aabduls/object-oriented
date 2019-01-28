
public class BirthdayBook {
	
	private Entry[] entries;
	private int noe;
	
	public BirthdayBook() {
		this.entries = new Entry[10];
		this.noe = 0;
	}
	
	public Entry[] getEntries() {
		Entry[] es = new Entry[noe];
		for (int i = 0; i < noe; i++) {
			es[i] = entries[i];
		}
		return es;
	}
	
	public int getNumberOfEntries() {
		return this.noe;
	}
	
	@Override
	public String toString() {
		
		String message1 = "There are " + getNumberOfEntries() + " entries in the book\n";
		String message2 = "";
		
		for (int i = 0; i < noe; i++) {
			message2 += entries[i].toString() + "\n";
		}
		
		return message1 + message2;
		
	}
	
	public int indexOf(String name) {
		
		int index = -1;
		boolean found = false;
		
		for (int i = 0; i < noe && !found; i++) {
			
			if(entries[i].getName().equals(name)) {
				index = i;
				found = true;
			}
		}
		
		return index;
	}
	
	public boolean nameExists(String name) {
		
		int index = indexOf(name);
		boolean nameExists = index >= 0;
		
		return nameExists;
		
	}
	
	public Birthday getBirthday(String name) {
		
		int index = indexOf(name);
		
		if (index >= 0) {
			return entries[index].getBirthday();
		}
		else {
			return null;
		}
		
	}
	
	public String[] getReminders(Birthday birthday) {
		
		int numberOfReminders = 0;
		
		for (int i = 0; i < noe; i++) {
			if (birthday.equals(entries[i].getBirthday())) {
				numberOfReminders++;
			}
		}
		
		String[] reminders = new String[numberOfReminders];
		
		int j = 0;
		for (int i = 0; i < noe; i++) {
			
			if (entries[i].getBirthday().equals(birthday)) {
				reminders[j] = entries[i].getName();
				j++;
			}
		}
		
		return reminders;
		
	}
	
	public String[] getReminders(int month, int day) {
		
		Birthday birthday  = new Birthday(month, day);
		
		return getReminders(birthday);

	}
	
	public void removeEntry(String name) {
		
		int index = indexOf(name);
		if (index < 0) {
			//do nothing
		}
		else {
			
			for (int i = index; i < noe - 1; i++) {
				this.entries[i] = this.entries[i+1];
			}
			
			this.entries[noe-1] = null;
			this.noe--;
		}
		
	}
	
	public void addEntry(String name, Birthday birthday) {
		
		int index = indexOf(name);
		
		if (index < 0) {
			Entry entry = new Entry(name, birthday);
			entries[noe] = entry;
			noe++;
		}
		
		else if (index >= 0) {
			Entry entry = new Entry(name, birthday);
			entries[index] = entry;
		}
		
	}
	
	public void addEntry(String name, int month, int day) {
		Birthday birthday = new Birthday(month, day);
		addEntry(name, birthday);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) { return true; }
		if (obj == null || this.getClass() != obj.getClass()) { return false; }
		
		BirthdayBook other = (BirthdayBook) obj;
		
		boolean isEqual = this.getNumberOfEntries() == other.getNumberOfEntries();
		
		for (int i = 0; i < this.noe && isEqual; i++) {
			isEqual = this.entries[i].equals(other.entries[i]);
		}
		
		return isEqual;
	}

}
