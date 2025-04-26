class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class nend{
    public static void main(String args[])
    {
        Node head = new Node(23);
        head.next = new Node(64);
        head.next.next = new Node(84);
        head.next.next.next = new Node(65);
        head.next.next.next.next = new Node(26);
        head.next.next.next.next.next = new Node(96);
        head.next.next.next.next.next.next = new Node(26);

        print(head);
        end(head,7);
        

    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void end(Node head , int n)
    {
        Node first = head;
        Node second = head;
        for(int i=1;i<=n;i++)
        {
            first = first.next;
        }
        
        while(first!=null)
        {
            first = first.next;
            second = second.next;
        }
        if(second==null)
        {
            System.out.println("Wrong input");
            return;
        }
        System.out.println("From end is : "+second.data);
        return;
    }
}