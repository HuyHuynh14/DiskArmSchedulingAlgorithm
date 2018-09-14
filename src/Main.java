import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating masterList array
		int masterList[] = new int[1000];
		int cylinder = 50;
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		Scheduler sched;
		int runningSum = 0;
		
		System.out.print("What is the number of seeks to be generated?");
		int n = 0;
		n = keyboard.nextInt();
		System.out.println();
		
		int tempMasterList[] = new int[n];
		//Generating random cylinder seeks to masterList.
		for (int i = 0; i < masterList.length; i++){
			masterList[i] = rand.nextInt(100) + 1;
		}
		for (int i = 0; i < masterList.length; i++){
			tempMasterList[i] = masterList[i];
		}
		
		//Running First Come First Served.
		System.out.println("First Come First Severed Scheduling Algorithm");
		sched = new FirstComeFirstServed();
		runningSum = sched.runningSum(tempMasterList, cylinder);
		System.out.println("The total number of time units to perform all of the seeks: " + runningSum + " time units");
		System.out.println("The average delay for all the request: " + ((double) sched.getTotalDelay()/tempMasterList.length));
		System.out.println("The maximum delay: " + sched.getMaxDelay());
		System.out.println("The average score: " + ((double) sched.getTotalScore() / tempMasterList.length));
		System.out.println("The maximum score " + sched.getMaxScore());
		System.out.println();
		
		
		//Running Shortest Seek First
		System.out.println("Shortest Seek First Scheduling Algorithm");
		sched = new ShortestSeekFirst();
		ArrayList<seqReq> list = new ArrayList<seqReq>();
		
		int index = 0;
		int count = 0;
		while (count <= masterList.length && index < masterList.length){
			for (int i = index; i < index + 10; i++){
				seqReq instance = new seqReq(sched, masterList[i]);
				list.add(instance);
				count++;
				if (count == masterList.length){
					i = index + 10;
				}
			}
			index = count;
			sched.routin(list);
		}
		//When the list size is smaller than 5.
		sched.routin(list);
		
		System.out.println("The average delay for all the request: " + sched.averageDelay(masterList));
		System.out.println("The maximum delay: " + sched.getMaxDelay());
		System.out.println("The average score: " + sched.averageScore(masterList));
		System.out.println("The maximum score " + sched.getMaxScore());
		System.out.println();
		
		
		
		//Running Elevator.
		System.out.println("Elevator Scheduling Algorithm");
		sched = new Elevator();
		list = new ArrayList<seqReq>();
		
		index = 0;
		count = 0;
		while (count <= masterList.length && index < masterList.length){
			for (int i = index; i < index + 10; i++){
				seqReq instance = new seqReq(sched, masterList[i]);
				list.add(instance);
				count++;
				if (count == masterList.length){
					i = index + 10;
				}
			}
			index = count;
			sched.routin(list);
		}
		//When the list size is smaller than 5.
		sched.routin(list);
		
		runningSum = sched.runningSum(tempMasterList, cylinder);
		System.out.println("The total number of time units to perform all of the seeks: " + runningSum + " time units");
		System.out.println("The average delay for all the request: " + (double) sched.getTotalDelay() / tempMasterList.length);
		System.out.println("The maximum delay: " + sched.getMaxDelay());
		System.out.println("The average score: " + ((double) sched.getTotalScore() / tempMasterList.length));
		System.out.println("The maximum score " + sched.getMaxScore());
		System.out.println();
		
		
		//Running My Algorithm.
		System.out.println("My Scheduling Algorithm");
		sched = new MyAlgorithm();
		list = new ArrayList<seqReq>();
		
		index = 0;
		count = 0;
		while (count <= masterList.length && index < masterList.length){
			for (int i = index; i < index + 10; i++){
				seqReq instance = new seqReq(sched, masterList[i]);
				list.add(instance);
				count++;
				if (count == masterList.length){
					i = index + 10;
				}
			}
			index = count;
			sched.routin(list);
		}
		//When the list size is smaller than 5.
		sched.routin(list);
		
		runningSum = sched.runningSum(tempMasterList, cylinder);
		System.out.println("The total number of time units to perform all of the seeks: " + runningSum + " time units");
		System.out.println("The average delay for all the request: " + (double) sched.getTotalDelay() / tempMasterList.length);
		System.out.println("The maximum delay: " + sched.getMaxDelay());
		System.out.println("The average score: " + ((double) sched.getTotalScore() / tempMasterList.length));
		System.out.println("The maximum score " + sched.getMaxScore());
		System.out.println();		

		keyboard.close();

	}
}
