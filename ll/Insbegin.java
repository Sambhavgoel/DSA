class Node{
    int data;
    Node next;
    Node(int x)
    {
        data=x;
        next=null;
    }
}
class Insbegin{
    public static void main(String args[])
    {
        Node head = null;
        head = insert(head,30);
        head = insert(head,20); 
        // print(head);
        head = insert(head,90);
        head = insert(head,70);
        head = insert(head,10);
        print(head);

    }
    public static Node insert(Node head,int x){
        
            Node temp = new Node(x);
            temp.next = head;
            
        
        return temp;
    }
    public static void print(Node head){
        if(head==null)
        {
            System.out.println("No such linked list is exists");
        }
        while(head!=null)
        {
            System.out.println(head.data);
            head=head.next;
        }
    }
}