//Leeland Zhang
//Took me 30 mins
//12/12
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class sleepy_bronze 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("sleepy.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("sleepy.out"));
		int N=sc.nextInt();
		int[] cows=new int[N];
		for(int i=0; i<N; i++)
		{
			cows[i]=sc.nextInt();
		}
		sc.close();
		//---------------------------------------------------------
		int pos=N-1;
		for(int i=N-1; i>0;i--)
		{
			if(cows[i]<cows[i-1])
			{
				pos=i;
			}
			else
				break;
		}
		pr.println(pos);
		pr.close();
	}
}
