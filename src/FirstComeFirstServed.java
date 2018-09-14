
public class FirstComeFirstServed extends Scheduler {
	private int time;
	private int totalDelay;
	private int maxDelay;
	private double totalScore;
	private double maxScore;
	
	public FirstComeFirstServed(){
		time = 0;
		totalDelay = 0;
		maxDelay = 0;
		maxScore = 0;
	}
	
	public int getTotalDelay(){
		return this.totalDelay;
	}
	
	public double getTotalScore(){
		return this.totalScore;
	}
	//This method does scheduling work and returns the running sum.
	public int runningSum (int masterList[], int cylinder){
		int runningSum = 0;
		int nextCylinder = 0;
		for (int i = 0; i < masterList.length; i++){
			nextCylinder = masterList[i];
			masterList[i] = 0;
			runningSum += Math.abs(cylinder - nextCylinder);
			this.time = runningSum;
			this.totalDelay += this.time;
			this.totalScore += (this.time * Math.sqrt(this.time)); 
			cylinder = nextCylinder;
		}
		return runningSum;
	}
	
	//Get the maximum delay
	public int getMaxDelay(){
		maxDelay = this.time;
		return maxDelay;
	}
	
	//Get the maximum Score
	public double getMaxScore(){
		maxScore = (this.time * Math.sqrt(this.time));
		return maxScore;
	}
}
