package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		System.out.print("Enter department's name: "); //Design
		String department = sc.nextLine(); 
		Department dep = new Department(department);
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");//Alex
		String name = sc.nextLine(); 
		System.out.print("Level: ");//MID_LEVEL
		String level = sc.nextLine(); 
		System.out.print("Base salary: "); //1200.00
		Double baseSalary = sc.nextDouble(); 
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, dep);
		//System.out.println(worker);
		
		System.out.print("How many contracts to this worker? "); //3
		int n = sc.nextInt(); 
		for(int i = 0; i < n;i++) {
			System.out.printf("Enter contract #%d data: \n", (i + 1));
			System.out.print("Date (DD/MM/YYYY): "); //20/08/2018
			Date data = sdf.parse(sc.next());
			System.out.print("Value per hour: ");//50.00
			Double valuePerHour = sc.nextDouble(); 
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt(); //20
			HourContract contract = new HourContract(data, valuePerHour, hours); 
			worker.addContract(contract);
		}
		sc.nextLine();
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");//08/2018
		String income = sc.nextLine(); 
		int month = Integer.parseInt(income.substring(0, 2));
		int year = Integer.parseInt(income.substring(3));
		
		System.out.println("Name: " +worker.getName()); //Alex
		System.out.println("Department: " +department); //Design
		System.out.println("Income for " +income + ": " +String.format("%.2f", worker.income(month, year))); //08/2018: 3000.00
		System.out.println(worker);
		sc.close();
	}
}
