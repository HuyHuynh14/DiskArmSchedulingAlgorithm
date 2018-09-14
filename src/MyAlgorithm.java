import java.util.ArrayList;

public class MyAlgorithm extends Scheduler{
	private int time;
	private int cylinder;
	private int totalDelay;
	private int maxDelay;
	private double totalScore;
	private double maxScore;
	private boolean movingUp;
	
	public MyAlgorithm(){
		time = 0;
		cylinder = 50;
		totalDelay = 0;
		maxDelay = 0;
		maxScore = 0;
		movingUp = true;
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
			while (list.size() >= 5){
				int nextSeekCylinderIndex = -1;
				int shortestDistance = 999999999;
				int distance = 0;
				if (movingUp){
					for (int i = 0; i < list.size(); i++){
						distance = list.get(i).getCylinder() - this.cylinder;
						if (distance > 0 && shortestDistance > distance){
							shortestDistance = distance;
							nextSeekCylinderIndex = i;
						}
					}
					if (nextSeekCylinderIndex == -1){
						movingUp = false;
					} 
				} else {
					shortestDistance = 0;
					for (int i = 0; i < list.size(); i++){
						distance = this.cylinder - list.get(i).getCylinder();
						if (distance > 0 && shortestDistance < distance){
							shortestDistance = distance;
							nextSeekCylinderIndex = i;
							movingUp = true;
						}
					}
				}
				//Perform this code when we find a next seek cylinder
				if (nextSeekCylinderIndex != -1){
					this.time += shortestDistance;
					list.get(nextSeekCylinderIndex).setEndTime(this.time);
					this.cylinder = list.get(nextSeekCylinderIndex).getCylinder();
					this.totalDelay += list.get(nextSeekCylinderIndex).delay();
					if (this.maxDelay < list.get(nextSeekCylinderIndex).delay())
						this.maxDelay = list.get(nextSeekCylinderIndex).delay();
					this.totalScore += list.get(nextSeekCylinderIndex).score();
					if (this.maxScore < list.get(nextSeekCylinderIndex).score())
						this.maxScore = list.get(nextSeekCylinderIndex).score();
					list.remove(nextSeekCylinderIndex);
				}
			}
			
		} else {  //when the size of the list is less than 5.
			while (list.size() > 0){
				int nextSeekCylinderIndex = -1;
				int shortestDistance = 999999999;
				int distance = 0;
				if (movingUp){
					for (int i = 0; i < list.size(); i++){
						distance = list.get(i).getCylinder() - this.cylinder;
						if (distance > 0 && shortestDistance > distance){
							shortestDistance = distance;
							nextSeekCylinderIndex = i;
						}
					}
					if (nextSeekCylinderIndex == -1){
						movingUp = false;
					} 
				} else {
					shortestDistance = 0;
					for (int i = 0; i < list.size(); i++){
						distance = this.cylinder - list.get(i).getCylinder();
						if (distance > 0 && shortestDistance < distance){
							shortestDistance = distance;
							nextSeekCylinderIndex = i;
							movingUp = true;
						}
					}
					
				}
				//Perform this code when we find a next seek cylinder
				if (nextSeekCylinderIndex != -1){
					this.time += shortestDistance;
					list.get(nextSeekCylinderIndex).setEndTime(this.time);
					this.cylinder = list.get(nextSeekCylinderIndex).getCylinder();
					this.totalDelay += list.get(nextSeekCylinderIndex).delay();
					if (this.maxDelay < list.get(nextSeekCylinderIndex).delay())
						this.maxDelay = list.get(nextSeekCylinderIndex).delay();
					this.totalScore += list.get(nextSeekCylinderIndex).score();
					if (this.maxScore < list.get(nextSeekCylinderIndex).score())
						this.maxScore = list.get(nextSeekCylinderIndex).score();
					list.remove(nextSeekCylinderIndex);
				}
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
