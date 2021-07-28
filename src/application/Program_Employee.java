package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program_Employee {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>(); 
		
		System.out.print("How many employees will be registered? ");
		int qtd = sc.nextInt();
		
		for(int i = 0; i<qtd; i++) {
			System.out.println();
			System.out.println("Employee #"+(i+1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			while(hasId(list, id)){
				System.out.println("Id already taken! Try again");
				id = sc.nextInt();
			}
			System.out.print("name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			
			/*Employee emp = new Employee(id, name, salary);
			list.add(emp); outra forma de instanciar um empregado*/	
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary= sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if(emp != null) {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.salaryIncrease(percentage);
		}else {
			System.out.println("This id dows not exist!");
		}
		System.out.println();
		System.out.println("List of employees:");
		for(Employee e : list) {
			System.out.println(e.toString());
		}
		
		sc.close();
	}
	/*public static Integer position(List<Employee> list, int id) {
		for (int i =0; i <list.size(); i++) {
			if(list.get(i).getId()==id) {
				return i;
			}
		}
		return null;
	}*outra forma de procurar um empregado*/
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp !=null;
	}

}
