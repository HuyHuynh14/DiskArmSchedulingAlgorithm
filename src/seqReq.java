
public class seqReq {
	
	private int startTime;
	private int endTime;
	private int delay;
	private int cylinder;
	
	public seqReq(Scheduler obj, int cylinder){
		this.startTime = obj.getTime();
		this.endTime = 0;
		this.delay = 0;
		this.cylinder = cylinder;
	}
	//Set endTime when the seek request is satisfied.
	public void setEndTime(int time){
		this.endTime = time;
	}
	
	//Get cylinder number
	public int getCylinder(){
		return cylinder;
	}
	
	//Give the delay for a request
	public int delay(){
		this.delay = (this.endTime - this.startTime);
		return this.delay;
	}
	//Give the score for a request
	public double score(){
		return (this.delay * Math.sqrt(this.delay));
	}
}
