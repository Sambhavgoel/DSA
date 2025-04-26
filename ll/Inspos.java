class Node{
    int data;
    Node next;
    Node(int x)
    {
        data =x;
        next = null;
    }
}
class Inspos{
    public static void main(String args[])
    {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        print(head);
        System.out.println("......................................");
        head=ins(head,1,34);
        print(head);
    }
    public static Node ins(Node head , int x,int value)
    {
        
        Node insert = new Node(value);
        if(x==1)
        {
            insert.next = head;
          
            return insert;
        }
        int count=1;
        Node curr = head;
        Node temp = curr.next;
        x--;
        while(count<x)
        {
            curr = curr.next;
            temp = temp.next;
            count++;
        }
        if(curr == null)
        {
            return head;
        }
        curr.next = insert;
        insert.next = temp;
        return head;
    }
    public static void print(Node head){
        while(head!=null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
}