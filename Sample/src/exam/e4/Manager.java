package exam.e4;

public class Manager extends Employee {
	private long bonus;

	public Manager(int empno, String name, long bonus, long salary) {
		super(empno, name, salary);
		this.bonus = bonus;
	}
	
	@Override //在子類別打getSalary
	public long getSalary() {
		return super.getSalary() + this.bonus;
	}
	
	public long getBonus() {
		return bonus;
	}

	public void setBonus(long bonus) {
		this.bonus = bonus;
	};

	
}
