package edu.nyu.cs9053.homework2;

public class Program {
	public static void main(String[] args) {
		//There should be at least 2 args
		if (args == null || args.length < 2) {
			System.out.println("Invalid argument");
			return;
		}
		
		try {
			if (args[0].equals("gps")) {
				//Generate the series of point values
				Gps[] gpsPoints = new Gps[args.length - 1];
				for (int i = 1; i < args.length; i++) {
					//If the args[i] can't be converted to double, the catch statement will handle this 
					double latitude = Double.parseDouble(args[i].split(",")[0]);
					double longitude = Double.parseDouble(args[i].split(",")[1]);
					if (latitude > 180.00000d || latitude < -180.00000d || longitude > 180.00000d || longitude < -180.00000d) {
						System.out.println("Invalid argument");
						return;
					}
					
					//use (i - 1), because args[0] is the gps and data starts from args[1]
					gpsPoints[i - 1] = new Gps(latitude, longitude);
				}
				
				PolylineEncoder instance = new PolylineEncoder();
				System.out.println(instance.encodePolyline(gpsPoints));
				
			} else if (args[0].equals("mortgage") && args.length == 4) {
				//Make sure to use String.equals to compare strings
				double loanAmount = Double.parseDouble(args[1]);
				double annualInterestRateInPercent = Double.parseDouble(args[2]);
				int years = Integer.parseInt(args[3]);
				
				MortgageCalculator instance = new MortgageCalculator();
				System.out.println(instance.computeMonthlyPaymentOnFixedLoan(loanAmount, annualInterestRateInPercent, years));
			} else {
				System.out.println("Invalid argument");
				return;
			}	
		} catch (Exception e) {
			System.out.println("Invalid argument");
		} 

	}
	
}
