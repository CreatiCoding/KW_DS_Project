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

/*  ?? ??Á¦ Á¦?? ?? ?? ?Ö¼? ??Á¦
???? ???Ç¼?À» À§?? ?Ô¼??? ?Úµå°¡ ?Û¼??Ç¾? ??À¸??, ?Ø´? ?Úµ??? ?Ì¿? ?Ç´? ??Á¦, ?????? ??????.
????, ?Ïº? ?Úµ??? ??Á¦ ?ä±¸???×¿? ?Â°? ?????? ?Ê¿??? ?? ??À½
*/

class StockData{
private:
	int			StockID;		// Á¾????À¯??È£
	char		Name[20];		// Á¾???Ì¸?
	double	Earning;		// ???Í·?
	int Opening_Price;		//?Ã°?
	int Closing_Price;		//Á¾??
	int Volume;				//?Å·???

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
	/* ?Æ·? ?Û¼??? ?Úµ??? ?Ì¿? ?Ç´? ??Á¦, ?????? ?????? -- ??Á¦ Á¦?? ?? ?? ?Ö¼? ??Á¦*/
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
		sprintf(buf, "%d %s %lf\nì‹œê°€: %d\nì¢…ê°€: %d\nê±°ëž˜ëŸ‰: %d\nìˆ˜ìµë¥ : %lf\n",this->StockID, this->Name, this->Earning, this->Opening_Price, this->Closing_Price, this->Volume, this->Earning);
		return buf;
	}
	/*
	virtual ?Ô¼? ?ß°?
	*/
};

bool compare(pair< pair< double, int>, StockData* > a, pair< pair< double, int>, StockData* > b);

#endif
