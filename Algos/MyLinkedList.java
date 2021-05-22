public class MyLinkedList
{
    private Node head;

    public Node getHead()
    {
        return this.head;
    }

    public void setHead(Node head)
    {
        this.head = head;
    }

    private int size = 0;

    public int getSize()
    {
        return this.size;
    }

    public void calculateSize() {
        this.size = 0;
        Node tmp = this.head;
        while(tmp != null) {
            size++;
            tmp = tmp.next;
        }
    }

    // addFirst: method adds first elements
    public void addFirst(String item)
    {
        this.addAtPosition(0, item);
    }

    // addLast: appends the node to the end of the list.
    public void addLast(String item)
    {
        this.addAtPosition(this.getSize(), item);
    }

    // addAtPosition: adds new item into the list at specific position
    public void addAtPosition(int position, String item)
    {   //First create a new node for the item to go into
        Node added = new Node(item);
        // if the position is zero then the item will be the head.
        // Or, if it is less than zero an out of bounds exception occurs
        // First this case must be covered.
        if (position < 0) {
            throw new IndexOutOfBoundsException();
        }
        //now the case of the node will be the head
        if (position ==0) {
            added.next=this.head;
            this.head = added;
            //now the size needs to be calculated now there is a new node added
            //in this case the size should be 1 as there is just the head
            this.calculateSize();
        }else{
            //now need to start from the head and work towards the position until we get to
            //the node just before it
            //start with the head
            Node startAdd =this.head;
            while(--position > 0){
                startAdd=startAdd.next;
//                System.out.println("adding " + item + " at " + position);
            }
            //once the position is reached the new node can be inserted and the size recalculated
            added.next = startAdd.next;
            startAdd.next= added;
            this.calculateSize();

        }
    }

    // deleteAtPosition: deletes item from the list at specific position
    public Node deleteAtPosition(int position)
    {
        // Add your code here (and remove null)
        //
        return null;
    }

    // findByPosition: finds the element at specific position in the MyLinkedList
    public Node findByPosition(int position) throws IndexOutOfBoundsException
    {
        if(position >= this.size || position < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node tmp = this.head;
        for(int i=0; i<position; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    // Traverse over MyLinkedList
    public void traverse()
    {
        Node tmp = this.head;
        System.out.printf("%s content: [ ", this.getClass().getName());
        while (tmp != null) {
            System.out.printf("%s ", tmp.data);
            tmp = tmp.next;
        }
        System.out.printf("]\tSize: %d\n", this.size);
    }

    public static void main(String[] args)
    {
        // Creating MyLinkedList instance
        MyLinkedList list = new MyLinkedList();

        int position = 0;
        String[] array = new String[]{"David", "Marko", "Helen", "Emma", "Grace"};
        for(String item: array) {
            list.addAtPosition(position, item);
            position++;
            list.traverse();
        }

        list.addAtPosition(3, "Terry");
        //added by me to check
        list.traverse();
        System.out.println("The list after adding Terry");
        list.addLast("Terry");
        list.traverse();
        System.out.println("The list after adding Terry to the end");

        list.deleteAtPosition(1);
        list.traverse();
        System.out.println("The list after deleting item at position 1 (Marko)");
    }
}

class Node
{
    // Data value stored in the node
    public String data;

    // The reference to the next node
    public Node next;

    // Constructor that creates a node with the given data item
    public Node(String data)
    {
        this.data = data;
    }

    // Constructor that creates a node with the given data item and reference pointed to null
    public Node(String data, Node next)
    {
        this(data);
        this.next = next;
    }
}