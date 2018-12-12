#ifndef MIN_HEAP_H
#define MIN_HEAP_H

#include <utility>
#include <vector>

template <typename TKey, typename TValue>
class MinHeap
{
private:
  // array for the elements which should be heap-sorted
  std::vector<std::pair<TKey, TValue>> m_vec;

public:
  MinHeap() {}

  /// <summary>
  /// insert key-value pair
  /// </summary>
  ///
  /// <param name="key">
  /// the key that is used for sorting
  /// </param>
  ///
  /// <param name="value">
  /// the value that is managed in this heap
  /// </param>
  void Push(TKey key, TValue value)
  {
    m_vec.push_back(make_pair(key, value));
    Heapify(m_vec.size() - 1);
  }
  /// <summary>
  /// remove the minimum element
  /// </summary>
  void Pop()
  {
    if (!IsEmpty())
    {
      m_vec.erase(m_vec.front());
    }
  }
  /// <summary>
  /// get the minimum element
  /// </summary>
  ///
  /// <returns>
  /// the minimum element
  /// </returns>
  std::pair<TKey, TValue> Top()
  {
    return m_vec.front();
  }
  /// <summary>
  /// get the key-value pair which the value is the same as the target
  /// </summary>
  ///
  /// <returns>
  /// the key-value pair which the value is the same as the target
  /// </returns>
  std::pair<TKey, TValue> Get(TValue target);
  /// <summary>
  /// check whether this heap is empty or not
  /// </summary>
  ///
  /// <returns>
  /// true if this heap is empty
  /// </returns>
  bool IsEmpty()
  {
    return m_vec.size() == 0;
  }
  /// <summary>
  /// change the key of the node which the value is the target.<para/>
  /// In general, the newKey should be smaller than the old key.<para/>
  /// </summary>
  ///
  /// <parma name="target">
  /// the target to change the key
  /// </param>
  ///
  /// <param name="newKey">
  /// new key for the target
  /// </param>
  void DecKey(TValue target, TKey newKey)
  {
    std::pair<TKey, TValue> node = Get(target);
    if (node.first != -1)
    {
      node.first = newKey;
    }
  }

  void Print(int index);

private:
  /// <summary>
  /// heap-sort, heapify.<para/>
  /// this function can be called recursively
  /// </summary>
  void Heapify(int index)
  {
    if (index && m_vec.at((index - 1) / 2).second > m_vec.at(index).second)
    {
      std::pair<TKey, TValue> parent = m_vec.at((index - 1) / 2);
      m_vec.assign((index - 1) / 2, m_vec.at(index));
      m_vec.assign(index, parent);
      Heapify((index - 1) / 2);
    }
  }
};

#endif
