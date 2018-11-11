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

/*  ※ 과제 제출 시 본 주석 삭제
구현 편의성을 위해 함수에 코드가 작성되어 있으며, 해당 코드는 이용 또는 삭제, 변경이 가능함.
또한, 일부 코드는 과제 요구사항에 맞게 변경이 필요할 수 있음
*/

class StockData{
private:
	int			StockID;		// 종목고유번호
	char		Name[10];		// 종목이름
	double	Earning;		// 수익률
	int Opening_Price;		//시가
	int Closing_Price;		//종가
	int Volume;				//거래량

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
	/* 아래 작성된 코드는 이용 또는 삭제, 변경이 가능함 -- 과제 제출 시 본 주석 삭제*/
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
	virtual 함수 추가
	*/
};

bool compare(pair< pair< double, int>, StockData* > a, pair< pair< double, int>, StockData* > b);

#endif
