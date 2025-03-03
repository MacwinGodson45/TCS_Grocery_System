package com.project;
import java.util.*;
public class MockPra3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Train[] tr = new Train[n];
		for(int i=0; i<n; i++) {
			int id = scan.nextInt(); scan.nextLine();
			String source = scan.nextLine();
			String destination = scan.nextLine();
			double fare = scan.nextDouble(); scan.nextLine();
			tr[i] = new Train(id, source, destination, fare);
		}
		String searchSource = scan.nextLine();
		String searchDestination = scan.nextLine();
		double fare1 = scan.nextDouble(); 
		
		if(searchSource.equals("null") || searchDestination.equals("null")) {
			System.out.println("Source/destination can't be null");
			return;
		}
		
		if(fare1 <= 0) {
			System.out.println("Fare can't be negative");
			return;
		}
		else {
			double ans1 = totalFareBySourceAndFare(tr, searchSource, fare1);
			if(ans1 > 1500) {
				System.out.println("Total Fare:"+ans1);
			}
			else if(ans1 <= 1500 && ans1 >= 1) {
				ans1 = ans1 - (ans1 * 0.1);
				System.out.println("Total Fare(post deduct):"+ans1);
			}
			else {
				System.out.println("No Train found for the mentioned parameters");
			}
			
			ArrayList<Train> ans2 = searchTrainByFareAndDestination(tr, fare1, searchDestination);
			if(ans2.size() == 0) {
				System.out.println("No Train found with mentioned Fare and Destination");
			}
			else {
				for(Train obj : ans2) {
					System.out.println("TrainID:"+obj.getTrainId());
					System.out.println("Source:"+obj.getSource());
					System.out.println("Destination:"+obj.getDestination());
					System.out.println("Fare:"+obj.getFare());
				}
			}
		}

	}
	
	public static double totalFareBySourceAndFare(Train[] tr, String source, double fare) {
		double res = 0.0;
		for(Train obj : tr) {
			if(obj.getSource().equalsIgnoreCase(source) && obj.getFare() > fare) {
				res += obj.getFare();
			}
		}
		return res;
	}
	
	public static ArrayList<Train> searchTrainByFareAndDestination(Train[] tr, double fare, String dest){
		ArrayList<Train> list = new ArrayList<>();
		for(Train obj : tr) {
			if(obj.getDestination().equalsIgnoreCase(dest) && obj.getFare() < fare) {
				list.add(obj);
			}
		}
		return list;
	}
}

class Train{
	private int trainId;
	private String source;
	private String destination;
	private double fare;
	
	public Train(int id, String source, String dest, double fare) {
		this.trainId = id;
		this.source = source;
		this.destination = dest;
		this.fare = fare;
	}

	public int getTrainId() {
		return this.trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return this.fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
}