class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

class search{
    public static void main(String args[])
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        print(head);
        int res = search(head,40);
        System.out.println(res);
    }
    public static void print(Node head)
    {
        if(head==null)
        {
            System.out.println("There is no linked list exists");
        }
        while(head!=null)
        {
            System.out.println(head.data);
            head=head.next;
        }
    }
    // iterative
    // public static int search(Node head,int x)
    // {
    //     if(head == null)
    //     {
    //         return -1;
    //     }
    //     int count=0;
    //     while(head!=null)
    //     {
    //         count++;
    //         if(head.data==x)
    //         {
    //             System.out.println("The "+x+" is lie on position : "+count);
    //             return -1;
    //         }
    //         head=head.next;
    //     }
    //     return -1;
    // }
    //recursive
    public static int search(Node head,int x)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data==x)
        {
            return 1;
        }
        else{
            int res=search(head.next,x);
            if(res==-1) return -1;
            else return (res+1);
        }
    }
}