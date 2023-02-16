package equals;

import java.util.Objects;

public class Employee {
	
	private String id;

	public Employee(String id) {
		this.id = id;
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(id, other.id);
	}
	*/
	//source / Generate HashCode and equals
	
	
	
	@Override
	public boolean equals(Object obj) {
		//因為參數型態是Object,可以是任何物件，例如Car,這種比較就沒有意義
		//用instanceof 去過濾
		if (obj instanceof Employee) {
			Employee emp = (Employee) obj;//ctrl +1強制轉型
			boolean isEqual = this.id.equals(emp.id);
			//boolean isEqual = this.id.equals(emp.id) && this.name.equals(emp.name);
			return isEqual;
		}
		return false;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Employee GC!!!");
	}
	
	
	@Override
	public String toString() {
		return String.format("Employee(%s)", this.id);
	}
}
