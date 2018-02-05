package datastructure.LinkList;

public class Node {

        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        public Node() {

        }

        void append(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void setNextNode(Node newNode) {
            Node end = newNode;
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        void appendCircular(int d, int c) {
            Node end = new Node(d);
            Node n = this;
            Node cir = null;
            while (n.next != null) {
                if (c == n.data) {
                    cir = n;
                }
                n = n.next;
            }
            end.next = cir;
            n.next = end;


        }
    }

