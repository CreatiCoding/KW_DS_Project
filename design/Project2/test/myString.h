#ifndef _mystring_h_
#define _mystring_h_

int strlength(void* str){
        int l=0;
        for(l=0;((char*)str)[l]!='\0';l++);
        return l;
}
int strlength(char* str){
        return strlength((void*)str);
}
int strlength(const char* str){
        return strlength((void*)str);
}
char* newConcate(void* str1, void* str2){
        int size_1 = strlength((char*)str1);
        int size_2 = strlength((char*)str2);
        int size = size_1 + size_2 + 1;
        char* newchar = new char[size];
        for(int i=0;i<size_1;i++)
                newchar[i] = ((char*)str1)[i];
        for(int i=0;i<size+2;i++)
                newchar[i+size_1] = ((char*)str2)[i];
        newchar[size]='\0';
        return newchar;
}
char* newConcate(char* str1, char* str2){
        return newConcate((void*)str1, (void*)str2);
}
char* newConcate(const char* str1, const char* str2){
        return newConcate((void*)str1, (void*)str2);
}
void printThenDelete(char* str){
	cout<<str<<endl;
	memset(str,0,strlength(str));
	delete str;
}
#endif
