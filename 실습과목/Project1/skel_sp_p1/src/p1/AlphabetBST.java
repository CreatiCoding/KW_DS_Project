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
		if(root == null)
		{
			root = node; 
		}
		else 
		{
			AlphabetNode tmp= root;
			
			while(true)
			{
				if(tmp.GetAlphabet()>node.GetAlphabet())
				{
					if(tmp.GetLeft()!=null)
						tmp=tmp.GetLeft();
					else
						{
							tmp.SetLeft(node);
							break;
						}
				}
				else if(tmp.GetAlphabet()<node.GetAlphabet())
				{
					if(tmp.GetRight()!=null)
						tmp=tmp.GetRight();
					else
					{
						tmp.SetRight(node);
						break;
					}
				}
				else
				{
					return; 
				}
			}
		}
	}
	
	public boolean Print() throws IOException
	{
		Preorder(root);
		return true; 
	}
	
	public AlphabetNode Search(char alpabet)
	{
		AlphabetNode tmp=root; 
		while(true)
		{
			if(tmp.GetAlphabet()>alpabet)
			{
				if(tmp.GetLeft()!=null)
				{
					tmp=tmp.GetLeft();
					if(tmp.GetAlphabet()==alpabet)
						return tmp; 
				}
			}
			else if (tmp.GetAlphabet()<alpabet)
			{
				if(tmp.GetRight()!=null)
				{
					tmp=tmp.GetRight();
					if(tmp.GetAlphabet()==alpabet)
						return tmp; 
				}
			}
		}
		
	}
	
	public boolean Save() throws IOException
	{
		
	}

	public void	Preorder(AlphabetNode node) throws IOException
	{
		if(root==null)
			return; 
		
		System.out.println(node.GetAlphabet());
		Preorder(node.GetLeft());
		Preorder(node.GetRight());	
	}

	public int getCnt()
	{
		return this.WordCnt;
	}
	public void setCnt(int cnt)
	{
		this.setCnt(cnt);
	}
}
