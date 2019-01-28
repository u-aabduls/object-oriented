
public class Birthday {
	
	private int month;
	private int day;
	
	public Birthday (int m, int d) {
		
		if(m < 1 || m > 12 || d < 1 || d > 31) {
			throw new IllegalArgumentException();
		}
		
		else {
			this.month = m;
			this.day = d;
		}
		
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public String toString() {
		
		String m = "";
		
		if(this.month == 1) {
			m = "January";
		}
		else if(this.month == 2) {
			m = "February";
		}
		else if(this.month == 3) {
			m = "March";
		}
		else if(this.month == 4) {
			m = "April";
		}
		else if(this.month == 5) {
			m = "May";
		}
		else if(this.month == 6) {
			m = "June";
		}
		else if(this.month == 7) {
			m = "July";
		}
		else if(this.month == 8) {
			m = "August";
		}
		else if(this.month == 9) {
			m = "September";
		}
		else if(this.month == 10) {
			m = "October";
		}
		else if(this.month == 11) {
			m = "November";
		}
		else if(this.month == 12) {
			m = "December";
		}
		
		return m + " " + this.day;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) { return true; }
		if(obj == null || this.getClass() != obj.getClass()) { return false; }
		Birthday other = (Birthday) obj;
		
		return this.getMonth() == other.getMonth() && this.getDay() == other.getDay();
	}

}
