#include "Manager.h"

Manager::Manager(int bpOrder){
	fout.open("log.txt", ios::app);
	avl = new AVLTree(&fout);
	bp = new BpTree(&fout, bpOrder);	
}

Manager::~Manager(){
	delete avl;
	delete bp;
	fout.close();
}

void Manager::run(const char* command_txt){
	/* 아래 작성된 코드는 이용 또는 삭제, 변경이 가능함 -- 과제 제출 시 본 주석 삭제*/
	ifstream fin;		fin.open(command_txt);
	int	load = -1;
		
	if(!fin){
		cout<<"[ERROR] command file open error!"<<endl;
		return;
	}

	char*	str=NULL;
	char	buf[128]={0};
	char	buf2[128]={0};

	while(fin.getline(buf, 64)){
		strcpy(buf2, buf);
		str=strtok(buf, " \n");	
		
		if(strcmp(str, "LOAD") == 0){
			if(load == 1){
				printErrorCode(100);
			}else if((str=strtok(NULL, " \n")) != NULL || !LOAD()){
				printErrorCode(100);
			}
			load = 1;
		}
		else if(strcmp(str, "SEARCH_AVL") == 0){

		}
		else if(strcmp(str, "SEARCH_BP") == 0){

		}
		else if(strcmp(str, "RANK") == 0){

		}
		else if(strcmp(str, "PRINT_AVL") == 0){

		}
		else if(strcmp(str, "PRINT_BP") == 0){

		}
		fout<<endl;
	}	
	fin.close();
}

bool Manager::LOAD(){
	/* 아래 작성된 코드는 이용 또는 삭제, 변경이 가능함 -- 과제 제출 시 본 주석 삭제*/
	char*	str=NULL;
	char	buf[128]={0};
	char	buf2[128]={0};

	ifstream fin;
	fin.open("stock_list.txt");
	
	if(!fin){
		return false;
	}
		
	while(fin.getline(buf, 64)){
		StockData* pSto;
		strcpy(buf2, buf);

		str = strtok(buf, " ");
		str = strtok(NULL, " ");
		str = strtok(NULL, " ");
		pSto = new StockData();

		str = strtok(buf2, " ");
		pSto->setStockID(atoi(str));
		str = strtok(NULL, " ");
		pSto->setName(str);
		int open = atoi(strtok(NULL, " "));
		pSto->setOpening_Price(open);
		int close = atoi(strtok(NULL, " "));
		pSto->setClosing_Price(close);
		int volume = atoi(strtok(NULL, " "));
		pSto->setVolume(volume);

		pSto->setEarning(open, close);

		avl->Insert(pSto);
		bp->Insert(pSto);
	}
	return true;
}

bool Manager::SEARCH_AVL(char* name){
	if(!avl->Search(name))	return false;
	else							return true;
}

bool Manager::SEARCH_BP(double a, double b){
	if(!bp->Search(a, b))			return false;
	else											return true;
}

bool Manager::RANK(){
	if(avl->Rank())		return false;
	else					return true;
}

bool Manager::PRINT_AVL(){
	if(!avl->Print())	return false;
	else					return true;
}

bool Manager::PRINT_BP(){
	if(!bp->Print())		return false;
	else					return true;
}

void Manager::printErrorCode(int n){
	fout<<"======== ERROR ========"<<endl;
	fout<<n<<endl;
	fout<<"======================="<<endl;
}
