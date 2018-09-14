import java.util.ArrayList;

public class ShortestSeekFirst extends Scheduler {
	private int time;
	private int cylinder;
	private int totalDelay;
	private int maxDelay;
	private double totalScore;
	private double maxScore;
	
	public ShortestSeekFirst(){
		time = 0;
		cylinder = 50;
		totalDelay = 0;
		maxDelay = 0;
		maxScore = 0;
	}
	
	public int getTime (){
		return time;
	}
	public int getTotalDelay(){
		return this.totalDelay;
	}
	
	public double getTotalScore(){
		return this.totalScore;
	}
	
	//Stimulates the action of the Shortest Seek First.
	
	public void routin(ArrayList<seqReq> list){
		if (list.size() >= 5){
			while(list.size() >= 5){
				int shortestSeekCylinderIndex = 0;
				int shortestDistance = Math.abs(this.cylinder - list.get(0).getCylinder());
				for (int i = 1; i < list.size(); i++){
					int tempShortestDistance = Math.abs(this.cylinder - list.get(i).getCylinder());
					if (shortestDistance > tempShortestDistance){
						shortestDistance = tempShortestDistance;
						shortestSeekCylinderIndex = i;
						
					}
				}
				this.time += shortestDistance;
				list.get(shortestSeekCylinderIndex).setEndTime(this.time);
				this.cylinder = list.get(shortestSeekCylinderIndex).getCylinder();
				this.totalDelay += list.get(shortestSeekCylinderIndex).delay();
				if (this.maxDelay < list.get(shortestSeekCylinderIndex).delay())
					this.maxDelay = list.get(shortestSeekCylinderIndex).delay();
				this.totalScore += list.get(shortestSeekCylinderIndex).score();
				if (this.maxScore < list.get(shortestSeekCylinderIndex).score())
					this.maxScore = list.get(shortestSeekCylinderIndex).score();
				list.remove(shortestSeekCylinderIndex);
			}
		} else {
			while(list.size() > 0){
				int shortestSeekCylinderIndex = 0;
				int shortestDistance = Math.abs(this.cylinder - list.get(0).getCylinder());
				for (int i = 1; i < list.size(); i++){
					int tempShortestDistance = Math.abs(this.cylinder - list.get(i).getCylinder());
					if (shortestDistance > tempShortestDistance){
						shortestDistance = tempShortestDistance;
						shortestSeekCylinderIndex = i;
						
					}
				}
				this.time += shortestDistance;
				list.get(shortestSeekCylinderIndex).setEndTime(this.time);
				this.cylinder = list.get(shortestSeekCylinderIndex).getCylinder();
				this.totalDelay += list.get(shortestSeekCylinderIndex).delay();
				if (this.maxDelay < list.get(shortestSeekCylinderIndex).delay())
					this.maxDelay = list.get(shortestSeekCylinderIndex).delay();
				this.totalScore += list.get(shortestSeekCylinderIndex).score();
				if (this.maxScore < list.get(shortestSeekCylinderIndex).score())
					this.maxScore = list.get(shortestSeekCylinderIndex).score();
				list.remove(shortestSeekCylinderIndex);
			}
		}	
	}
	
	//Get the average delay
	public double averageDelay(int masterList[]){
		return (double) this.totalDelay / masterList.length;
	}
	
	//Get the maximum delay
	public int getMaxDelay (){
		return this.maxDelay;
	}
	
	//Get the average score
	public double averageScore(int masterList[]){
		return this.totalScore / masterList.length;
	}
	
	//Get the maximum score
	public double getMaxScore(){
		return this.maxScore;
	}
}
