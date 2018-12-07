//    std::vector<std::pair<TKey, TValue>> m_vec;
#include "MinHeap.h"

template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Push(TKey key, TValue value){};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Pop(){};
template <typename TKey, typename TValue>
std::pair<TKey, TValue> MinHeap<TKey, TValue>::Top(){};
template <typename TKey, typename TValue>
std::pair<TKey, TValue> MinHeap<TKey, TValue>::Get(TValue target){};
template <typename TKey, typename TValue>
bool MinHeap<TKey, TValue>::IsEmpty(){};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::DecKey(TValue target, TKey newKey){};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Heapify(int index){};