
//Leeland Zhang
//Took me an hour
//11/11
//I feel like I pretty much did a 'bronze method'. Just compared the pairs.
//I knew it would work because it said N was under 10^5 but still..
//Is there a faster or better way to do this problem?
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class mountains_silver 
{
	static long[][] endpoints;
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("mountains.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("mountains.out"));
		int N=sc.nextInt();
		long[][] peaks=new long[N][2];
		for(int i=0; i<N; i++)
		{
			peaks[i][0]=sc.nextInt();
			peaks[i][1]=sc.nextInt();
		}
		sc.close();
		//---------------------------------------------------------
		endpoints=new long[N][2];
		for(int i=0; i<N; i++)
		{
			endpoints[i][0]=peaks[i][0]-peaks[i][1];
			endpoints[i][1]=peaks[i][0]+peaks[i][1];
		}
		int count=0;
		for(int i=0; i<N-1; i++)
		{
			if(endpoints[i][1]==-1)
				continue;
			for(int j=i+1; j<N;j++)
			{
				if(endpoints[j][1]==-1)
					continue;
				if(endpoints[i][0]<=endpoints[j][0]&&endpoints[i][1]>=endpoints[j][1])
				{
					count++;
					endpoints[j][1]=-1;
				}
				else if(endpoints[j][0]<=endpoints[i][0]&&endpoints[j][1]>=endpoints[i][1])
				{
					count++;
					break;
				}
			}
		}
		pr.println(N-count);
		pr.close();
	}
}
