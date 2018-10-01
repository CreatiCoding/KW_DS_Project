package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
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
			this.Insert(new AlphabetNode(alpha[i]));
		}

	}

	public void InsertWord(WordNode node) {
		AlphabetNode target = this.Search(node.GetWord().toUpperCase().charAt(0));
		if (target.GetBST() == null) {
			target.SetBST(new WordBST());
		}
		target.GetBST().Insert(node);
		this.WordCnt++;
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
			System.out.println(node.GetAlphabet());
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
		Preorder(node.GetLeft());
		System.out.println(node.GetAlphabet());
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
		test.InsertWord(new WordNode("banana", "바나나"));
		test.InsertWord(new WordNode("apple", "사과"));
		test.InsertWord(new WordNode("air", "공기"));
		test.InsertWord(new WordNode("ant", "개미"));
		test.InsertWord(new WordNode("doctor", "의사"));
		test.InsertWord(new WordNode("eagle", "독수리"));
		test.Save();
	}
}
