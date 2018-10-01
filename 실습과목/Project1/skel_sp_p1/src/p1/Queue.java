package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import p1.WordNode;

public class Queue {

	public WordNode pHead;

	Queue() {

	}

	// LOAD, ADD
	public void Push(WordNode node) {
		if (pHead == null)
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

		if (pHead.GetWord() == word) {
			return pHead;
		}

		else {
			while (tmp.GetNext() != null) {
				if (tmp.GetWord() == word)
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

			System.out.printf(tmp.GetWord(), " ");
			System.out.println(tmp.GetMean());
			while (tmp.GetNext() != null) {
				System.out.printf(tmp.GetWord(), " ");
				System.out.println(tmp.GetMean());
				tmp = tmp.GetNext();
			}

			return true;
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

		// 쓸 문자열 = 이전 내용 + 작성한 내용
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
		test.Push(new WordNode("apple", "사과"));
		test.Push(new WordNode("banana", "바나"));
		test.Push(new WordNode("cat", "고양이"));
		test.Push(new WordNode("doctor", "의사"));
		test.Push(new WordNode("eagle", "독수리"));
		test.Print();
		test.Save();
	}

}
