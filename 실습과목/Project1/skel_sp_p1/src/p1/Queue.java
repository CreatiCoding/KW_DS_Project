package p1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import p1.WordNode;

public class Queue {

	public WordNode pHead;
	
	Queue()
	{
	
	}
	
	
	// LOAD, ADD
	public void Push(WordNode node){
		if(pHead==null)
			pHead=node; 
		else
		{
			WordNode tmp;
			tmp=pHead;
			
			while(tmp.GetNext()!=null)
				tmp=tmp.GetNext();
			
			tmp=node; 
		}
	}
	
	// MOVE
	public WordNode	Pop()
	{
		WordNode tmp;
		tmp= pHead;
		pHead=tmp.GetNext();
		
		return pHead; 
	}
		
	// SEARCH, UPDATE
	public WordNode Search(String word)
	{
		WordNode tmp;
		tmp=pHead;
	
		if(pHead.GetWord()==word)
		{
			return pHead;
		}
		
		else 
		{
			while(tmp.GetNext()!=null)
			{
				if(tmp.GetWord()==word)
					return tmp;
				
				tmp=tmp.GetNext();
			}
		}
		
		return null;
	}
	
	// PRINT
	public boolean Print() throws IOException
	{
		WordNode tmp= pHead; 
		
		while(tmp.GetNext()!=null)
		{
			System.out.printf(tmp.GetWord(), " ");
			System.out.println(tmp.GetMean());
			tmp=tmp.GetNext();
		}
		
		return true;
	}
	// SAVE
	public boolean Save() throws IOException
	{
		return true;
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println("hello world!");
		//Manager manager = new Manager();
		//manager.run("command.txt");
		
		Queue test= new Queue();
		WordNode node = new WordNode();
		node.SetWord("apple");
		node.SetMean("»ç°ú");
		
		test.Push(node);
				
	}

}
