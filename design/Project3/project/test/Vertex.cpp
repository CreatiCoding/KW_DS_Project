#include "Vertex.h"

/**
     *  int m_key;
     *  int m_size;
     *  Edge* m_pEHead;
     *  Vertex* m_pNext;
    */

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
    }
    else
    {
        if (curr->GetKey() > newE->GetKey())
        {
            m_pEHead = newE;
            newE->SetNext(curr);
            return;
        }
        while (curr != NULL)
        {
            if (curr->GetKey() < newE->GetKey())
            {
                prev = curr;
                curr = curr->GetNext();
            }
            else
            {
                prev->SetNext(newE);
                newE->SetNext(curr);
                break;
            }
        }
        if (curr == NULL)
        {
            prev->SetNext(newE);
        }
    }
}

Edge *Vertex::GetHeadOfEdge() const
{
    return m_pEHead;
}
/// memory free for edges
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