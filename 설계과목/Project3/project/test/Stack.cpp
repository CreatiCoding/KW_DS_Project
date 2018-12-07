#include "Stack.h"

Stack:Stack(){
    m_pTop = NULL;
}
Stack:~Stack(){
    while(!IsEmpty())
        Pop();
}
void Stack:Push(T data){
    if(IsEmpty()){
        m_pTop = new StackNode(data);
    }else{
        StackNode *newTop = new StackNode(data);
        newTop->pNext = m_pTop;
        m_pTop = newTop;
    }
}
void Stack:Pop(){
    StackNode *delTop = m_pTop;
    m_pTop = m_pTop->pNext;
    delete delTop;
}
template <typename T>
T Stack:Top(){
    return m_pTop->Data;
}
bool Stack:IsEmpty(){
    return m_pTop == NULL;
}
