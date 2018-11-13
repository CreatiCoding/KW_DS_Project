#include "AVLTree.h"
#include "../test/myString.h"
/*
int compareAVLNode(AVLNode* node1, AVLNode* node2){
	if(node1 == NULL || node1->getSD() == NULL){
		return -1;
	}else if(node2 == NULL || node2->getSD() == NULL){
		return 1;
	}
	double node1_earn = node1->getSD()->getEarning();
	double node2_earn = node2->getSD()->getEarning();
	if(node1_earn > node2_earn)
		return 1;
	else if(node1_earn < node2_earn)
		return -1;
	else
		return 0;
}*/
int compareAVLNode(AVLNode* node1, AVLNode* node2){
	if(node1 == NULL || node1->getSD() == NULL) return -1;
	else if(node2 == NULL || node2->getSD() == NULL) return 1;
	char* node1_str = node1->getSD()->getName();
	char* node2_str = node2->getSD()->getName();
	return strcmp(node1_str, node2_str);
}
AVLTree::AVLTree(ofstream* fout){
	root=NULL;
	make_heap(vHeap.begin(), vHeap.end(), compare);
	this->fout = fout;
}

AVLTree::~AVLTree(){

}

bool AVLTree::Insert(StockData* pSto){
	AVLNode* pNew = new AVLNode;
	pNew->setSD(pSto);	
	char	*pName = pSto->getName();
	int		rotation = 0;

	if(root == NULL){
		root = pNew;
		return true;
	}

	AVLNode* pNode = root;
	AVLNode* ppNode = NULL;
	AVLNode* aNode = root;
	AVLNode* paNode = NULL;
	AVLNode* subRoot = NULL;

	while(pNode != NULL){
		if(pNode->getBF() != 0){
			aNode = pNode;
			paNode = ppNode;
		}
		if(compareAVLNode(pNew, pNode)==-1){
			ppNode = pNode;
			pNode = pNode->getLeft();
		}else if(compareAVLNode(pNew, pNode)==1){
			ppNode = pNode;
			pNode = pNode->getRight();		
		}else{
			pNode->setSD(pNew->getSD());
			return true;
		}
	}


	if(compareAVLNode(ppNode, pNew) == 1){
		ppNode->setLeft(pNew);
	}else if(compareAVLNode(ppNode, pNew) == -1){
		ppNode->setRight(pNew);
	}
	int d;
	AVLNode* bNode, * cNode;

	if(compareAVLNode(aNode, pNew) == -1){
		bNode = pNode = aNode->getRight();
		d = -1;
	}else{
		bNode = pNode = aNode->getLeft();
		d = 1;	
	}
	while(pNode != pNew){
		if(compareAVLNode(pNew, pNode)==1){
			pNode->setBF(-1);
			pNode = pNode->getRight();
		}else{
			pNode->setBF(1);
			pNode = pNode->getLeft();
		}
		
	}

	if((aNode->getBF() == 0) || ((aNode->getBF()+d) == 0)){
		aNode->setBF(aNode->getBF()+ d);
		return true;
	}
	if(d==1){
		if(bNode->getBF() == 1){
			aNode->setLeft(bNode->getRight());
			bNode->setRight(aNode);
			aNode->setBF(0);
			bNode->setBF(0);
			subRoot = bNode;
		}else{
			cNode= bNode->getRight();
			bNode->setRight(cNode->getLeft());
			aNode->setLeft(cNode->getRight());
			cNode->setLeft(bNode);
			cNode->setRight(aNode);
			switch(cNode->getBF()){
				case 0:
					bNode->setBF(0);
					aNode->setBF(0);
					break;
				case 1:
					bNode->setBF(0);
					aNode->setBF(-1);
					break;
				case -1:
					bNode->setBF(1);
					aNode->setBF(0);
					break;
			}
			cNode->setBF(0);
			subRoot= cNode;
		}
	}else{
		if(bNode->getBF() == -1){
			aNode->setRight(bNode->getLeft());
			bNode->setLeft(aNode);
			aNode->setBF(0);
			bNode->setBF(0);
			subRoot = bNode;
		}else{
			cNode = bNode->getLeft();
			bNode->setLeft(cNode->getRight());
			aNode->setRight(cNode->getLeft());
			cNode->setRight(bNode);
			cNode->setLeft(aNode);
			switch(cNode->getBF()){
				case 0:
					bNode->setBF(0);
					aNode->setBF(0);
					break;
				case 1:
					bNode->setBF(-1);
					aNode->setBF(0);
					break;
				case -1:
					aNode->setBF(1);
					bNode->setBF(0);
					break;
			}
			cNode->setBF(0);
			subRoot = cNode;
		}
	}
	if(paNode == NULL)
		root = subRoot;
	else if(aNode == paNode->getLeft())
		paNode->setLeft(subRoot);
	else
		paNode->setRight(subRoot);
	return true;
}

bool AVLTree::Print(){
	this->inorderPrint(root);
	return true;
}
void AVLTree::inorderPrint(AVLNode* node){
	if(node == NULL) return ;
	cout<<node->getSD()->toString();
	inorderPrint(node->getLeft());
	this->printStockInfo(node->getSD());
	inorderPrint(node->getRight());
}
bool AVLTree::Search(char* name){
	AVLNode *pCur = root; 
	pCur = inorderSearch(pCur, name);
	if(pCur == NULL) return false;
	StockData* pSD = pCur->getSD();
	vHeap.push_back( make_pair( make_pair(pSD->getEarning(), pSD->getStockID()), pSD));
	push_heap(vHeap.begin(), vHeap.end(), compare);
	(*fout)<<pSD->toString()<<endl;	
	return true;
}

AVLNode* AVLTree::inorderSearch(AVLNode* node, char* keyword){
	if(node == NULL || node->getSD() == NULL) return NULL;
	int result = strcmp(node->getSD()->getName(), keyword);
	if(result == 0) return node;
	else if(result > 0) return inorderSearch(node->getLeft(), keyword);
	else return inorderSearch(node->getRight(), keyword);
}

bool AVLTree::Rank(){
	if(vHeap.empty()){
		cout<<"It is empty"<<endl;
		return false;
	}
	StockData* pSto;

	while(!vHeap.empty()){
		pSto = vHeap.front().second;
		pop_heap(vHeap.begin(), vHeap.end(), compare);
		vHeap.pop_back();
		printStockInfo(pSto);
	}
	return true;
}

void AVLTree::printStockInfo(StockData* pStockData){
	(*(this->fout))<<pStockData->toString()<<endl;
}
