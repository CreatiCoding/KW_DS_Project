#ifndef _STUDENTDATA_H_
#define _STUDENTDATA_H_

#include <iostream>
#include <cstring>
#include <fstream>
#include <map>
#include <math.h>
#include <vector>
#include <algorithm>
#include <deque>
#include <queue>
#include <stack>

using namespace std;

/*  �� ���� ���� �� �� �ּ� ����
���� ���Ǽ��� ���� �Լ��� �ڵ尡 �ۼ��Ǿ� ������, �ش� �ڵ�� �̿� �Ǵ� ����, ������ ������.
����, �Ϻ� �ڵ�� ���� �䱸���׿� �°� ������ �ʿ��� �� ����
*/

class StockData{
private:
	int			StockID;		// ���������ȣ
	char		Name[10];		// �����̸�
	double	Earning;		// ���ͷ�
	int Opening_Price;		//�ð�
	int Closing_Price;		//����
	int Volume;				//�ŷ���

public:
	StockData() {
		StockID = 0;
		memset(Name, 0, 10);
		Earning = 0;
		Opening_Price = 0;
		Closing_Price = 0;
		Volume = 0;
	};
	~StockData() {};

	void setStockID(int a) { StockID = a; }
	void setName(char* a) { strcpy(Name, a); }
	void setOpening_Price(int a) { Opening_Price = a; }
	void setClosing_Price(int a) { Closing_Price = a; }
	void setVolume(int a) { Volume = a; }	
	/* �Ʒ� �ۼ��� �ڵ�� �̿� �Ǵ� ����, ������ ������ -- ���� ���� �� �� �ּ� ����*/
	void setEarning(int a, int b)
	{
		Earning = (b - a) / (double)a;
	}
	

	int			getStockID() { return StockID; }
	char*		getName() { return Name; }
	double	getEarning() { return Earning; }
	int getOpening_Price() { return Opening_Price; }
	int getClosing_Price() { return Closing_Price; }
	int getVolume() { return Volume; }

	/*
	virtual �Լ� �߰�
	*/
};

bool compare(pair< pair< double, int>, StockData* > a, pair< pair< double, int>, StockData* > b);

#endif
