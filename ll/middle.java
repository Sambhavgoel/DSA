class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class middle{
    public static void main(String args[])
    {
        Node head = new Node(23);
        head.next = new Node(64);
        head.next.next = new Node(84);
        head.next.next.next = new Node(65);
        head.next.next.next.next = new Node(26);
        head.next.next.next.next.next = new Node(96);
        head.next.next.next.next.next.next = new Node(26);
        // Node head = null;

        print(head);
        middle(head);
    }
    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
    public static void middle(Node head)
    {
        Node curr = head;
        Node temp = head;
        int count=0;
        while(curr!=null)
        {
            ++count;
            curr=curr.next;
        }
        for(int i=0;i<(count/2);i++)
        {
            temp = temp.next;
        }
        if(count==0)
        {
            System.out.println("There is no middle element ");
            return;
        }
        System.out.println("Middle element : "+temp.data);
    }
}