package com.company;

public class Node {

    private Vector2 data;
    private Node nextNode;

    public Node(Vector2 data, Node nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }

    public void setData(Vector2 data) {
        this.data = data;
    }

    public void setLink(Node next) {
        this.nextNode = next;
    }

    public Vector2 getData() {
        return data;
    }

    public Node getLink() {
        return nextNode;
    }

    public String toString() {
        return "N(" + data.x + ", " + data.y + ")";
    }
}
