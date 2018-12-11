package p1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import p1.WordNode;

public class Queue {

	public WordNode pHead;
	private int WordCnt;
	/**
	 * init
	 */
	Queue() {
		pHead = null;
		WordCnt = 0;
	}

	/**
	 * add node in queue
	 * @param node
	 */
	// LOAD, ADD
	public void Push(WordNode node) {
		// if already exist, then do nothing.
		if(this.Search(node.GetWord()) != null) {
			return ;
		// if empty, add in root
		}else if (pHead == null) {
			WordCnt++;
			pHead = node;
		// if many
		}else {
			// find last node then add
			WordNode tmp = pHead;
			while (tmp.GetNext() != null)
				tmp = tmp.GetNext();
			WordCnt++;
			tmp.SetNext(node);
		}
	}

	/**
	 * return head because of first in first out
	 * @return
	 */
	// MOVE
	public WordNode Pop() {
		WordNode tmp;
		tmp = pHead;
		pHead = tmp.GetNext();

		return tmp;
	}

	/**
	 * search node by word
	 * @param word
	 * @return
	 */
	// SEARCH, UPDATE
	public WordNode Search(String word) {
		WordNode tmp;
		tmp = pHead;

		// if empty
		if(pHead == null) {
			return null;
		// if phead is target, return
		}else if (word.equals(pHead.GetWord())) {
			return pHead;
		// if many
		} else {
			// loop and find node
			while (tmp.GetNext() != null) {
				if (word.equals(tmp.GetWord()))
					return tmp;
				tmp = tmp.GetNext();
			}
		}
		return null;
	}

	/**
	 * print contents
	 * @return
	 * @throws IOException
	 */
	// PRINT
	public boolean Print() throws IOException {
		WordNode tmp = pHead;
		// if empty
		if (pHead == null) {
			System.out.println("Empty.");
			return false;
		// if many print
		} else {
			// loop and print
			while (tmp.GetNext() != null) {
				System.out.println(tmp.GetWord() + " " + tmp.GetMean());
				tmp = tmp.GetNext();
			}
			// print last node
			System.out.println(tmp.GetWord() + " " + tmp.GetMean());
			return true;
		}
	}

	/**
	 * tostring function for save
	 */
	public String toString()  {
		try {
			return this.toString(pHead);
		} catch (IOException e) {
			return null;
		}
	}
	/**
	 * totring function by recursving
	 * @param node
	 * @return
	 * @throws IOException
	 */
	public String toString(WordNode node) throws IOException {
		if (node == null)
			return "";
		String result = node.toString() + "\n";
		result = result + this.toString(node.GetNext());
		return result;
	}

	/**
	 * save contents in file
	 * @return
	 * @throws IOException
	 */
	// SAVE
	public boolean Save() throws IOException {

		BufferedOutputStream bos;

		// get contents from queue.
		String contents = this.toString(this.pHead);
		System.out.println(contents);
		// save contents in to_memorized_word file.
		bos = new BufferedOutputStream(new FileOutputStream("to_memorize_word.txt"));
		bos.write(contents.getBytes());
		bos.close();
		return true;

	}
	/**
	 * check empty
	 * @return
	 */
	public boolean isEmpty() {
		return this.pHead == null;
	}
	/**
	 * count word
	 * @return
	 */
	public int getCnt() {
		return this.WordCnt;
	}

	/**
	 * just for test code.
	 * @param args
	 * @throws IOException
	 */
	public static void test() throws IOException {

		System.out.println("hello world!");

		Queue test = new Queue();
		test.Push(new WordNode("banana", "바나나"));
		test.Push(new WordNode("boat", "보트"));
		test.Push(new WordNode("book", "책"));
		test.Push(new WordNode("doctor", "의사"));
		test.Push(new WordNode("dress", "드레스"));
		test.Push(new WordNode("dear", "친애하는"));
		
		test.Save();
		test.Print();
	}
}
