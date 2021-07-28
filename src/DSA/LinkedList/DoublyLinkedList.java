package DSA.LinkedList;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class DoublyLinkedList<E extends Number> {

    class Node{
        E data;
        Node next,prev;
        Node(E data){
            this.data=data;
        }
    }
    Node head;

    void insertNode(E data){
        Node newNode=new Node(data);

        if(head==null){
            head=newNode;
        }
        else{
            Node lastNode=head;
            while(lastNode.next!=head){
                lastNode=lastNode.next;
            }
            lastNode.next=newNode;
            newNode.prev=lastNode;
            newNode.next=head;
        }
    }

    void traverse(){
        Node current=head;
       do{
            System.out.print(current.data+" ");
            current=current.next;
        }
        while(current!=head);
        System.out.println();
    }

    void delete(E data){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node current=head;
        Node temp;
        while(current.next!=null){
            current=current.next;
            if(current.data.equals(data)){
               temp=current.prev;
               temp.next=current.next;
               if(current.next!=null){
                   current.next.prev=temp;
               }
               return;
            }
        }
        System.out.println("Item not found");
    }

    void sort(){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        Node pointer;
        Node current=head;
        while(current.next!=null){
            pointer=current.next;
            while(pointer!=null){
                if( Double.valueOf( current.data.toString())>Double.valueOf( pointer.data.toString())){
                    E temp=current.data;
                    current.data=pointer.data;
                    pointer.data=temp;
                }
                pointer=pointer.next;
            }
            current=current.next;
        }
    }

}
