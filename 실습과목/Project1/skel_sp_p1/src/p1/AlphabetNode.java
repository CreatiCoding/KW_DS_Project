package p1;

public class AlphabetNode {
	private char alphabet;
	private WordBST bst;
	private AlphabetNode pLeft;		// BST Left Pointer
	private AlphabetNode pRight;	// BST Right Pointer
	
	AlphabetNode()
	{
		this('\0');
	}

	AlphabetNode(char alphabet)
	{
		this.SetAlphabet(alphabet);
		this.SetLeft(null);
		this.SetRight(null);
		this.SetBST(null);
	}
	
	public char GetAlphabet()
	{
		return this.alphabet;
	}
	
	public WordBST GetBST()
	{
		return this.bst;
	}
	
	public AlphabetNode GetLeft()
	{
		return this.pLeft;
	}
	
	public AlphabetNode GetRight()
	{
		return this.pRight;
	}
	
	public void	SetAlphabet(char alphabet)
	{
		this.alphabet = alphabet;
	}
	
	public void	SetLeft(AlphabetNode node)
	{
		this.pLeft = node;
	}
	
	public void	SetRight(AlphabetNode node)
	{
		this.pRight = node;
	}
	
	public void SetBST(WordBST node)
	{
		this.bst = node;
	}

}
