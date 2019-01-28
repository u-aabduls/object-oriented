/* 
 * READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * Your Tasks: Override 'equals' method of this class.
 */

public class DepartmentInfo {
	private String name;
	private String location;

	/**
	 * @param name     the name to set
	 * @param location the location to set
	 */
	public DepartmentInfo(String name, String location) {
		this.name = name;
		this.location = location;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Two DepartmentInfo objects are equal if their name and location are equal.
	 * 
	 * @return Whether this DepartmentInfo object equals 'obj'
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		DepartmentInfo other = (DepartmentInfo) obj;

		boolean isEqual = this.getName().equals(other.getName()) && this.getLocation().equals(other.getLocation());
		return isEqual;
	}
}
