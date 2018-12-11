#include "Manager.h"
#include <stdlib.h>
using namespace std;

Manager::Manager()	//constructor
{
}


Manager::~Manager()//destructor
{
	/* You must fill here */
}

void Manager::run(const char * command)
{
	fin.open(command);
	flog.open("log.txt", ios::app);

	cmd = new char[40];

	while (!fin.eof())
	{
		/* You can write you code like example */

		/*---------	example------------
		fin.getline(cmd, 40);
		char * tmp = strtok(cmd, " ");

		if (strcmp(tmp, "LOAD") == 0){
			if (LOAD()) printSuccessCode("LOAD");
			else printErrorCode(100);
		}
		else	printErrorCode(0);
		--------------------------------
		*/
	}
	fin.close();
	flog.close();
	return;
}



void Manager::printErrorCode(int n) {				//ERROR CODE PRINT 
	flog << "======== ERROR ========" << endl;
	flog << n << endl;
	flog << "=======================" << endl << endl;
}

void Manager::printSuccessCode(const char * cmdname) {//SUCCESS CODE PRINT 
	flog << "======== "<<cmdname<<" ========" << endl;
	flog << "Success" << endl;
	flog << "=======================" << endl << endl;
}