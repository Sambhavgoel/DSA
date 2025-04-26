import java.util.*;

class collect{
    public static void main(String args[])
    {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("a");
        list.addFirst("is");
        list.addLast("list");
        list.addFirst("this");
        System.out.println(list);
        System.out.println(list.size());// to get the size of list

        for(int i=0;i<list.size();i++)
        {
            
            System.out.print(list.get(i)+" -> ");
        }
        System.out.println("null");
        // only add is default addLast

        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        list.remove(0);
        System.out.println(list);

    }
}