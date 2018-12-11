#ifndef _BpTreeNode_H_
#define _BpTreeNode_H_

#include "StockData.h"

class BpTreeNode{
	private:
		BpTreeNode* pParent;
		BpTreeNode* pMostLeftChild;

	public:
		BpTreeNode(){
			pParent = NULL;
			pMostLeftChild = NULL;
		}

		void setMostLeftChild(BpTreeNode* pN)	{ pMostLeftChild = pN; }
		void setParent(BpTreeNode* pN)				{ pParent = pN; }

		BpTreeNode* getParent()						{ return pParent;	}
		BpTreeNode* getMostLeftChild()				{ return pMostLeftChild; }

		/*
		   virtual 함수 추가
		   */
		virtual void insertDataMap(double avgGrade, vector<pair<int, StockData*> > m)=0;
		virtual void deleteMap(double n)=0;
		virtual map< double, vector<pair<int, StockData*> > > *getDataMap() {};
		virtual map <double, BpTreeNode*>* getIndexMap(){};
};

#endif
