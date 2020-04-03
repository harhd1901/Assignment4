package com.company;

import java.util.ArrayList;
import java.util.logging.Logger;

public class LinkedList {
    private Node top;

    public LinkedList(){
        top = null;
    }

    /* isEmpty() will return the first Node in the list */
    public boolean isEmpty(){
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    /* getTop will return the first Node in the list. */
    public Node getTop() {
        if(top != null){
            return top;
        }
        return null;
    }

    /* size - will return the total number of Nodes stored in the list */
    public int size() {
        int sizeOfLinkedList = 0;
        Node temp = top;
        while(temp != null) {
         sizeOfLinkedList += 1;
         temp = temp.getLink();
        }

        return sizeOfLinkedList;
    }

    /*add - will add the given Vector2 into the LinkedList as the first Node */
    void add(Vector2 data) {
        top = new Node(data, null);
    }

    /* add - will add the given Node to the front of the LinkedList */
    void add(Node newNode) {
        Node temp = top;
        if(newNode != null) {
            if(top != null) {
                newNode.setLink(temp);
            }
            top = newNode;
        }
    }

    /* addLast - will add a new Node to the LinkedList with the data value given*/
    void addLast(Vector2 data) {
        //when our top node is null, the first and last node will be the same
        if(top == null){
            top = new Node(data, null);
            return;
        }
        Node temp = top;
        while(temp != null && temp.getLink() != null) {
            temp = temp.getLink();
        }
        //when temp is the last node, we create a new node to add at the end of the list
        if(temp != null && temp.getLink() == null){
            temp.setLink(new Node(data, null));
        }
    }

    /*remove -  will remove the first Node in the list and return the value */
    Vector2 remove() {
        // if the list is empty, we return null
        if(top == null || top.getLink() == null) {
            return null;
        }

        Node removedNode = top;
        top = top.getLink();
        return removedNode.getData();
    }

    /* toString - will return a String that includes ALL the nodes in the list */
    public String toString() {
        String result = "";
        Node temp = top;
        while(temp != null) {
            result += temp.toString();
            temp = temp.getLink();
        }
        return result;
    }

    void drawLine() {
        Node iterator = top;
        while(iterator != null && iterator.getLink() != null) {
            iterator.getData().drawLine(new Vector2(iterator.getData().x, iterator.getData().y),
                    new Vector2(iterator.getLink().getData().x, iterator.getLink().getData().y));
            iterator = iterator.getLink();
        }
    }

    /* totalLength function will return total distance between all nodes*/
    public double totalLength() {
        if(top == null || top.getLink() == null) {
            return 0;
        }
        Node temp = top;
        double total = 0;
        double a;
        double b;
        while(temp != null && temp.getLink() != null) {
            //distance btn 2 nodes
            //sqrt((x2-x1)^2 + (y2-y1)^2)
            a = (temp.getLink().getData().x - temp.getData().x);
            b = (temp.getLink().getData().y - temp.getData().y);
            total += Math.sqrt(a+b);
            temp = temp.getLink();
        }
        return total;
    }

    /* will insert a new Node containing  in the nth position.
     * If index is greater than the last Node,
     * add it to the end but print a warning to the console*/
    void insert(int index, Vector2 data) {
        int i = 0;
        Node temp = top;
        if(index > this.size()-1) {
            System.out.println("WARNING: index parameter is greater than the length Of List!");
            index = this.size()-1;
        }

        while(temp != null){
            if(i == index){
                Node intermediate = temp;
                intermediate = temp.getLink();
                temp.setLink(intermediate);
            }
            temp = temp.getLink();
            i+=1;
        }
    }

    /* compareTo - will compare the measured lengths of two LinkedLists */
    int compareTo(LinkedList other) {
        if(other.totalLength() == this.totalLength()) {
            return 0;
        }
        else{
            return (int)this.totalLength() - (int)other.totalLength();
        }
    }

    /* deepCopy - returns a deep copy of this LinkedList. */
    public LinkedList deepCopy() {
        LinkedList newLinkedList = new LinkedList();
        Node iterator = this.top;
        while(iterator != null) {
            newLinkedList.addLast(new Vector2(iterator.getData().x, iterator.getData().y));
        }
        return newLinkedList;
    }

    /* addList
    *  These should be added to the LinkedList so that they are in the same order as in the
    * ArrayList (that is, index 0 of the ArrayList will be in the first Node of the LinkedList).
    */
    public void addList(ArrayList<Vector2> source) {
        // resetting top to null
        top = null;
        Node temp = top;
        for(int i = 0; i < source.size(); i++) {
            temp.setData(new Vector2(source.get(i).x, source.get(i).y));
        }

    }


}
