package src;

import java.util.Random;

public class Box {
    private Edge top, bottom, left, right;
    private int value;
    private int owner = 0; //0 unowned, 1 player1, 2 player2

    /**
     * this is the top-left box
     * @param t
     * @param b
     * @param l
     * @param r
     */
    public Box(int v){
        this.top = new Edge();
        this.bottom = new Edge();
        this.left = new Edge();
        this.right = new Edge();
        this.value = v;
    }

    public Box(Edge top, Edge right, Edge bottom, Edge left, int v){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        this.value = v;
    }

    public Edge getTop() {
        return top;
    }

    public void setTop(Edge top) {
        this.top = top;
    }

    public Edge getBottom() {
        return bottom;
    }

    public void setBottom(Edge bottom) {
        this.bottom = bottom;
    }

    public Edge getLeft() {
        return left;
    }

    public void setLeft(Edge left) {
        this.left = left;
    }

    public Edge getRight() {
        return right;
    }

    public void setRight(Edge right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public boolean isCompleted(){
        if(this.getTop().getPossession() == 0) return false;
        if(this.getRight().getPossession() == 0) return false;
        if(this.getBottom().getPossession() == 0) return false;
        if(this.getLeft().getPossession() == 0) return false;
        return true;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
