package p1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class WordBST {

	public WordNode root; // Word BST Root

	public WordBST() {
		root = null;
	}

	public void Insert(WordNode node) {
		if (root == null) {
			root = node;
		} else {
			WordNode target = root;

			while (true) {
				if (target.GetWord().compareTo(node.GetWord()) < 0) {
					if (target.GetLeft() == null) {
						target.SetLeft(node);
						return;
					} else {
						target = target.GetLeft();
					}
				} else if (target.GetWord().compareTo(node.GetWord()) > 0) {
					if (target.GetRight() == null) {
						target.SetRight(node);
						return;
					} else {
						target = target.GetRight();
					}
				} else {
					return;
				}
			}
		}
	}

	public WordNode Delete(String word) {
		WordNode target = root, parent = null;
		WordNode result =null;
		while (target != null && !target.GetWord().equals(word)) {
			parent = target;
			target = (target.GetWord().compareTo(word) > 0) ? target.GetLeft() : target.GetRight();
		}
		// not found
		if (target == null) {
			return null;
		}
		//no children
		if (target.GetLeft() == null && target.GetRight() == null) {
			if (parent == null) {
				root = null;
			} else if (parent.GetLeft() == target) {
				parent.SetLeft(null);
			} else {
				parent.SetRight(null);
			}
			// only right child
		} else if (target.GetLeft() == null) {
			if (parent == null) {
				root = target.GetRight();
			} else if (parent.GetLeft() == target) {
				parent.SetLeft(target.GetRight());
			} else {
				parent.SetRight(target.GetRight());
			}
			// only left child
		} else if (target.GetRight() == null) {
			if (parent == null) {
				root = target.GetLeft();
			} else if (parent.GetLeft() == target) {
				parent.SetLeft(target.GetLeft());
			} else {
				parent.SetRight(target.GetLeft());
			}
			// both left and right
		} else {
			WordNode prevprev = target, prev = target.GetRight(), current = target.GetRight().GetLeft();
			while (current != null) {
				prevprev = prev;
				prev = current;
				current = current.GetLeft();
			}
			// switch target and prev
			String temp = target.GetMean();
			target.SetMean(prev.GetMean());
			prev.SetMean(temp);
			temp = target.GetWord();
			target.SetWord(prev.GetWord());
			prev.SetWord(temp);
			
			// return object
			result=prev;
			
			if (prevprev == target) {
				prevprev.SetRight(prev.GetRight());
			} else {
				prevprev.SetLeft(prev.GetRight());
			}
		}
		return result;
	}

	public WordNode Search(String word) {

		WordNode target = root; //, parent = null;

		while (target != null && !target.GetWord().equals(word)) {
			//parent = target;
			target = (target.GetWord().compareTo(word) > 0) ? target.GetLeft() : target.GetRight();
		}

		return target;
	}

	public boolean Print() throws IOException {
		Preorder(root);
		return true;
	}

	public boolean Save() throws IOException {
		BufferedInputStream bis;
		BufferedOutputStream bos;
		
		// �씠�뼱 �벐湲곕�� �쐞�븳 �뙆�씪 �씫湲�
		StringBuffer pre_contents = new StringBuffer("");
		bis = new BufferedInputStream(new FileInputStream("memorizing_word.txt"));
		byte buffer[] = new byte[1024];
		while ((bis.read(buffer)) != -1) {
			pre_contents.append(new String(buffer, "utf-8"));
		}
		bis.close();
		
		// �벝 臾몄옄�뿴 = �씠�쟾 �궡�슜 + �옉�꽦�븳 �궡�슜
		String contents = pre_contents.toString() + this.toString(root);
		
		// �뙆�씪 �벐湲�
		bos = new BufferedOutputStream(new FileOutputStream("memorizing_word.txt"));
		bos.write(contents.getBytes("utf-8"));
		
		bos.close();
		return true;
	}

	public String toString()  {
		try {
			return toString(root);
		}catch(Exception e) {
			return "";
		}
	}
	public String toString(WordNode node) throws IOException {
		if (node == null)
			return "";
		String result = node.toString() + "\n";
		result = result + this.toString(node.GetLeft());
		result = result + this.toString(node.GetRight());
		return result;
	}

	public void Preorder(WordNode node) throws IOException {
		if (node == null)
			return;
		System.out.println("word: " + node.GetWord() + ", mean: " + node.GetMean());
		Preorder(node.GetLeft());
		Preorder(node.GetRight());
	}

	public static void main(String[] args) throws IOException {

		WordBST w = new WordBST();
		w.Insert(new WordNode("cat", "怨좎뼇�씠"));
		w.Insert(new WordNode("banana", "諛붾굹�굹"));
		w.Insert(new WordNode("apple", "�궗怨�"));
		w.Insert(new WordNode("doctor", "�쓽�궗"));
		w.Insert(new WordNode("eagle", "�룆�닔由�"));
		w.Print();
		w.Save();
	}
}
