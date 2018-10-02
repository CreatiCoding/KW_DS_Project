package p1;

import p1.Pair;

public class WordNode {

	private Pair<String, String> wordmean; // wordmean Pair
	private WordNode pLeft; // BST Left Pointer
	private WordNode pRight; // BST Right Pointer
	private WordNode pNext; // Queue Next Pointer

	WordNode() {
		this.wordmean = new Pair<String, String>();
	}

	WordNode(String word, String mean) {
		this.wordmean = new Pair<String, String>(word.trim(), mean.trim());
		this.pLeft = null;
		this.pRight = null;
		this.pNext = null;
	}

	WordNode(Pair<String, String> wordmean, WordNode pLeft, WordNode pRight, WordNode pNext) {
		this.wordmean = wordmean;
		this.pLeft = pLeft;
		this.pRight = pRight;
		this.pNext = pNext;
	}

	public String GetWord() {
		return wordmean.first;
	}

	public String GetMean() {
		return wordmean.second;
	}

	public WordNode GetLeft() {
		return pLeft;
	}

	public WordNode GetRight() {
		return pRight;
	}

	public WordNode GetNext() {
		return pNext;
	}

	public void SetWord(String word) {
		this.wordmean.first = word.trim();
	}

	public void SetMean(String mean) {
		this.wordmean.second = mean.trim();
	}

	public void SetLeft(WordNode node) {
		this.pLeft = node;
	}

	public void SetRight(WordNode node) {
		this.pRight = node;
	}

	public void SetNext(WordNode node) {
		this.pNext = node;
	}
	public String toString() {
		return "w\t"+this.GetWord()+"\t"+this.GetMean();
	}
}
