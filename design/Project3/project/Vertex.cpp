#include "Vertex.h"

    /**
     *  int m_key;
     *  int m_size;
     *  Edge* m_pEHead;
     *  Vertex* m_pNext;
    */
    
    Vertex(){

    }
    Vertex(int key){
        m_key = key;
    }
    ~Vertex(){
        Clear();
    }

    void SetNext(Vertex* pNext){
        m_pNext = pNext;
    }
    int GetKey() const{
        return m_key;
    }
    Vertex* GetNext() const{
        return m_pNext;
    }

    int Size() const{
        return m_size;
    }

    void AddEdge(int edgeKey, int weight){
        Edge *newE = new Edge(key, weight);
        Edge *curr = m_pEHead;
        Edge *prev = NULL;

        if(curr == NULL){
            curr = e;
        }else{
            prev = curr;
            while(curr != NULL){
                if(curr->GetKey() < newE->GetKey()){
                    curr = curr->GetNext();
                }else{
                    prev->SetNext(newE);
                    newE->SetNext(curr);
                    break;
                }
            }
            if(curr == NULL){
                prev->SetNext(newE);
            }
        }
    }
    
    Edge* GetHeadOfEdge() const{
        return m_pEHead;
    }
    /// memory free for edges
    void Clear(){
        Edge *curr = m_pEHead;
        while(curr != NULL){
            Edge *willDel = curr;
            curr = curr->GetNext();
            delete willDel;
        }
    }