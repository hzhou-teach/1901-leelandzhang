//Leeland Zhang
//Took me like 30 mins but the reason is really funny, I misunderstood the question
//to something harder, so I was really confused why my code wasn't working 
//for some time, so in reality I think I could have gotten this question in
//15 mins. I even left the code on comment so you can see if you want.
//10/10, Although I'm wondering if there is a more efficient way to do this
//question because obviously maps cannot be used.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class planting_silver 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("planting.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("planting.out"));
		int N=sc.nextInt();
		ArrayList<ArrayList<Integer>> fields=new ArrayList<ArrayList<Integer>>(N);
		for(int i=0; i<N; i++)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			fields.add(temp);
		}
		for(int i=0; i<N-1; i++)
		{
			int x=sc.nextInt()-1;
			int y=sc.nextInt()-1;
			fields.get(x).add(y);
			fields.get(y).add(x);
		}
		sc.close();
		//-------------------------------------------------------------
		int count=0;
		int max=0;
		for(int i=0; i<N; i++)
		{
			count=0;
			//for(int j=0;j<fields.get(i).size();j++) code for when I misread the question
			//{
			//	count+=fields.get(fields.get(i).get(j)).size()-1;
			//}
			count+=fields.get(i).size()+1;
			if(count>max)
				max=count;
		}
		pr.println(max);
		pr.close();
	}
}
