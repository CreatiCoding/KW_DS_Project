package p1;
import java.io.BufferedWriter;
import java.io.File;
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
		
		if(pHead==null)
		{
			System.out.println("No Word in the wordlist");
			return false; 
		}
		else {
			while(tmp.GetNext()!=null)
			{
				System.out.printf(tmp.GetWord(), " ");
				System.out.println(tmp.GetMean());
				tmp=tmp.GetNext();
			}
			return true;
		}
		
	}
	// SAVE
	public boolean Save() throws IOException
	{
		WordNode tmp= pHead; 
		File file = new File("word.txt");
		
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		if(pHead==null)
		{
			System.out.println("no words to save");
			return false; 
		}
		else
		{
			FileWriter fw= new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			while(tmp.GetNext()!=null)
			{
				bw.write(tmp.GetWord());
				bw.write(tmp.GetMean());
				tmp=tmp.GetNext();
			}
			
			return true;
		}
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
