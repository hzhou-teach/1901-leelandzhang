package Week6;
//Not finished
//Floodfill, give each blob unique id, run through all the equals max and count . for perimeter by add extra on edges
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class perimeter_silver 
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("perimeter.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("perimeter.out"));
		int N=sc.nextInt();
		boolean [][] icecream=new boolean[N][N];
		for(int i=0; i<N; i++)
		{
			String temp=sc.next();
			for(int j=0; j<N; j++)
			{
				if(temp.substring(j,j+1).equals("#"))
					icecream[i][j]=true;
			}
		}
		sc.close();
		//---------------------------------------------------------
		Map<Integer,Integer> pairs=new HashMap<Integer, Integer>();
		boolean[][] visited=new boolean[N][N];
		for(int i=0; i<N;i++)
		{
			for(int j=0; j<N; j++)
			{
				if(j!=N-1&&icecream[i][j]&&icecream[i][j+1]&&!visited[i][j]&&!visited[i][j+1])
					pairs.put(i*N+j,i*N+j+1);
				if(N!=N-1&&icecream[i][j]&&icecream[i+1][j])
				{
					pairs.put(i*N+j,(i+1)*N+j);
					visited[i+1][j]=true;
				}
			}
		}
		int count=1;
		ArrayList<Integer> multimax=new ArrayList<Integer>();
		while(pairs.size()>0)
		{
			int temp=pairs.get(pairs.entrySet().stream().findFirst().get().getKey());
			while(pairs.get(temp)!=null)
			{
				int tp=temp;
				temp=pairs.get(temp);
				pairs.remove(tp);
				count++;
			}
			
			multimax.add(pairs.entrySet().stream().findFirst().get().getKey());
		}
	}
}
