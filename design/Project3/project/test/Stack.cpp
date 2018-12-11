#include "Stack.h"

template <typename T>
Stack<T>::Stack()
{
    m_pTop = NULL;
}

template <typename T>
Stack<T>::~Stack()
{
    while (!IsEmpty())
        Pop();
}
template <typename T>
void Stack<T>::Push(T data)
{
    if (IsEmpty())
    {
        m_pTop = new StackNode(data);
    }
    else
    {
        StackNode *newTop = new StackNode(data);
        newTop->pNext = m_pTop;
        m_pTop = newTop;
    }
}
template <typename T>
void Stack<T>::Pop()
{
    StackNode *delTop = m_pTop;
    m_pTop = m_pTop->pNext;
    delete delTop;
}

template <typename T>
T Stack<T>::Top()
{
    return m_pTop->Data;
}

template <typename T>
bool Stack<T>::IsEmpty()
{
    return m_pTop == NULL;
}
