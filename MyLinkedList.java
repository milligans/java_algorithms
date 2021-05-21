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
    public void addAtPosition(int position, String item) throws IndexOutOfBoundsException { //first we must deal with errors index out of bounds errors thrown by position before head of after size +1;
        //size +1 would mean it's been added on at the end.
        if (position < 0) {
            throw new IndexOutOfBoundsException();
        }
        //we need to find the node at position  and add our new node before it.
        //To find this node we need to iterate through the list until we get to the node at position  -1
        //Then insert the new node there
        Node insertionpoint = new Node(item);
        Node atPosition = this.head;
        this.calculateSize();
        int counter = 0;

        //if there are no other items in the list and the position = 0 then the item added will be the head
        if (this.head == null && position == 0) {
            this.head = insertionpoint;
            counter++;
            System.out.println("that's the head done");
            this.calculateSize();
        } else {
            //iterate through until got to position and add a node there

            while (atPosition.next != null && counter < position + 1) {
                atPosition = atPosition.next;
                counter++;

                System.out.println("adding..." + counter + " " + item);

            }
            atPosition.next=insertionpoint;



            this.calculateSize();
            for (int i = position + 1; i < this.size + 1; i++) {
                if (atPosition.next != null) {

                    atPosition = insertionpoint.next;
                } else {
                    System.out.println("Busted!");
                }

            }
        }
    }


//            counter++;
            //then continue to iterate through and move the remaining items up one place
//            while(atPosition.next != null && counter<this.size){
//                atPosition= insertionpoint.next;
//                counter++;
//            }
            //once the position has been reached insert at the new node at position
            //but what about the rest of the list, that has to now be increased by 1!


//        System.out.println(this.getSize());




















    // deleteAtPosition: deletes item from the list at specific position
    public Node deleteAtPosition(int position)
    {
        // Add your code here (and remove null)
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
        //I added the line below to test;
//        System.out.println(list);
//        System.out.println(array);

        list.addAtPosition(3, "Terry");
        list.addLast("Terry");
        list.traverse();

        list.deleteAtPosition(1);
        list.traverse();
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