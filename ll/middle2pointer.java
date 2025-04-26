class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class middle2pointer{
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
        Node fast = head;
        Node slow = head;
        if(head==null)
        {
            System.out.println("No middle element exists ");
            return;
        }
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;

        }
        System.out.println("middle element : "+slow.data);
        return;
        
    }
}