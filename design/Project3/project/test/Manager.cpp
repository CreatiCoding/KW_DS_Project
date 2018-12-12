#include "Manager.h"
#include <cstring>
#include "MinHeap.h"
#include "Stack.h"

Manager::~Manager()
{
    if (fout.is_open())
        fout.close();

    if (ferr.is_open())
        ferr.close();
}

void Manager::Run(const char *filepath)
{
    fout.open(RESULT_LOG_PATH);
    ferr.open(ERROR_LOG_PATH);
    /*
    LOAD mapdata.txt
PRINT
DFS 0 3
DIJKSTRA 0 3
DFS 1 4
BELLMANFORD 1 4
DIJKSTRA -1 10
BELLMANFORD
ASTAR 1 4
    */
    string line;
    std::ifstream fin;
    fin.open("command.txt", std::ifstream::in);

    fin >> line;
    cout << line << endl;
    // if (line.compare("LOAD"))

    //    Load("mapdata.txt");
    //    FindPathDfs(0, 3);
    //    FindShortestPathDijkstraUsingSet(0, 3);
    //    m_graph.Print(fout);
    fin.close();
}
void Manager::PrintError(Result result)
{
    ferr << "Error code: " << result << std::endl;
}

Result Manager::Load(const char *filepath)
{
    std::ifstream fin;
    fin.open(filepath, std::ifstream::in);
    int size = 0;
    fin >> size;
    int **data = new int *[size];
    for (int i = 0; i < size; i++)
    {
        data[i] = new int[size];
        memset(data[i], 0, sizeof(int) * size);
        for (int j = 0; j < size; j++)
        {
            fin >> data[i][j];
        }
    }
    cout << "input is complete. size: " << size << endl;
    for (int i = 0; i < size; i++)
    {
        m_graph.AddVertex(i);
        for (int j = 0; j < size; j++)
        {
            if (data[i][j] != 0)
            {
                m_graph.AddEdge(i, j, data[i][j]);
            }
        }
    }

    for (int i = 0; i < size; i++)
        delete[] data[i];
    delete[] data;
    fin.close();
    return Result::Success;
}

Result Manager::Print()
{
    return Result::Success;
}
Result Manager::FindPathDfs(int startVertexKey, int endVertexKey)
{

    vector<int> path = m_graph.FindPathDfs(startVertexKey, endVertexKey);
    int *arr = new int[path.size()];
    int length = 0;

    fout << "===== DFS =====" << endl;
    fout << "shortest path: ";
    for (int i = 0; i < path.size(); i++)
    {
        fout << path.at(i) << " ";
        arr[i] = path.at(i);
        if (i != path.size() - 1)
        {
            Vertex *v = m_graph.FindVertex(path.at(i));
            Edge *e = v->GetHeadOfEdge();
            while (e != NULL)
            {
                if (e->GetKey() == path.at(i + 1))
                {
                    length += e->GetWeight();
                    break;
                }
                else
                {
                    e = e->GetNext();
                }
            }
        }
    }
    fout << endl;
    // 정렬
    for (int i = 0; i < path.size(); i++)
        for (int j = i; j < path.size(); j++)
            if (arr[i] > arr[j])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    fout << "sorted nodes: ";
    for (int i = 0; i < path.size(); i++)
    {
        fout << arr[i] << " ";
    }
    fout << endl;
    fout << "path length: " << length << endl;

    fout << "===============" << endl;
    return Result::Success;
}
Result Manager::FindShortestPathDijkstraUsingSet(int startVertexKey, int endVertexKey)
{
    vector<int> path = m_graph.FindShortestPathDijkstraUsingSet(startVertexKey, endVertexKey);

    int *arr = new int[path.size()];
    int length = 0;

    fout << "===== DIJKSTRA =====" << endl;
    fout << "shortest path: ";
    for (int i = 0; i < path.size(); i++)
    {
        fout << path.at(i) << " ";
        arr[i] = path.at(i);
        if (i != path.size() - 1 && path.at(i) != IN_FINITY)
        {
            cout << path.at(i) << endl;
            Vertex *v = m_graph.FindVertex(path.at(i));
            Edge *e = v->GetHeadOfEdge();
            while (e != NULL)
            {
                if (e->GetKey() == path.at(i + 1))
                {
                    length += e->GetWeight();
                    break;
                }
                else
                {
                    e = e->GetNext();
                }
            }
        }
    }
    fout << endl;
    // 정렬
    for (int i = 0; i < path.size(); i++)
        for (int j = i; j < path.size(); j++)
            if (arr[i] > arr[j])
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    fout << "sorted nodes: ";
    for (int i = 0; i < path.size(); i++)
    {
        fout << arr[i] << " ";
    }
    fout << endl;
    fout << "path length: " << length << endl;

    fout << "===============" << endl;
    return Result::Success;
}

//Result Manager::FindShortestPathDijkstraUsingMinHeap(int startVertexKey, int endVertexKey)
//{
//    // TODO: implement
//}
/// <summary>
/// find the shortest path from startVertexKey to endVertexKey with Bellman-Ford
/// </summary>
///
/// <param name="startVertexKey">
/// the start vertex key
/// </param>
/// <param name="endVertexKey">
/// the end vertex key
/// </param>
///
/// <returns>
/// Result::InvalidVertexKey or Result::GraphNotExist or Result::NegativeCycleDetected if exception has occurred.
/// Result::Success otherwise.
/// </returns>
//Result Manager::FindShortestPathBellmanFord(int startVertexKey, int endVertexKey)
//{
//    // TODO: implement
//}
