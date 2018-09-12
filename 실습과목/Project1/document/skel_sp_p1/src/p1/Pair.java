package p1;

public class Pair<F,S> {
    public F first;
    public S second;

    public Pair(F first, S second) 
    {
      this.first = first;
      this.second = second;
    }
    public Pair() 
    {
        this.first = null;
        this.second = null;
    }

    static <F,S> Pair<F,S> of(F first, S second)
    {
        return new Pair<F,S>(first, second);
    }
  }