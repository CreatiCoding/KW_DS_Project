package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class AlphabetBST {
	private AlphabetNode root;
	private int WordCnt;

	public AlphabetBST() {
		root = null;
		WordCnt = 0;

		
		char[] alpha = { 'P', 'H', 'X', 'D', 'L', 'T', 'Z', 'B', 'F', 'J', 'N', 'R', 'V', 'Y', 'A', 'C', 'E', 'G', 'I',
				'K', 'M', 'O', 'Q', 'S', 'U', 'W' };

		for (int i = 0; i < 26; i++) {
			Insert(new AlphabetNode(alpha[i]));
		}
		
	}

	public void Insert(AlphabetNode node) {
		if (root == null) {
			root = node;
		} else {
			AlphabetNode tmp = root;
			while (true) {
				if (tmp.GetAlphabet() > node.GetAlphabet()) {
					if (tmp.GetLeft() != null) {
						tmp = tmp.GetLeft();
					} else {
						tmp.SetLeft(node);
						break;
					}
				} else if (tmp.GetAlphabet() < node.GetAlphabet()) {
					if (tmp.GetRight() != null) {
						tmp = tmp.GetRight();
					} else {
						tmp.SetRight(node);
						break;
					}
				} else {
					return;
				}
			}
		}
	}

	public boolean Print() throws IOException {
		Preorder(root);
		return true;
	}
	
	public AlphabetNode Search(char alpabet) {
		AlphabetNode tmp = root;
		while (tmp != null) {
			if (tmp.GetAlphabet() == alpabet ) {
				return tmp;
			}else if (tmp.GetAlphabet() > alpabet) {
				tmp = tmp.GetLeft();
			} else if (tmp.GetAlphabet() < alpabet) {
				tmp = tmp.GetRight();
			}
		}
		return tmp;
	}
	/**
	 * TODO
	 * WordBST를 저장하는 방식을 사용해야함
	 * @return
	 * @throws IOException
	 */
	public boolean Save() throws IOException {
		return false;
	}

	public void Preorder(AlphabetNode node) throws IOException {
		if (node == null)
			return;
		System.out.println(node.GetAlphabet());
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

		System.out.println("start test!");
		AlphabetBST test = new AlphabetBST();
		test.Print();

	}
}
