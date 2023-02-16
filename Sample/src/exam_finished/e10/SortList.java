package exam_finished.e10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import exam.e6.People;

public class SortList {
	public static void main(String[] args) {
		Employee e1 = new Employee("001", 10000, 300);
		Employee e2 = new Employee("002", 10000, 200);
		Employee e3 = new Employee("003", 20000, 200);
		Employee e4 = new Employee("004", 30000, 200);

		List<Employee> list = Arrays.asList(e1, e2, e3, e4);
		// 請利用List中的sort方法重新排序e1..e4，排序時薪水(salary)大的排前面，如果薪水一樣則commission小的排前面
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee p1, Employee p2) {
				if (p1.getSalary() < p2.getSalary()) {

					return 1;

				} else if (p2.getSalary() < p1.getSalary()) {

					return -1;

				} else {

					if (p1.getCommission() < p2.getCommission()) {

						return -1;

					} else if (p1.getCommission() < p2.getCommission()) {

						return 1;

					}
				}
				return 0;

			};

		});
		System.out.println(list);
	}
}
