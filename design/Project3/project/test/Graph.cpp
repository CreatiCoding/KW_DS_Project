#include "Graph.h"
#include "Stack.h"
#include "MinHeap.h"
#include <set>
#define DFS_FIRST_PATH

Graph::Graph()
{
    m_vSize = 0;
}
Graph::~Graph()
{
    // TODO: implement
    Clear();
}

/// add vertex with vertexNum at the end of the linked list for the vertics
void Graph::AddVertex(int vertexKey)
{
    if (FindVertex(vertexKey) != NULL)
    {
        cout << "AddVertex::error::It already exists." << endl;
        return;
    }
    else if (m_pVHead == NULL)
    {
        m_vSize++;
        m_pVHead = new Vertex(vertexKey);
    }
    else
    {
        Vertex *tail = m_pVHead;
        while (tail->GetNext() != NULL)
        {
            tail = tail->GetNext();
        }
        m_vSize++;
        tail->SetNext(new Vertex(vertexKey));
    }
}

/// add edge from the vertex which the number is startVertexKey to the vertex which the number is endVertexKey
void Graph::AddEdge(int startVertexKey, int endVertexKey, int weight)
{
    Vertex *v = FindVertex(startVertexKey);
    if (v != NULL)
    {
        v->AddEdge(endVertexKey, weight);
    }
    else
    {
        cout << "AddEdge::error::Not found start vertex" << endl;
    }
}

/// get the vertex which the key is vertexNum
Vertex *Graph::FindVertex(int key)
{
    if (m_pVHead == NULL)
    {
        return NULL;
    }
    else
    {
        Vertex *curr = m_pVHead;
        if (curr->GetKey() == key)
        {
            return curr;
        }
        else
        {
            while (curr != NULL)
            {
                if (curr->GetKey() == key)
                {
                    return curr;
                }
                else
                {
                    curr = curr->GetNext();
                }
            }
            return NULL;
        }
    }
}

/// get the number of the vertics
int Graph::Size() const
{
    return m_vSize;
}

/// memory free for the vertics
void Graph::Clear()
{
    Vertex *curr = m_pVHead;
    while (curr != NULL)
    {
        Vertex *willDel = curr;
        curr = curr->GetNext();
        willDel->Clear();
    }
}

/// print out the graph as matrix form
void Graph::Print(std::ofstream &fout)
{
    int size = m_vSize;
    for (int i = 0; i < size; i++)
    {
        Vertex *v_i = FindVertex(i);
        if (v_i == NULL)
        {
            for (int j = 0; j < size; j++)
                fout << "0 ";
            fout << endl;
        }
        else
        {
            Edge *e_i = v_i->GetHeadOfEdge();
            if (e_i == NULL)
            {
                for (int j = 0; j < size; j++)
                {
                    fout << "0 ";
                }
                fout << endl;
            }
            else
            {
                for (int j = 0; j < size; j++)
                {
                    if (e_i != NULL && e_i->GetKey() == j)
                    {
                        fout << e_i->GetWeight() << " ";
                        e_i = e_i->GetNext();
                    }
                    else
                    {
                        fout << "0 ";
                    }
                }
                fout << endl;
            }
        }
    }
}

/// check whether the graph has negative edge or not.
bool Graph::IsNegativeEdge()
{
    Vertex *v_i = m_pVHead;
    while (v_i != NULL)
    {
        Edge *e_i = v_i->GetHeadOfEdge();
        while (e_i != NULL)
        {
            if (e_i->GetWeight() > 0)
            {
                return true;
            }
            else
            {
                e_i = e_i->GetNext();
            }
        }
        v_i = v_i->GetNext();
    }
    return false;
}
/*
/// find the path from startVertexKey to endVertexKey with DFS (stack)
std::vector<int> Graph::FindPathDfs(int startVertexKey, int endVertexKey)
{
    bool *visit = new bool[m_vSize];
    for (int i = 0; i < m_vSize; i++)
        visit[i] = false;

    Stack<int> stack;
    Stack<int> result;
    vector<int> path;
    stack.Push(startVertexKey);
    result.Push(startVertexKey);

    visit[startVertexKey] = true;

    while (!stack.IsEmpty())
    {
        Vertex *vv = FindVertex(stack.Top());
        stack.Pop();
        bool flag = false;
        Edge *e = vv->GetHeadOfEdge();

        for (int i = 1; i <= m_vSize; i++)
        {
            if (e == NULL)
            {
                stack.Pop();
                result.Pop();
                break;
            }
            else if (visit[e->GetKey()])
            {
                e = e->GetNext();
                continue;
            }
            else
            {
                Vertex *vvv = FindVertex(e->GetKey());
                if (vvv == NULL)
                {
                    stack.Pop();
                    result.Pop();
                    break;
                }
                stack.Push(vvv->GetKey());
                result.Push(vvv->GetKey());
                visit[e->GetKey()] = true;
                flag = true;
            }
        }
        if (!flag)
        {
            stack.Pop();
        }
    }
    while (!result.IsEmpty())
    {
        path.push_back(result.Top());
        result.Pop();
    }
    return path;
}*/

/// find the shortest path from startVertexKey to endVertexKey with Dijkstra using std::set
//std::vector<int> Graph::FindShortestPathDijkstraUsingSet(int startVertexKey, int endVertexKey) {}

/// find the shortest path from startVertexKey to endVertexKey with Dijkstra using MinHeap
//std::vector<int> Graph::FindShortestPathDijkstraUsingMinHeap(int startVertexKey, int endVertexKey) {}

/// find the shortest path from startVertexKey to endVertexKey with Bellman-Ford
//std::vector<int> Graph::FindShortestPathBellmanFord(int startVertexKey, int endVertexKey) {}

//std::vector<vector<int>> Graph::FindShortestPathFloyd() {}
