package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i +  1) + " data:");
			
			System.out.print("Individual or Company (i/c)? ");
			char ic = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Annual Income: ");
			double annualIncome = sc.nextDouble();
			
			if(ic == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new Individual(name, annualIncome, healthExpenditures));
				
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				list.add(new Company(name, annualIncome, numberOfEmployees));
			}	
			
		}
		
		System.out.println();
		for (TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $" + tp.tax());
		}
		System.out.println();
		double sum = 0;
		for (TaxPayer tp : list) {
			sum += tp.tax();
		}
		System.out.println("Total Taxes: " + sum);
		
		sc.close();
	}

}
