class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class reverse{
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
        head = reversell(head);
        System.out.println("After reverse : ");
        print(head);
        

    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static Node reversell(Node head)
    {
        Node curr = head;
        Node prev = null;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}