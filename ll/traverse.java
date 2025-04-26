class Node{
    int data;
    Node next;
    Node(int x)
    {
        data=x;
        next=null;
    }
}

class traverse{
    public static void main(String args[]){
        Node head = new Node(10);
        head.next= new Node(20);
        head.next.next= new Node(30);
        head.next.next.next= new Node(40);

        printlist(head);

    }

    // public static void printlist(Node head){
    //     Node temp=head;
    //     while(temp!=null)
    //     {
    //         System.out.println(temp.data);
    //         temp=temp.next;
    //     }
    // }


    public static void printlist(Node head){
        
        if(head==null)
        {
            return;
        }
        System.out.println(head.data);
        printlist(head.next);
    }


}