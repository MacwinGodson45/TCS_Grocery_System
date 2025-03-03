package com.project;
import java.util.*;
public class MockPra2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n > 0) {
			Mobile[] mb = new Mobile[n];
			for(int i=0; i<n; i++) {
				int id = scan.nextInt(); scan.nextLine();
				String brand = scan.nextLine();
				double ram = scan.nextDouble();
				double price = scan.nextDouble(); scan.nextLine();
				mb[i] = new Mobile(id, brand, ram, price);
			}
			String searchBrand = scan.nextLine();
			double searchRam = scan.nextDouble();
			
			double ans1 = averageOfPriceWithBrand(mb, searchBrand);
			if(ans1 > 0) {
				System.out.println("Average Price:"+ans1);
			}
			else {
				System.out.println("No Mobile found with mentioned Brand");
			}
			
			ArrayList<Mobile> ans2 = searchMobilesWithRamAndBrand(mb, searchRam, searchBrand);
			if(ans2.size() > 0) {
				for(Mobile obj : ans2) {
					System.out.println("IMEI ID:"+obj.getImeiId());
					System.out.println("Brand:"+obj.getBrand());
					System.out.println("RAM:"+obj.getRam());
					System.out.println("Price:"+obj.getPrice());
				}
			}
			else {
				System.out.println("No Mobile found for the mentioned parameters");
			}
		}
		else {
			System.out.println("Size should be a positive number");
		}
	}
	
	public static double averageOfPriceWithBrand(Mobile[] mb, String search) {
		double total = 0.0;
		int count = 0;
		for(Mobile obj : mb) {
			if(obj.getBrand().toLowerCase().equalsIgnoreCase(search)) {
				total += obj.getPrice();
				count++;
			}
		}
		double avg = total / count;
		return avg;
	}
	
	public static ArrayList<Mobile> searchMobilesWithRamAndBrand(Mobile[] mb, double ram, String brand){
		ArrayList<Mobile> list = new ArrayList<>();
		for(Mobile obj : mb) {
			if(obj.getRam() > ram && !(obj.getBrand().toLowerCase().equalsIgnoreCase(brand.toLowerCase()))) {
				list.add(obj);
			}
		}
		return list;
	}
}

class Mobile{
	private int imeiId;
	private String brand;
	private double ram;
	private double price;
	
	public Mobile(int id, String brand, double ram, double price) {
		this.imeiId = id;
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}

	public int getImeiId() {
		return this.imeiId;
	}

	public void setImeiId(int imeiId) {
		this.imeiId = imeiId;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getRam() {
		return this.ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}