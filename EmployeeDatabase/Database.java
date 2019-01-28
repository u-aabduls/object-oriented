import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* READ THE PDF INSTRUCTION BEFORE GETTING STARTED!
 * 
 * Resources:
 * 	- Tutorial Series on Java Collections (ArrayList and HashMap):
 * 		https://www.eecs.yorku.ca/~jackie/teaching/tutorials/index.html#java_collections
 *	- Recording of lecture on implementing compareTo and using Arrays.sort(...):
 *		https://youtu.be/mDpDRLEy-7Y
 */

public class Database {
	/*
	 * Each entry in a 'departments' map contains a unique department id and its
	 * associated information object.
	 */
	HashMap<Integer, DepartmentInfo> departments;

	/*
	 * Each entry in a 'employees' map contains a unique employee id and its
	 * associated information object.
	 */
	HashMap<String, EmployeeInfo> employees;

	/**
	 * Initialize an empty database.
	 */
	public Database() {
		this.departments = new HashMap<Integer, DepartmentInfo>();
		this.employees = new HashMap<String, EmployeeInfo>();
	}

	/**
	 * Add a new employee entry.
	 * 
	 * @param id   id of the new employee
	 * @param info information object of the new employee
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing employee id
	 */
	public void addEmployee(String id, EmployeeInfo info) throws IdAlreadyExistsExceptoin {
		boolean exists = this.employees.containsKey(id);
		if (exists) {
			throw new IdAlreadyExistsExceptoin(id);
		} else {
			this.employees.put(id, info);
		}
	}

	/**
	 * Remove an existing employee entry.
	 * 
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeEmployee(String id) throws IdNotFoundException {
		boolean exists = this.employees.containsKey(id);
		if (!exists) {
			throw new IdNotFoundException(id);
		} else {
			this.employees.remove(id);
		}
	}

	/**
	 * Add a new department entry.
	 * 
	 * @param id   id of the new department
	 * @param info information object of the new department
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing department id
	 */
	public void addDepartment(Integer id, DepartmentInfo info) throws IdAlreadyExistsExceptoin {
		boolean exists = this.departments.containsKey(id);
		if (exists) {
			String fail = "fail";
			throw new IdAlreadyExistsExceptoin(fail);
		} else {
			this.departments.put(id, info);
		}

	}

	/**
	 * Remove an existing department entry.
	 * 
	 * @param id id of some employee
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public void removeDepartment(Integer id) throws IdNotFoundException {
		boolean exists = this.departments.containsKey(id);
		if (!exists) {
			String fail = "fail";
			throw new IdNotFoundException(fail);
		} else {
			this.departments.remove(id);
		}
	}

	/**
	 * Change the department of employee with id 'eid' to a new department with id
	 * 'did'.
	 * 
	 * You can assume that 'did' denotes a department different from the current
	 * department of the employee denoted by 'eid'.
	 * 
	 * @param eid id of some employee
	 * @param did id of some department
	 * @throws IdNotFoundException if either eid is a non-existing employee id or
	 *                             did is a non-existing department id.
	 */
	public void changeDepartment(String eid, Integer did) throws IdNotFoundException {
		boolean eIDExists = this.employees.containsKey(eid);
		boolean dIDExists = this.departments.containsKey(did);

		if (!eIDExists || !dIDExists) {
			throw new IdNotFoundException(eid);
		} else {
			EmployeeInfo ei = this.employees.get(eid);
			ei.setDepartmentId(did);
		}
	}

