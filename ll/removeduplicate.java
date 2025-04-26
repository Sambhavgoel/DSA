class Node{
    int data;
    Node next;
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class removeduplicate{
    public static void main(String args[])
    {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(10);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(20);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next = new Node(30);

        print(head);
        duplicate(head);
        System.out.println("After remove duplicates : ");
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
    public static void duplicate(Node head)
    {
        if(head==null)
        {
            System.out.println("There is no linked list ");
            return;
        }
        Node curr = head;
        
        while(curr.next!=null)
        {
            if(curr.data!=curr.next.data)
            {
                curr = curr.next;
            }
            else{
                curr.next=curr.next.next;
            }
        }
        
    }
    
}