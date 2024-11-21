package practiceDAAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//public class assign2 {
//
//	
//	public static void main(String[] args) {
//		
//		
//		Scanner sc = new Scanner(System.in);
//		int max_time,ch;
//		String id;
//		int profit,deadline;
//		System.out.print("Enter maximum deadline for jobs: ");
//		max_time = sc.nextInt();
//		
//		ArrayList<Job> Arr= new ArrayList<Job>();
//		do {
//			System.out.println("****************Menu******************");
//			System.out.println("1.Add Job");
//			System.out.println("2.Exit");
//			System.out.print("Your Choice: ");
//			ch = sc.nextInt();
//			
//			switch(ch) {
//			case 1 : {
//				System.out.print("Enter Job Id: ");
//				id = sc.next();
//				System.out.print("Enter Deadline for Job: ");
//				deadline = sc.nextInt();
//				System.out.print("Enter Profit for Job: ");
//				profit = sc.nextInt();
//				Arr.add(new Job(id,deadline,profit));
//			}
//			break;
//			case 2:
//				System.out.println("Thank You!!!");
//			break;
//			default:
//				System.out.println("You entered wrong input!!!");
//			break;
//			}
//		}while(ch!=2);
//
//		printSolution(Arr, max_time);
//		
//	}
//	
//	
//	static void printSolution(ArrayList<Job> jobs, int time) {
//		
//		int n = jobs.size();
//		int profit = 0;
//		
//		Collections.sort(jobs,(a,b) -> b.profit - a.profit);
//		
//		boolean Timeslot[] = new boolean[time] ;
//		
//		String Job_Schedule[] = new String[time];
//		
//
//		
//		for(int i =0;i<n;i++) {
//			int limit = Math.min(time - 1, jobs.get(i).deadline - 1);
//			for (int j = limit; j >= 0; j--) {
//				if(!Timeslot[j] ) {
//					Timeslot[j] = true;
//					Job_Schedule[j] = jobs.get(i).Id;
//					profit += jobs.get(i).profit;
//					break;
//				}
//			}
//		}
//		System.out.println(jobs);
//	       for (int i=0;i<time;i++) {
//	           System.out.print(Job_Schedule[i] + " ");
//	       }
//	       System.out.print("\nTotal Profit gained is: " + profit);
//
//		
//	}
//	
//	
//	
//}
//
//
//class Job{
//	
//	String Id;
//	int deadline,profit;
//	public Job(String id, int deadline, int profit) {
//		super();
//		Id = id;
//		this.deadline = deadline;
//		this.profit = profit;
//	}
//	@Override
//	public String toString() {
//		return "Job [Id=" + Id + ", deadline=" + deadline + ", profit=" + profit + "]";
//	}
//	
//}



class Job {
	private
		String Id;
		int Deadline,Profit;
		
		public Job() {};
		public Job(String Id, int Deadline, int Profit) {
			this.setId(Id);
			this.Deadline = Deadline;
			this.Profit = Profit;
		}
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		@Override
		public String toString() {
			return "Job [Id=" + Id + ", Deadline=" + Deadline + ", Profit=" + Profit + "]";
		}
		
		
};
//public class assign2 {
//	static void PrintJobSchedule(ArrayList<Job> Arr, int time) {
//		int n = Arr.size();
//		int profit=0;
//		
//		Collections.sort(Arr, (a,b) -> b.Profit - a.Profit);
//		
//		boolean Timeslot[] = new boolean[time];
//		
//		String Job_Schedule[] = new String[time];
//		
//		for (int i = 0; i < n; i++) {
//           for (int j = Math.min(time - 1, Arr.get(i).Deadline - 1);j >= 0; j--) {
//               if (Timeslot[j] == false) {
//                   Timeslot[j] = true;
//                   Job_Schedule[j] = Arr.get(i).getId();
//                   profit = profit + Arr.get(i).Profit;
//                   break;
//               }
//           }
//       }
//       for (int i=0;i<time;i++) {
//           System.out.print(Job_Schedule[i] + " ");
//       }
//       System.out.print("\nTotal Profit gained is: " + profit);
//	};
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		int max_time,ch;
//		String id;
//		int profit,deadline;
//		System.out.print("Enter maximum deadline for jobs: ");
//		max_time = sc.nextInt();
//		
//		ArrayList<Job> Arr= new ArrayList<Job>();
//		do {
//			System.out.println("****************Menu******************");
//			System.out.println("1.Add Job");
//			System.out.println("2.Exit");
//			System.out.print("Your Choice: ");
//			ch = sc.nextInt();
//			
//			switch(ch) {
//			case 1 : {
//				System.out.print("Enter Job Id: ");
//				id = sc.next();
//				System.out.print("Enter Deadline for Job: ");
//				deadline = sc.nextInt();
//				System.out.print("Enter Profit for Job: ");
//				profit = sc.nextInt();
//				Arr.add(new Job(id,deadline,profit));
//			}
//			break;
//			case 2:
//				System.out.println("Thank You!!!");
//			break;
//			default:
//				System.out.println("You entered wrong input!!!");
//			break;
//			}
//		}while(ch!=2);
//		
//		System.out.print("\nFollowing is maximum profit sequence of jobs: ");
//		PrintJobSchedule(Arr, max_time);
//	}
//}

class assign2{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the deadline : ");
		int maxDeadline = sc.nextInt();
		
		int ch = 0;
		
		ArrayList<Job> jobs = new ArrayList<Job>();
		
		while(ch != 2) {
			
			System.out.println("Enter Your Choice \n 1.add Job \n 2. Exit \n");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				String id;
				int deadline,profit;
				System.out.println("Enter id : ");
				id = sc.next();
				System.out.println("Enter deadline : ");
				deadline = sc.nextInt();
				System.out.println("Enter profit : ");
				profit = sc.nextInt();
				jobs.add(new Job(id,deadline,profit));
				break;

			case 2:
				System.out.println("Thank you");
				scheduleJobs(jobs, maxDeadline);
				break;
			}
			
		}
		
	}
	
	
	static void scheduleJobs(ArrayList<Job> jobs,int max_time) {
		
		int n = jobs.size();
		
		boolean [] TimeSlot = new boolean[max_time];
		String[] JobSchedule = new String[max_time];
		
		int profit = 0;
		
		Collections.sort(jobs, (a,b) -> b.Profit - a.Profit );
		
		for(int i = 0;i<n;i++) {
			for(int j = Math.min(max_time-1, jobs.get(i).Deadline-1);j>=0;j--) {
				if(!TimeSlot[j]) {
					TimeSlot[j] =  true;
					JobSchedule[j] = jobs.get(i).getId();
					profit += jobs.get(i).Profit;
					break;
				}
			}
		}
		

		System.out.println(jobs);
	       for (int i=0;i<max_time;i++) {
	           System.out.print(JobSchedule[i] + " ");
	       }
	       System.out.print("\nTotal Profit gained is: " + profit);
		
	}


	
	
}
