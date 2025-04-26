class MyStack{
    ArrayList<Integer> al = new ArrayList<Integer>();

    void push(int x)
    {
        al.add(x);
    }
    int pop()
    {
        int res = al.get(al.size()-1);
        al.remove(al.size()-1);
        return res;
    }
    int peek()
    {
        return(al.get(al.size()-1));
    }
    boolean isEmpty()
    {
        return al.isEmpty();
    }
    int size()
    {
        return al.size();
    }
}