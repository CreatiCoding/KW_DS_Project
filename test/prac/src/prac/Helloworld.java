package prac;
import java.util.Scanner; 

public class Helloworld {
	public static void main(String[] args)
	{
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("input score");
		 int score= scanner.nextInt();
		 
		 if(score >= 90)
		 {
			 System.out.println("A");
		 }
		 else if(score >= 80 && score < 90)
		 {
			 System.out.println("B");
		 }
		 else if( score >= 70 && score <80)
		 {
			 System.out.println("c");
		 }
		 else if(score >= 60 && score < 70)
		 {
			 System.out.println("D");
		 }
		 else if (score<60)
		 {
			 System.out.println("F");
		 }
	}

}
