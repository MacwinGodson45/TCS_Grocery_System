package com.project;
import java.util.*;
public class MockPra1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n > 0) {
			Kitchenware[] kitchen = new Kitchenware[n];
			for(int i=0; i<n; i++) {
				int id = scan.nextInt(); scan.nextLine();
				String name = scan.nextLine();
				String category = scan.nextLine();
				double price = scan.nextDouble(); scan.nextLine();
				kitchen[i] = new Kitchenware(id, name, category, price);
			}
			
			String searchCategory = scan.nextLine();
			double lowerLimit = scan.nextDouble();
			double upperLimit = scan.nextDouble();
			double ans1 = findMaxPriceByCategory(kitchen, searchCategory);
			if(ans1 > 0) {
				System.out.println("Max Price: "+ans1);
			}
			else {
				System.out.println("No Kitchenware found with the mentioned category.");
			}
			
			ArrayList<Kitchenware> ans2 = findMaxPricedByCategory(kitchen, lowerLimit, upperLimit);
			if(ans2.size() > 0) {
				for(Kitchenware obj : ans2) {
					System.out.println("ID-"+obj.getId());
					System.out.println("Name-"+obj.getName());
					System.out.println("Category-"+obj.getCategory());
					System.out.println("Price-"+obj.getPrice());
				}
			}
			else {
				System.out.println("No Kitchenware found within the given range.");
			}
		}
		else {
			System.out.println("Size should be positive.");
		}

	}
	
	public static double findMaxPriceByCategory(Kitchenware[] kitchen, String category) {
		double max = 0.0;
		for(Kitchenware obj: kitchen) {
			if(obj.getPrice() > max && obj.getCategory().toLowerCase().equalsIgnoreCase(category)) {
				max = obj.getPrice();
			}
		}
		return max;
	}
	
	public static ArrayList<Kitchenware> findMaxPricedByCategory(Kitchenware[] kitchen, double s1, double s2) {
		ArrayList<Kitchenware> list = new ArrayList<>();
		for(Kitchenware obj:kitchen) {
			if(obj.getPrice() >= s1 && obj.getPrice() <= s2) {
				list.add(obj);
			}
		}
		return list;
	}
}

class Kitchenware{
	
	private int id;
	private String name;
	private String category;
	private double price;
	
	public Kitchenware(int id, String name, String category, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}