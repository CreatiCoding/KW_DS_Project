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

/*  ?? ??�� ��?? ?? ?? ?ּ? ??��
???? ???Ǽ?�� ��?? ?Լ??? ?ڵ尡 ?ۼ??Ǿ? ??��??, ?ش? ?ڵ??? ?̿? ?Ǵ? ??��, ?????? ??????.
????, ?Ϻ? ?ڵ??? ??�� ?䱸???׿? ?°? ?????? ?ʿ??? ?? ??��
*/

class StockData{
private:
	int			StockID;		// ��????��??ȣ
	char		Name[20];		// ��???̸?
	double	Earning;		// ???ͷ?
	int Opening_Price;		//?ð?
	int Closing_Price;		//��??
	int Volume;				//?ŷ???

public:
	StockData() {
		StockID = 0;
		memset(Name, 0, 20);
		Earning = 0;
		Opening_Price = 0;
		Closing_Price = 0;
		Volume = 0;
	};
	~StockData() {};

	void setStockID(int a) { StockID = a; }
	void setName(char* a) {
		memset(Name, 0, 20);
		char*p=a;
		int i=0;
		for(;p[i]!='\0';i++) Name[i] = p[i];
		Name[i] = '\0';
	}
	void setOpening_Price(int a) { Opening_Price = a; }
	void setClosing_Price(int a) { Closing_Price = a; }
	void setVolume(int a) { Volume = a; }	
	/* ?Ʒ? ?ۼ??? ?ڵ??? ?̿? ?Ǵ? ??��, ?????? ?????? -- ??�� ��?? ?? ?? ?ּ? ??��*/
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
	char* toString(){
		char *buf = new char[256];
		memset(buf, 0, 256);
		sprintf(buf, "%d %s %lf\n시가: %d\n종가: %d\n거래량: %d\n수익률: %lf\n",this->StockID, this->Name, this->Earning, this->Opening_Price, this->Closing_Price, this->Volume, this->Earning);
		return buf;
	}
	/*
	virtual ?Լ? ?߰?
	*/
};

bool compare(pair< pair< double, int>, StockData* > a, pair< pair< double, int>, StockData* > b);

#endif
