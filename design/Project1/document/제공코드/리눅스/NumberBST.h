#pragma once
#include "NumberNode.h"
#include <iostream>


class NumberBST
{
private:
	NumberNode * root;
	int nodeCnt;

public:
	NumberBST();
	~NumberBST();


	void		Insert(NumberNode * node);			// LOAD, MOVE
	NumberNode *	Delete(int num);				// COMPLETE
	NumberNode *	Search(int num);				// ADD, COMPLETE, SEARCH
	bool		Print(char * BST);					// PRINT
	bool		Save();								// SAVE
	void		Inorder(NumberNode *node);
	void		Preorder(NumberNode *node);
	void		Postorder(NumberNode *node);
	int			getCnt();
	void		setCnt(int cnt);
};