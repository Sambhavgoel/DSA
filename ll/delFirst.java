class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next=null;
    }
}
class delFirst
{
    public static void main(String args[])
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        print(head);
        System.out.println("................................");
        head = del(head);
        
        print(head);
        System.out.println("................................");
        
        head = del(head);
        print(head);
        System.out.println("................................");

        head = del(head);
        print(head);
        System.out.println("................................");


        head = del(head);
        print(head);
        System.out.println("................................");

        head = del(head);
        print(head);
        System.out.println("................................");

    }
    public static Node del(Node head)
    {
        if(head==null)
        {
            return null;
        }
        return head.next;
    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
}