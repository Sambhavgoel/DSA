class MyStack
{
    int arr[];
    int cap;
    int top;
    MyStack(int c)
    {
        top=-1;
        cap = c;
        arr = new int[cap];
    }
    void push(int x)
    {
        if(top==cap-1)
        {
            Syste.out.println("Overflow : The stack is full");
            return;
        }
        top++;
        arr[top]=x;
    }
    int pop()
    {
        if(top==-1)
        {
            System.out.println("underflow : There is no element left in array");
            return;
        }
        int res = arr[top];
        top--;
        return res;
    }
    int peek()
    {
        if(top==-1)
        {
            System.out.println("underflow : There is no element left in array");
            return;
        }
        return arr[top];
    }
    int size()
    {
        return top+1;
    }
    boolean isEmpty()
    {
        return (top==-1);
    }
}

class imple{
    public static void main(String args[])
    {
        MyStack s = new MyStack(5);
        s.push(34);
        s.push(22);
        System.out.println(s.pop());
        s.push(30);

    }
}