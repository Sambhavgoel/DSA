class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}
public class Insend{

    public static void main(String args[])
    {
        Node head=null;
        head=end(head,5);
        head=end(head,24);
        head=end(head,26);
        head=end(head,34);
        head=end(head,35);
        head=end(head,45);
        head=end(head,66);
        print(head);


    }
    public static Node end(Node head , int x)
    {
        Node temp = new Node(x);
        
       if(head==null)
       {
            return temp;
       }
       Node curr = head;
        
            while(curr.next!=null)
            {
                curr = curr.next;
            }

            curr.next=temp;
        
        
        return head;
    }
    public static void print(Node head)
    {
        if(head == null)
        {
            System.out.println("No such Linked list exists ");

        }
        else{
            while(head!=null)
            {
                System.out.println(head.data);
                head=head.next;
            }
        }
    }
}