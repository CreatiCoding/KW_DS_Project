#include "Vertex.h"
#include <iostream>
Vertex::Vertex()
{
    m_key = -1;
    m_size = 0;
    m_pEHead = NULL;
    m_pNext = NULL;
};
Vertex::Vertex(int key)
{
    m_key = key;
    m_size = 0;
    m_pEHead = NULL;
    m_pNext = NULL;
}
Vertex::~Vertex()
{
    Clear();
}

void Vertex::SetNext(Vertex *pNext)
{
    m_pNext = pNext;
}
int Vertex::GetKey() const
{
    return m_key;
}
Vertex *Vertex::GetNext() const
{
    return m_pNext;
}

int Vertex::Size() const
{
    return m_size;
}

void Vertex::AddEdge(int edgeKey, int weight)
{
    Edge *newE = new Edge(edgeKey, weight);
    Edge *curr = m_pEHead;
    Edge *prev = NULL;

    if (curr == NULL)
    {
        m_pEHead = newE;
        m_size++;
    }
    else
    {
        prev = curr;
        if (curr->GetNext() == NULL)
        {
            if (curr->GetKey() > newE->GetKey())
            {
                m_pEHead = newE;
                newE->SetNext(curr);
                return;
            }
            else
            {
                curr->SetNext(newE);
                return;
            }
        }
        while (curr->GetNext() != NULL)
        {
            if (curr->GetKey() > newE->GetKey())
            {
                if (curr == prev)
                {
                    m_pEHead = newE;
                    newE->SetNext(curr);
                    m_size++;
                    return;
                }
                else
                {
                    prev->SetNext(newE);
                    newE->SetNext(curr);
                    m_size++;
                    return;
                }
            }
            else
            {
                prev = curr;
                curr = curr->GetNext();
            }
        }
        if (curr->GetNext() == NULL)
        {
            if (curr->GetKey() > newE->GetKey())
            {
                prev->SetNext(newE);
                newE->SetNext(curr);
                m_size++;
                return;
            }
            else
            {
                curr->SetNext(newE);
                m_size++;
                return;
            }
        }
    }
}

Edge *Vertex::GetHeadOfEdge() const
{
    return m_pEHead;
}
void Vertex::Clear()
{
    Edge *curr = m_pEHead;
    while (curr != NULL)
    {
        Edge *willDel = curr;
        curr = curr->GetNext();
        delete willDel;
    }
}