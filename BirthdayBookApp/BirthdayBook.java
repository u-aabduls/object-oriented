
public class BirthdayBook {

	private Entry[] entries;
	private int noe;
	
	public BirthdayBook () {
		this.entries = new Entry[100];
		this.noe = 0;
	}
	
	public Entry[] getEntries() {
		Entry[] es = new Entry[this.noe];
		for(int i = 0; i < noe; i++) {
			es[i] = entries [i];
		}
		return es;
	}
	
	public int getNumberOfEntries() {
		return this.noe;
	}
	
	public Birthday getBirthday(String name) {
		
		int i = indexOf(name);
		
		if(i < 0) {
			return null;
		}
		
		else {
			Birthday bd = entries[i].getBirthday();
			return bd;
		}
	}
	
	public String[] getReminders(Birthday bd) {
		
		int numberOfReminders = 0;
		
		for (int i = 0; i < this.noe; i++) {
			if (bd.equals(entries[i].getBirthday())) {
				numberOfReminders++;
			}
		}
		
		String[] reminders = new String[numberOfReminders];
		
		int j = 0;
		for (int i = 0; i < this.noe; i++) {
			if(bd.equals(entries[i].getBirthday())) {
				reminders[j] = this.entries[i].getName();
				j++;
			}
		}
		return reminders;
	}
	
	public String[] getReminders(int m, int d) {
		Birthday bd = new Birthday (m, d);
		String[] reminders = getReminders(bd);
		return reminders;
	}
	
	public void removeEntry(String name) {
		int index = indexOf(name);
		
		if (index >= 0) {
			for (int j = index; j < this.noe - 1; j++) {
				entries[j] = entries[j+1];
			}
			
			this.entries[this.noe - 1] = null;
			this.noe--;
		}
	}
	
	public void addEntry (String name, Birthday bd) {
		
		int index = indexOf(name);

		if(index < 0) {
			Entry e = new Entry(name, bd);
			this.entries[this.noe] = e;
			this.noe++;
		}
		else {
			Entry e = new Entry(name, bd);
			this.entries[index] = e;
		}
	}
	
	public void addEntry(String name, int m, int d) {
		
		Birthday bd = new Birthday(m,d);
		addEntry(name, bd);
		
	}
	
	public int indexOf(String name) {
		
		int index = -1;
		boolean found = false;
		
		for(int i = 0; i < this.noe && !found; i++) {
			if(name.equals(entries[i].getName())) {
				index = i;
				found = true;
			}
		}
		return index;
		
	}
	
	public boolean nameExists(String name) {
		int i = indexOf(name);
		return i >= 0;
	}
	
	@Override
	public String toString() {
		
		String m = "There are " + this.getNumberOfEntries() + " entries in the book \n";
		String m2 = "";
		for(int i = 0; i < this.noe; i++) {
			m2 += entries[i].toString() + "\n";
		}
		return m + m2;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) { return false; }
		BirthdayBook other = (BirthdayBook) obj;
		
		boolean equal = this.getNumberOfEntries() == other.getNumberOfEntries();
		
		for (int i = 0; i < this.noe & equal; i++) {
			if(this.entries[i].equals(other.entries[i])) {
				equal = true;
			}
			else {
				equal = false;
			}
		}
		
		return equal;
	}
	
}
