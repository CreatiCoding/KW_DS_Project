package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CircularLinkedList {
	public WordNode pHead; 	// Circular Linked List Head Pointer
	private int WordCnt;	// for word count

	/**
	 * init
	 */
	public CircularLinkedList() {
		this.pHead = null;
		WordCnt=0;
	}

	public int getCnt() {
		return WordCnt;
	}
	
	/**
	 * delete by word string
	 * @param word
	 */
	public void Delete(String word) {
		// if empty, do nothing
		if (this.pHead == null) {
			return;
		// if one, delete root
		} else if (this.pHead.GetNext() == this.pHead) {
			if (word.equals(this.pHead.GetWord())) {
				this.pHead = null;
				return;
			}
		// if many
		} else {
			// find parent
			WordNode target = this.pHead;
			WordNode parent = this.pHead.GetNext();
			while ((!word.equals(parent.GetNext().GetWord())) && !(parent.GetNext() == this.pHead)) {
				parent = parent.GetNext();
			}
			// set target
			target = parent.GetNext();

			// checko about root
			if (target == this.pHead) {
				this.pHead = this.pHead.GetNext();
			}
			// change parent next node
			parent.SetNext(target.GetNext());

			// delete target
			target = null;

		}
		return;
	}

	/**
	 * insert node
	 * @param node
	 */
	public void Insert(WordNode node) {
		// if empty, then set root
		if (this.pHead == null) {
			this.pHead = node;
			this.pHead.SetNext(node);
			WordCnt++;
		// if one, add to tail
		} else if (this.pHead.GetNext() == this.pHead) {
			this.pHead.SetNext(node);
			node.SetNext(this.pHead);
			WordCnt++;
		// if many
		} else {
			// find parent
			WordNode temp = this.pHead;
			WordNode parent = this.pHead.GetNext();
			while (parent.GetNext() != temp) {
				parent = parent.GetNext();
			}
			
			// set parent new node
			parent.SetNext(node);
			node.SetNext(this.pHead);
			WordCnt++;
		}
	}

	/**
	 * search node
	 * @param word
	 * @return
	 */
	public WordNode Search(String word) {
		WordNode cur = this.pHead;
		// if empty
		if (cur == null) {
			return null;
		// if one
		} else if (cur.GetNext() == null) {
			// if find return
			if (word.equals(cur.GetWord())) {
				return cur;
			// not found
			} else {
				return null;
			}
		// if many
		} else {
			// if find in root then return
			if (word.equals(cur.GetWord())) {
				return cur;
			// or keep find
			} else {
				// find until tail
				while (cur.GetNext() != this.pHead) {
					// if find return
					if (word.equals(cur.GetWord())) {
						return cur;
					} else {
						cur = cur.GetNext();
					}
				}
				// if tail is target then return
				if (word.equals(cur.GetWord())) {
					return cur;
				// if not return null
				} else {
					return null;
				}
			}
		}
	}

	/**
	 * print
	 * @return
	 * @throws IOException
	 */
	public boolean Print() throws IOException {

		// if empty
		if (this.pHead == null) {
			System.out.println("Empty.");
		// if one
		} else if (this.pHead.GetNext() == this.pHead) {
			// print one
			System.out.println(this.pHead.GetWord()+" "+this.pHead.GetMean());
		// if many
		} else {
			// go loop then print
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				System.out.println(temp.GetWord()+" "+temp.GetMean());
				temp = temp.GetNext();
			}
			// print last node
			System.out.println(temp.GetWord()+" "+temp.GetMean());
		}
		return true;
	}

	/**
	 * tostring function for save
	 */
	public String toString() {
		String resultString = "";
		if (this.pHead == null) {
			resultString += ("Empty\n");
		} else if (this.pHead.GetNext() == this.pHead) {
			resultString += (this.pHead.toString() + "\n");
		} else {
			WordNode temp = this.pHead;
			while (temp.GetNext() != this.pHead) {
				resultString += (temp.toString() + "\n");
				temp = temp.GetNext();
			}
			resultString += (temp.toString() + "\n");
		}
		return resultString;
	}

	/**
	 * save in text file
	 * @return
	 * @throws IOException
	 */
	public boolean Save() throws IOException {
		BufferedOutputStream bos;
		bos = new BufferedOutputStream(new FileOutputStream("memorized_word.txt"));
		bos.write(this.toString().getBytes());
		bos.close();
		return true;
	}

	/**
	 * just for test code.
	 * @param args
	 * @throws IOException
	 */
	public static void test() throws IOException {

		CircularLinkedList test = new CircularLinkedList();
		test.Print();

		test.Insert(new WordNode("eagle", "독수리"));
		test.Insert(new WordNode("east", "먹다"));
		test.Insert(new WordNode("eat", "동쪽"));
		test.Insert(new WordNode("file", "파일"));
		test.Insert(new WordNode("five", "다섯"));
		test.Insert(new WordNode("fox", "여우"));

		test.Print();
	}
}
