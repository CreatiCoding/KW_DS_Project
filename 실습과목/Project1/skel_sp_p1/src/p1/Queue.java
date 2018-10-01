package p1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import p1.WordNode;

public class Queue {

	public WordNode pHead;

	Queue() {
		pHead = null;
	}

	// LOAD, ADD
	public void Push(WordNode node) {
		if(this.Search(node.GetWord()) != null)
			return ;
		else if (pHead == null)
			pHead = node;
		else {
			WordNode tmp = pHead;
			while (tmp.GetNext() != null)
				tmp = tmp.GetNext();
			
			tmp.SetNext(node);
		}
	}

	// MOVE
	public WordNode Pop() {
		WordNode tmp;
		tmp = pHead;
		pHead = tmp.GetNext();

		return pHead;
	}

	// SEARCH, UPDATE
	public WordNode Search(String word) {
		WordNode tmp;
		tmp = pHead;

		if(pHead == null) {
			return null;
		}else if (pHead.GetWord() == word) {
			return pHead;
		}

		else {
			while (tmp.GetNext() != null) {
				if (word.equals(tmp.GetWord()))
					return tmp;
				tmp = tmp.GetNext();
			}
		}
		return null;
	}

	// PRINT
	public boolean Print() throws IOException {
		WordNode tmp = pHead;
		if (pHead == null) {
			System.out.println("No Word in the wordlist");
			return false;
		} else {
			while (tmp.GetNext() != null) {
				System.out.printf(tmp.GetWord(), " ");
				System.out.println(tmp.GetMean());
				tmp = tmp.GetNext();
			}
			System.out.printf(tmp.GetWord(), " ");
			System.out.println(tmp.GetMean());
			return true;
		}
	}

	public String toString()  {
		try {
			return this.toString(pHead);
		} catch (IOException e) {
			return null;
		}
	}
	public String toString(WordNode node) throws IOException {
		if (node == null)
			return "";
		String result = node.toString() + "\n";
		result = result + this.toString(node.GetNext());
		return result;
	}

	// SAVE
	public boolean Save() throws IOException {

		BufferedOutputStream bos;

		// 쓸 문자열 = 작성한 내용
		String contents = this.toString(this.pHead);

		// 파일 쓰기
		bos = new BufferedOutputStream(new FileOutputStream("to_memorize_word.txt"));
		bos.write(contents.getBytes("utf-8"));
		bos.close();
		return true;

	}

	public static void main(String[] args) throws IOException {

		System.out.println("hello world!");

		Queue test = new Queue();
		test.Push(new WordNode("banana", "바나나"));
		test.Push(new WordNode("boat", "배"));
		test.Push(new WordNode("book", "책"));
		test.Push(new WordNode("doctor", "의사"));
		test.Push(new WordNode("dress", "드레스"));
		test.Push(new WordNode("dear", "친애하는"));
		
		test.Save();
		System.out.println(test.toString());
		test.Print();
	}

}
