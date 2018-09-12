package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class AlphabetBST {
	private AlphabetNode root;
	private int WordCnt; 

	public AlphabetBST()
	{
		root = null;
		WordCnt = 0;
		AlphabetNode pnew = new AlphabetNode();
		
		char[] alpha = { 'P', 'H', 'X', 'D', 'L', 'T', 'Z', 'B', 'F', 'J', 'N', 'R', 'V', 'Y', 'A', 'C', 'E', 'G', 'I', 'K',
			'M', 'O', 'Q', 'S', 'U', 'W' };//insert alphabet 
		
		for (int i = 0; i < 26; i++) //26 ( number of alphabet ) 
		{
			pnew.SetAlphabet(alpha[i]); 
			Insert(pnew);
		}
	}
		
	public void Insert(AlphabetNode node)
	{
		
	}
	
	public boolean Print() throws IOException
	{
		
	}
	
	public AlphabetNode Search(char alpabet)
	{
		
	}
	
	public boolean Save() throws IOException
	{
		
	}

	public void	Preorder(AlphabetNode node) throws IOException
	{
		
	}

	public int getCnt()
	{
		
	}
	public void setCnt(int cnt)
	{

	}
}
