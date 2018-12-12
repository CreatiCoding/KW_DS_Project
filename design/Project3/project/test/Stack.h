#ifndef STACK_H
#define STACK_H

#ifndef NULL
#define NULL 0
#endif

template <typename T>
class Stack
{
private:
  class StackNode
  {
  public:
    T Data;
    StackNode *pNext;

    StackNode(T data) : Data(data), pNext(NULL) {}
  };

private:
  StackNode *m_pTop;
  int m_size;

public:
  Stack()
  {
    m_pTop = NULL;
    m_size = 0;
  }
  ~Stack()
  {
    while (!IsEmpty())
      Pop();
  }

  void Push(T data)
  {
    if (IsEmpty())
    {
      m_pTop = new StackNode(data);
      m_size++;
    }
    else
    {
      StackNode *newTop = new StackNode(data);
      newTop->pNext = m_pTop;
      m_pTop = newTop;
      m_size++;
    }
  }
  void Pop()
  {
    if (m_pTop == NULL)
      return;
    StackNode *delTop = m_pTop;
    m_pTop = m_pTop->pNext;
    delete delTop;
    m_size--;
  }
  T Top()
  {
    return m_pTop->Data;
  }
  bool IsEmpty()
  {
    return m_pTop == NULL;
  }
  int Size()
  {
    return m_size;
  }
};

#endif
