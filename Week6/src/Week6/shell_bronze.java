//Leeland Zhang
//Took me 30 minutes cuz I'm so dumb I forgot that if its still under 
//A cup, and she guesses it even when the guy moves other cups, its still correct
//Jeez im dumb
//Got it in the end without looking at solutions tho thankfully
//10/10
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class shell_bronze 
{
	static int N;
	static int algorithm(int[][] x, int y)
	{
		int count=0;
		int pebble=y;
		for(int i=0; i<N; i++)
		{
			if(pebble==x[i][0])
			{
				pebble=x[i][1];
			}
			else if(pebble==x[i][1])
			{
				pebble=x[i][0];
			}
			if(x[i][2]==pebble)
			{
				count++;
			}
		}
		return count;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("shell.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("shell.out"));
		N=sc.nextInt();
		int[][] info=new int[N][3];
		for(int i=0; i<N; i++) 
		{
			info[i][0]=sc.nextInt();
			info[i][1]=sc.nextInt();
			info[i][2]=sc.nextInt();
		}
		sc.close();
		//-------------------------------------------------------------
		int best=0;
		for(int i=1; i<=3; i++)
		{
			if(algorithm(info,i)>best)
				best=algorithm(info, i);
		}
		pr.println(best);
		pr.close();
	}
}
