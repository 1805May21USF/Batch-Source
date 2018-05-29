package homework1;

import java.util.Comparator;


public class Employee implements Comparable<Employee>{

	 private String name;
	 private String department;
	 private int age;
	 
	 public static final Comparator<Employee> AgeComparator = new Comparator<Employee>(){

	        @Override
	        public int compare(Employee o1, Employee o2) {
	            return o1.age - o2.age;  // This will work because age is positive integer
	        }
	      
	    };
	    
	    public static final Comparator<Employee> NameComparator = new Comparator<Employee>(){

	        @Override
	        public int compare(Employee o1, Employee o2) {
	            return o1.name.compareTo(o2.name);
	        }
	      
	    };
	    
	    public static final Comparator<Employee> DepartmentComparator = new Comparator<Employee>(){

	        @Override
	        public int compare(Employee o1, Employee o2) {
	            return o1.department.compareTo(o2.department);
	        }
	      
	    };
	    
	
	 public Employee(String name, String department, int age) {
		// TODO Auto-generated constructor stub
		 this.name = name;
		 this.department = department;
		 this.age = age;
		 
	}
	 @Override
	    public String toString() {
	        return "Employee{" + "department=" + department + ", name=" + name  + ", age=" + age + '}';

	    }

	    @Override
	    public int compareTo(Employee o) {
	        return this.age - o.age;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Employee other = (Employee) obj;
	        if ((this.department == null) ? (other.department != null) : !this.department.equals(other.department)) {
	            return false;
	        }
	        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
	            return false;
	        }
	      
	        if (this.age != other.age) {
	            return false;
	        }
	        
	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 47 * hash + (this.department != null ? this.department.hashCode() : 0);
	        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
	        
	        hash = 47 * hash + this.age;
	        
	        return hash;
	    }

	}
