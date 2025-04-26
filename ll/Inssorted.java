class Node{
    int data;
    Node next;
    Node(int x)
    {
        data=x;
        next = null;
    }
}
class Inssorted{
    public static void main(String args[])
    {
        Node head = null;
        head = sorted(head,99);
        head = sorted(head,50);
        head = sorted(head,56);
        head = sorted(head,10);
        head = sorted(head,10);
        head = sorted(head,15);

        print(head);
        
    }
    public static Node sorted(Node head,int x)
    {
        Node insert = new Node(x);
        
        
        if(head==null)
        {
            
            return insert;
        }
        if(x<head.data)
        {
            insert.next = head;
            return insert;
        }
        Node curr = head;
        while(curr.next != null && curr.next.data <x)
        {
            curr = curr.next;
        }
        insert.next = curr.next;
        curr.next = insert;
        

        return head;
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
