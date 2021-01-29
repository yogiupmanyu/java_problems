import java.util.ArrayList;

public class FootballPlayer40YardDashInfo {
	
	ArrayList<FootballPlayer> players = new ArrayList<FootballPlayer>();
	
	public void addFootballPlayer(FootballPlayer player){
		
		players.add(player);
		
	}
	
	// This method is the focus of the extract method tutorial
	
	public void printPlayerInfo(){
		
		double avg40YdTime = 0.0;
		
		// Prints the titles
		
		printTitles();
		
		/* Print titles
		
		System.out.printf("%-15s %15s", "Name", "Avg 40 Time\n");
		
		// Print dashes under titles
		
		for(int i = 0; i < 30; i++){ System.out.print("_"); }
		
		System.out.println();
		
		*/
		
		printPlayersWith40Avg();
		
		/* Cycle through all the players
		
		for(FootballPlayer player : players){
		
			System.out.printf("%-19s", player.getName());
			
			double total40YdDashTimes = 0.0;
			
			double[] fortyYardDashTimes = player.get40YardDashTimes();
			
			for(int i = 0; i < player.get40YardDashTimes().length; i++){
				
				total40YdDashTimes += fortyYardDashTimes[i];
				
			}
			
			avg40YdTime = total40YdDashTimes / player.get40YardDashTimes().length;
			
			System.out.printf("%1$.2f", avg40YdTime);
			
			System.out.println();
				
		} */
		
	}
	
	public void printTitles(){
		
		System.out.printf("%-15s %15s", "Name", "Avg 40 Time\n");
		
		printDashes('_', 30);
		
	}
	
	public void printDashes(char charToPrint, int howManyTimes){
		
		for(int i = 0; i < howManyTimes; i++){ System.out.print(charToPrint); }
		
		System.out.println();
		
	}
	
	public void printPlayersWith40Avg(){
		
		for(FootballPlayer player : players){
			
			System.out.printf("%-19s", player.getName());
			
			double total40YdDashTimes = 0.0;
			
			double[] fortyYardDashTimes = player.get40YardDashTimes();
			
			for(int i = 0; i < player.get40YardDashTimes().length; i++){
				
				total40YdDashTimes += fortyYardDashTimes[i];
				
			}
			
			double avg40YdTime = total40YdDashTimes / player.get40YardDashTimes().length;
			
			System.out.printf("%1$.2f", avg40YdTime);
			
			// If the code is as clear as a method name use the code instead
			// Remove the method call here
			
			// String inTop15 = checkIfInTop15(avg40YdTime) ? " *Top 15\n" : "\n";
			
			// Replace it with
			
			String inTop15 = (avg40YdTime < 4.41) ? " *Top 15\n" : "\n";
			
			System.out.print(inTop15);
				
		}
		
		// Know when temps are getting in the way
		// To get rid of a temp
		// 1. Declare it as final to make sure it is declared only once
		// 2. Replace the right side with the temp name
		
		double dashTime = 4.50;
					
		double avg40YdDash = getAvgDashTime();
					
		String dashGrade = ((dashTime <= avg40YdDash) ? "Good" : "Bad");
					
		System.out.print("That was a " + dashGrade + " time");
		
	}
	
	// This method shouldn't have been extracted because it didn't 
	// make the code more understandable
	
	public boolean checkIfInTop15(double avg40YdTime){
		
		return avg40YdTime < 4.41;
		
	}
	
	public static void main(String[] args){
		
		FootballPlayer40YardDashInfo fb40Dash = new FootballPlayer40YardDashInfo();
		
		// Add Clark Kent for example
		
		double cKent40YdDashTimes[] = {4.36, 4.39, 4.41};
		FootballPlayer clarkKent = new FootballPlayer("Clark Kent", cKent40YdDashTimes);
		fb40Dash.addFootballPlayer(clarkKent);
		
		// Add Bruce Wayne for example
		
		double bWayne40YdDashTimes[] = {4.42, 4.43, 4.49};
		FootballPlayer bruceWayne = new FootballPlayer("Bruce Wayne", bWayne40YdDashTimes);
		fb40Dash.addFootballPlayer(bruceWayne);
		
		fb40Dash.printPlayerInfo();
		
	}
	
	public static double getAvgDashTime(double[] dashTimes){
		
		double totalDashTimes = 0.0;
		
		for(int i = 0; i < dashTimes.length; i++){
			totalDashTimes += dashTimes[i];
		}
		return totalDashTimes / dashTimes.length;
		
	}
	
	public static double getAvgDashTime(){
		
		return 4.41;
		
	}

}

// Working with local variables
/*
double average 0.0;

double[] dashTimes = {4.36, 4.39, 4.41};

double totalDashTimes = 0.0;

for(int i = 0; i < dashTimes.length; i++){
	totalDashTimes += dashTimes[i];
}
average = totalDashTimes / numOfTimes.length;
*/

/* Replaced by

double[] dashTimes = {4.36, 4.39, 4.41};

double average = getAvgDashTime(dashTimes);

public static double getAvgDashTime(double[] dashTimes){
		
		double totalDashTimes = 0.0;
		
		for(int i = 0; i < dashTimes.length; i++){
			totalDashTimes += dashTimes[i];
		}
		return totalDashTimes / dashTimes.length;
		
	}

*/

/* Replacing a temp with a Query

double avgDashTime = totalDashTimes / totalDashes;

if(avgDashTime > 4.41) {
	System.out.println("Average Time");
}

// Better Solution

if(avgDashTime() > 4.41) {
	System.out.println("Average Time");
}

double avgDashTime(){

	return totalDashTimes / totalDashes;

}

 */