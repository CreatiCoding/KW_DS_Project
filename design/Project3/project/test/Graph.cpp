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

/// find the path from startVertexKey to endVertexKey with DFS (stack)
std::vector<int> Graph::FindPathDfs(int startVertexKey, int endVertexKey)
{
    // 방문기록
    bool *visit = new bool[m_vSize];
    for (int i = 0; i < m_vSize; i++)
        visit[i] = false;

    // 스택과 결과 벡터
    Stack<int> stack;
    vector<int> result;

    // 첫번째 v 방문
    stack.Push(startVertexKey);

    // 스택을 조사
    while (!stack.IsEmpty())
    {
        // 스택에서 꺼내오기 및 결과에 업데이트
        int current = stack.Top();
        result.push_back(current);
        visit[current] = true;
        stack.Pop();

        // 도달
        if (current == endVertexKey)
            break;

        // 스택에서 꺼내온 값으로 현재 v, e 업데이트
        Vertex *currentVertex = FindVertex(current);
        Edge *currentEdge = currentVertex->GetHeadOfEdge();

        // 연결된 모든 edge는 방문하지 않았으면 모두 stack에 삽입
        while (currentEdge != NULL)
        {
            if (!visit[currentEdge->GetKey()])
                stack.Push(currentEdge->GetKey());
            currentEdge = currentEdge->GetNext();
        }
    }
    return result;
}

/// find the shortest path from startVertexKey to endVertexKey with Dijkstra using std::set
std::vector<int> Graph::FindShortestPathDijkstraUsingSet(int startVertexKey, int endVertexKey)
{
    // key, weight
    std::set<pair<int, int>> sets;

    // 반환값
    vector<int> path;

    // 초기화
    sets.insert(make_pair(startVertexKey, 0));
    path.push_back(startVertexKey);

    while (!sets.empty())
    {
        // 세트에서 꺼내온 Vertex 와 Edge
        pair<int, int> curr = *(sets.begin());
        sets.erase(sets.begin());

        int s_key = curr.first;
        Vertex *vertex = FindVertex(s_key);
        if (vertex == NULL)
            continue;
        Edge *connectedEdge = vertex->GetHeadOfEdge();
        if (connectedEdge == NULL)
            continue;

        // 최소 거리 탐색
        int min_idx = connectedEdge->GetKey();
        int min = connectedEdge->GetWeight();
        connectedEdge = connectedEdge->GetNext();
        while (connectedEdge != NULL)
        {
            if (min > connectedEdge->GetWeight())
            {
                min_idx = connectedEdge->GetKey();
                min = connectedEdge->GetWeight();
            }
            if (connectedEdge->GetKey() == endVertexKey)
            {
                path.push_back(connectedEdge->GetKey());
                return path;
            }
            connectedEdge = connectedEdge->GetNext();
        }
        path.push_back(min_idx);
        sets.insert(make_pair(min_idx, min));
    }
    return path;
}
/*
/// find the shortest path from startVertexKey to endVertexKey with Dijkstra using MinHeap
std::vector<int> Graph::FindShortestPathDijkstraUsingMinHeap(int startVertexKey, int endVertexKey)
{
    throw std::exception("NOT IMPLEMENT");
}

/// find the shortest path from startVertexKey to endVertexKey with Bellman-Ford
std::vector<int> Graph::FindShortestPathBellmanFord(int startVertexKey, int endVertexKey)
{
    throw std::exception("NOT IMPLEMENT");
}

std::vector<vector<int>> Graph::FindShortestPathFloyd()
{
    throw std::exception("NOT IMPLEMENT");
}
*/