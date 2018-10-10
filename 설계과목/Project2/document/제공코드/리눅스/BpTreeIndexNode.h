#ifndef _BPTREEINDEXNODE_H_
#define _BPTREEINDEXNODE_H_

#include "BpTreeNode.h"

class BpTreeIndexNode : public BpTreeNode{
private:
	map <double, BpTreeNode*> mapIndex;
	
public:
	BpTreeIndexNode(){}
	~BpTreeIndexNode(){}
	
	void insertIndexMap(double n, BpTreeNode* pN){
		// 코드 작성
	}

	void deleteMap(double n){
		// 코드 작성
	}

	map <double, BpTreeNode*>* getIndexMap()	{ return &mapIndex; }
};

#endif