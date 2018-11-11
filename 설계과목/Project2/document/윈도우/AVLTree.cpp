#include "AVLTree.h"

AVLTree::AVLTree(ofstream* fout){
	root=NULL;
	make_heap(vHeap.begin(), vHeap.end(), compare);
	this->fout = fout;
}

AVLTree::~AVLTree(){

}

bool AVLTree::Insert(StockData* pSto){
	/* Flowing code can be used, modified, deleted. -- When submit assignment, delete this comment */
	AVLNode* pNew = new AVLNode;
	pNew->setSD(pSto);	
	char	*pName = pSto->getName();
	int		rotation = 0;

	// case #0 empty tree	
	if(root == NULL){
		root = pNew;
		return true;
	}

	// Find Place to insert data
	
	

}

bool AVLTree::Print(){
	/* Flowing code can be used, modified, deleted. -- When submit assignment, delete this comment */
	stack<AVLNode*> s;	 

	return true;
}

bool AVLTree::Search(char* name){
	AVLNode *pCur = root;



	/* 
	¿¿ ¿¿¿ ¿¿¿ ¿¿¿ ¿¿¿ vector¿ ¿¿¿ heap¿ ¿¿¿¿ ¿¿¿
	¿¿ ¿¿ ¿¿, ¿¿¿ ¿¿¿ -- ¿¿ ¿¿ ¿ ¿ ¿¿ ¿¿
	*/
	
	StockData* pSD = pCur->getSD(); // pCur¿ name¿ ¿¿ AVL ¿¿¿ ¿¿¿
	vHeap.push_back( make_pair( make_pair(pSD->getAvgGrade(), pSD->getStockID()), pSD));
	push_heap(vHeap.begin(), vHeap.end(), compare);

	return true;
}

bool AVLTree::Rank(){
	/* Flowing code can be used, modified, deleted. -- When submit assignment, delete this comment */
	if(vHeap.empty())		return false;

	StockData* pSto;
	
	while(!vHeap.empty()){
		pStu = vHeap.front().second;
		pop_heap(vHeap.begin(), vHeap.end(), compare);
		vHeap.pop_back();
		printStockInfo(pSto);
	}
	return true;
}

void AVLTree::printStockInfo(StockData* pStockData){

}
