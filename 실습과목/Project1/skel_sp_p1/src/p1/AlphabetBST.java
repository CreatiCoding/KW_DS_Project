package p1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AlphabetBST {
	private AlphabetNode root;
	private int WordCnt;

	/**
	 * constructor
	 */
	public AlphabetBST() {
		// init variable
		root = null;
		WordCnt = 0;
		char[] alpha = { 'P', 'H', 'X', 'D', 'L', 'T', 'Z', 'B', 'F', 'J', 'N', 'R', 'V', 'Y', 'A', 'C', 'E', 'G', 'I',
				'K', 'M', 'O', 'Q', 'S', 'U', 'W' };
		// init AlphabetBST
		for (int i = 0; i < 26; i++) {
			this.Insert(new AlphabetNode(alpha[i]));
		}
	}

	/**
	 * insert word to BST
	 * @param node
	 */
	public void InsertWord(WordNode node) {
		// get alphabet from word first letter. then, get alphabetnode.
		AlphabetNode target = this.Search(node.GetWord().toUpperCase().charAt(0));
		// if null,  
		if (target.GetBST() == null) {
			target.SetBST(new WordBST());
		}
		target.GetBST().Insert(node);
		this.WordCnt++;
	}

	/**
	 * insert alphabet to BST
	 * @param node
	 */
	public void Insert(AlphabetNode node) {
		// if empty
		if (root == null) {
			root = node;
		// if not empty
		} else {
			AlphabetNode tmp = root;
			// go loop until insert node in proper place
			while (true) {
				// if alphabet is smaller
				if (tmp.GetAlphabet() > node.GetAlphabet()) {
					// if left exists, then go left
					if (tmp.GetLeft() != null) {
						tmp = tmp.GetLeft();
					// if not, insert in left
					} else {
						tmp.SetLeft(node);
						break;
					}
				// if alphabet is bigger
				} else if (tmp.GetAlphabet() < node.GetAlphabet()) {
					// if right exists, then go left
					if (tmp.GetRight() != null) {
						tmp = tmp.GetRight();
					// if not, insert in right
					} else {
						tmp.SetRight(node);
						break;
					}
				// if alphabet is same
				} else {
					// do nothing
					return;
				}
			}
		}
	}

	/**
	 * print word in pre-order
	 * @return
	 * @throws IOException
	 */
	public boolean Print() throws IOException {
		this.Preorder(root);
		return true;
	}

	public AlphabetNode Search(char alpabet) {
		AlphabetNode tmp = root;
		while (tmp != null) {
			if (tmp.GetAlphabet() == alpabet) {
				return tmp;
			} else if (tmp.GetAlphabet() > alpabet) {
				tmp = tmp.GetLeft();
			} else if (tmp.GetAlphabet() < alpabet) {
				tmp = tmp.GetRight();
			}
		}
		return tmp;
	}

	public String toString() {
		return this.toString(root);
	}

	public String toString(AlphabetNode node) {
		String result = "";

		if (node == null) {
			return "";
		} else {
			result += toString(node.GetLeft());
			result += (node.toString() + "\n");
			if (node.GetBST() != null)
				result += (node.GetBST().toString());
			result += toString(node.GetRight());

			return result;
		}
	}

	/**
	 * TODO WordBST�� �����ϴ� ����� ����ؾ���
	 * 
	 * @return
	 * @throws IOException
	 */
	public boolean Save() throws IOException {
		BufferedOutputStream bos;

		// 쓸 문자열 = 이전 내용 + 작성한 내용
		String contents = this.toString(root);

		// 파일 쓰기
		bos = new BufferedOutputStream(new FileOutputStream("memorizing_word.txt"));
		bos.write(contents.getBytes("utf-8"));
		bos.close();

		return true;
	}

	public void Preorder(AlphabetNode node) throws IOException {
		if (node == null)
			return;
		node.GetBST().Print();
		Preorder(node.GetLeft());
		Preorder(node.GetRight());
	}

	public int getCnt() {
		return this.WordCnt;
	}

	public void setCnt(int cnt) {
		this.setCnt(cnt);
	}

	public static void main(String[] args) throws IOException {

		AlphabetBST test = new AlphabetBST();
		test.InsertWord(new WordNode("cat", "고양이"));
		test.InsertWord(new WordNode("candy", "사탕"));
		test.InsertWord(new WordNode("apple", "사과"));
		test.InsertWord(new WordNode("air", "공기"));
		test.InsertWord(new WordNode("ant", "개미"));
		test.InsertWord(new WordNode("church", "교회"));
		
		test.Print();
		
	}
}
