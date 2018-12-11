#include "BpTree.h"

BpTree::BpTree(ofstream* fout, int order = 3){
	root = NULL;
	this->order = order;
	this->fout = fout;
}

BpTree::~BpTree(){

}

void BpTree::Insert(StockData* pSto){
	/* ※ 과제 제출 시 본 주석 삭제
	아래 작성된 코드는 이용 또는 삭제, 변경이 가능하며
	그대로 이용할 경우, 반드시 주석 작성
	*/
	double key = pSto->getEarning();	// key = Earning
	vector<pair<int, StockData*> > value;			// value = vector< id, stock data* >
	value.push_back( make_pair(pSto->getStockID(), pSto) );	

	if(root == NULL){ // empty B+ tree
		BpTreeNode* pDataNode = new BpTreeDataNode;	
		pDataNode->insertDataMap(key, value);	
		root = pDataNode;
		return;
	}
		
	BpTreeNode* pDataNode = searchDataNode(key);	// seach data node with key
	
	map<double, vector<pair<int, StockData*> > > *m = pDataNode->getDataMap();

	/*
	코드 작성  (참고: if(m->find(key) == m->end()))
	*/
}

BpTreeNode* BpTree::searchDataNode(double n){
	/* ※ 과제 제출 시 본 주석 삭제
	아래 작성된 코드는 이용 또는 삭제, 변경이 가능하며
	그대로 이용할 경우, 반드시 주석 작성
	*/

	BpTreeNode* pCur = root;
	map<double, BpTreeNode*>::iterator itIndex;

	while(pCur->getMostLeftChild() != NULL){ 
		itIndex = pCur->getIndexMap()->begin();

		if(n < itIndex->first){ 
			pCur = pCur->getMostLeftChild();
		}else{
			while(true){
				itIndex++;
				if(itIndex == pCur->getIndexMap()->end() || n < itIndex->first){
					itIndex--;
					pCur = itIndex->second;
					break;
				}
			}
		}
	}

	return pCur;
}

void BpTree::splitDataNode(BpTreeNode* pDataNode){
	/* ※ 과제 제출시 본 주석 삭제
	아래 변수는 data node의 map에서 split이 발생하는 data의 위치를 일반화한 식이다.
	(다른 파티션으로 이동하는 데이터들의 첫 번째 데이터이자 index node로 복사되는 데이터의 위치)
	*/
	int splitPosition_data = ceil((order-1)/2.0) + 1;

	/*
	코드 작성
	*/
}

void BpTree::splitIndexNode(BpTreeNode* pIndexNode){
	/* ※ 과제 제출시 본 주석 삭제
	아래 변수는 index node의 map에서 split이 발생하는 index의 위치를 일반화한 식이다.
	(부모 노드로 이동(복사X)하는 데이터의 위치, 다음 index 부터는 다른 파티션으로 이동)
	*/
	int splitPosition_index = ceil(order/2.0);

	/*
	코드 작성
	*/
}

bool BpTree::exceedDataNode(BpTreeNode* pDataNode){
	/* 아래 작성된 코드는 이용 또는 삭제, 변경이 가능함 -- 과제 제출 시 본 주석 삭제*/
	map <double, vector<pair<int, StockData*> > > *m = pDataNode->getDataMap();

	if(m->size() > order-1)		return true;
	else								return false;
}

bool BpTree::exceedIndexNode(BpTreeNode* pIndexNode){
	/* 아래 작성된 코드는 이용 또는 삭제, 변경이 가능함 -- 과제 제출 시 본 주석 삭제*/
	map <double, BpTreeNode*>* m = pIndexNode->getIndexMap();
	
	if(m->size() > order-1)		return true;
	else								return false;
}



bool BpTree::Print(){

	return true;
}

bool BpTree::Search(double a, double b){

	return true;
}

void BpTree::printStockInfo(StockData* pStockData){

}
