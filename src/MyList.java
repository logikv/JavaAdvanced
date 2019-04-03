public class MyList<T> {

    private Node<T> head = null;


    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = getLast();
            last.next = newNode;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> first = head;
        if (first != null) {
            if (first.next != null) {
                while (first != getLast()) {
                    str.append(first.value);
                    first = first.next;
                    str.append(",");
                }
                str.append(first.value);
            }
        }
        return str.toString();
    }

    private Node<T> getLast() {
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public void reverse() {
        Node<T> firstnode = head;

        if (firstnode != null) {
            if (firstnode.next != null) {
                while (this.getLast() != firstnode) {
                    Node<T> secondnode = firstnode.next;
                    Node<T> thirdnode = secondnode.next;
                    thirdnode.next = secondnode;

                }
                head.next = null;
                head = getLast();
            }
        }


    }

}

class Node<T> {

    public T value;
    public Node<T> next = null;

    public Node(T value) {
        this.value = value;
    }
}