	/**
	 * Retrieve the name of employee with id 'id'.
	 * 
	 * @param id id of some employee
	 * @return name of the employee with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public String getEmployeeName(String id) throws IdNotFoundException {
		boolean exists = this.employees.containsKey(id);
		String name = "";
		if (!exists) {
			throw new IdNotFoundException(id);
		} else {
			EmployeeInfo ei = this.employees.get(id);
			name = ei.getName();
		}
		return name;
	}

	/**
	 * Retrieve the names of all employees of the department with id 'id'. If 'id' a
	 * non-existing department id, then return an empty list.
	 * 
	 * @param id id of some department
	 * @return List of names of employees whose home department has id 'id'
	 */
	public ArrayList<String> getEmployeeNames(Integer id) {

		ArrayList<String> employeeNames = new ArrayList<String>();
		for (String name : this.employees.keySet()) {
			if (this.employees.get(name).getDepartmentId().equals(id)) {
				EmployeeInfo ei = this.employees.get(name);
				String eName = ei.getName();
				employeeNames.add(eName);
			}
		}
		return employeeNames;
	}

	/**
	 * Retrieve an employee's department's information object.
	 * 
	 * @param id id of some existing employee
	 * @return The information object of the employee's home department
	 * @throws IdNotFoundException if 'id' is not an existing employee id
	 */
	public DepartmentInfo getDepartmentInfo(String id) throws IdNotFoundException {
		boolean exists = this.employees.containsKey(id);
		if (!exists) {
			throw new IdNotFoundException(id);
		} else {
			Integer dID = this.employees.get(id).getDepartmentId();
			DepartmentInfo di = this.departments.get(dID);
			return di;
		}
	}

	/**
	 * Retrieve a list, sorted in increasing order, the information objects of all
	 * stored employees.
	 * 
	 * Hints: 1. Override the 'compareTo' method in EmployeeInfo class. 2. Look up
	 * the Arrays.sort method in Java API.
	 * 
	 * @return A sorted list of information objects of all employees.
	 */
	public EmployeeInfo[] getSortedEmployeeInfo() {
		EmployeeInfo[] ei = new EmployeeInfo[this.employees.size()];
		int i = 0;
		for (String name : this.employees.keySet()) {
			ei[i] = this.employees.get(name);
			i++;
		}
		Arrays.sort(ei);
		return ei;
	}

	/**
	 * Retrieve the average salary of all employees in department with id 'id'.
	 * 
	 * @param id id of some department
	 * @return average salary of all employees in department with id 'id'
	 * @throws IdNotFoundException if id is not an existing department id
	 */
	public double getAverageSalary(Integer id) throws IdNotFoundException {
		boolean exists = this.departments.containsKey(id);
		double sum = 0.0;
		int counter = 0;
		if (!exists) {
			String fail = "fail";
			throw new IdNotFoundException(fail);
		} else {
			for (String name : this.employees.keySet()) {
				EmployeeInfo ei = this.employees.get(name);
				if (ei.getDepartmentId().equals(id)) {
					sum += ei.getSalary();
					counter++;
				}
			}
		}
		double averageSalary = sum / counter;
		return averageSalary;
	}

	/**
	 * Retrieve the information object of the department with the highest average
	 * salary among its employees.
	 * 
	 * @return the information object of the department with the highest average
	 *         salary among its employees
	 * 
	 *         Hint: Use 'getAverageSalary(Integer id)' as a helper method.
	 */
	public DepartmentInfo getDepartmentOfHighestAverageSalary() {
		double[] avgSalaries = new double[this.departments.size()];
		for (Integer key : this.departments.keySet()) {
			for (int i = 0; i < this.departments.size(); i++) {
				DepartmentInfo di = this.departments.get(key);
				try {
					avgSalaries[i] = getAverageSalary(key);
				} catch (IdNotFoundException e) {
					String f = "fail";
				}
			}
		}
		double highestAVG = avgSalaries[0];
		for (int i = 1; i < avgSalaries.length; i++) {
			if (avgSalaries[i] > highestAVG) {
				highestAVG = avgSalaries[i];
			}
		}
		DepartmentInfo highest = null;
		for (Integer key : this.departments.keySet()) {
			DepartmentInfo di = this.departments.get(key);
			try {
				if (getAverageSalary(key) == highestAVG) {
					highest = this.departments.get(key);
				}
			} catch (IdNotFoundException e) {
				String f = "fail";
			}
		}
		return highest;
	}
}
