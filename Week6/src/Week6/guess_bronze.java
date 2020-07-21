//Leeland Zhang
//Took me 30 mins
//10/10
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class guess_bronze 
{
	public static int compare(ArrayList<String> x, ArrayList<String> y)
	{
		int count=0;
		Hashtable<Integer,String> temp=new Hashtable<Integer, String>();
		for(int i=0; i<x.size();i++)
		{
			temp.put(i, x.get(i));
		}
		for(int i=0; i<y.size();i++)
		{
			if(temp.containsValue(y.get(i)))
				count++;
		}
		return count;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("guess.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("guess.out"));
		int N=sc.nextInt();
		ArrayList<ArrayList<String>> animals=new ArrayList<ArrayList<String>>();
		for(int i=0; i<N; i++)
		{
			String useless=sc.next();
			ArrayList<String> temp=new ArrayList<String>();
			int num=sc.nextInt();
			for(int j=0; j<num;j++)
			{
				temp.add(sc.next());
			}
			animals.add(temp);
		}
		sc.close();
		//--------------------------------------------------------------
		int max=0;
		for(int i=0; i<N; i++)
		{
			for(int j=i+1; j<N; j++)
			{
				if(max<compare(animals.get(i), animals.get(j)))
				{
					max=compare(animals.get(i), animals.get(j));
				}
			}
		}
		pr.println(max+1);
		pr.close();
	}
}