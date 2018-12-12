//    std::vector<std::pair<TKey, TValue>> m_vec;
#include "MinHeap.h"

template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Push(TKey key, TValue value)
{
	m_vec.push_back(make_pair(key, value));
	// get element index and call heapify-up procedure
	Heapify(m_vec.size() - 1);
};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Pop()
{
	if (!IsEmpty())
	{
		m_vec.erase(m_vec.front());
	}
};
template <typename TKey, typename TValue>
std::pair<TKey, TValue> MinHeap<TKey, TValue>::Top()
{
	return m_vec.front();
};
template <typename TKey, typename TValue>
std::pair<TKey, TValue> MinHeap<TKey, TValue>::Get(TValue target){
	//for (std::vector<std::pair<TKey, TValue>>::iterator it = m_vec.begin(); it != m_vec.end(); ++it)
	//{
	//	if (it.second == target)
	//	{
	//		return it;
	//	}
	//}
	//
	//	return std::make_pair(-1, target);
};
template <typename TKey, typename TValue>
bool MinHeap<TKey, TValue>::IsEmpty()
{
	return m_vec.size() == 0;
};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::DecKey(TValue target, TKey newKey)
{
	std::pair<TKey, TValue> node = Get(target);
	if (node.first != -1)
	{
		node.first = newKey;
	}
};

template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Heapify(int index)
{
	// check if node at index i and its parent violates
	// the heap property
	if (index && m_vec.at((index - 1) / 2).second > m_vec.at(index).second)
	{
		// swap the two if heap property is violated
		std::pair<TKey, TValue> parent = m_vec.at((index - 1) / 2);
		m_vec.assign((index - 1) / 2, m_vec.at(index));
		m_vec.assign(index, parent);

		// call Heapify-up on the parent
		Heapify((index - 1) / 2);
	}
};
template <typename TKey, typename TValue>
void MinHeap<TKey, TValue>::Print(int index)
{
	//cout << " " << m_vec.at(index).second << endl;
}