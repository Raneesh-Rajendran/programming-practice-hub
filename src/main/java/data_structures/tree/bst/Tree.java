package main.java.data_structures.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import main.java.models.BinaryNode;

public class Tree {

    private BinaryNode root;

    public Tree(){
        root=null;
        System.out.println("tree created");
    }

    private static BinaryNode minimumNode(BinaryNode node) {
        if (node.getLeft()==null)
            return node;
        else
            return minimumNode(node.getLeft());
    }

    void insert(Integer value){
        root = insert(root, value);
    }

    private BinaryNode insert(BinaryNode currentNode, Integer value) {
        if(currentNode==null) {
            System.out.println("inserted");
            return createNode(value);
        }
        else if ( value <= currentNode.getValue1()){
            currentNode.setLeft(insert(currentNode.getLeft(),value));
        }
        else if (value >= currentNode.getValue1()) {
            currentNode.setRight(insert(currentNode.getRight(), value));
        }
        return null;
    }

    private int checkBalance(BinaryNode left, BinaryNode right) {
        if (left == null && right == null)
            return 0;
        else if(left == null)
            return -1*(right.getHeight()+1);
        else if(right==null)
            return left.getHeight() + 1;
        else
            return left.getHeight()- right.getHeight();
    }

    private BinaryNode createNode(Integer value) {
        BinaryNode node = new BinaryNode();
        node.setValue1(value);
        return node;
    }

    public void delete(Integer value){
        deleteNode(root, value);
    }

    public BinaryNode deleteNode(BinaryNode currentNode, Integer value) {
        if (root == null)
            return null;
        else if(value< currentNode.getValue1())
            deleteNode(currentNode.getLeft(),value);
        else if(value> currentNode.getValue1())
            deleteNode(currentNode.getRight(),value);
        else {
            if (currentNode.getLeft() != null && currentNode.getRight() != null) {
                BinaryNode temp = currentNode;
                BinaryNode rightMinNode = minimumNode(currentNode.getRight());
                currentNode.setValue1(rightMinNode.getValue1());
                currentNode.setRight(deleteNode(currentNode.getRight(), rightMinNode.getValue1()));
            } else if (currentNode.getLeft() != null)
                currentNode = currentNode.getLeft();
            else if (currentNode.getRight() != null)
                currentNode = currentNode.getRight();
            else
                currentNode = null;
        }
        return currentNode;
    }

    void searchForValue(Integer value) {
        searchNode(root, value);
    }

    public BinaryNode searchNode(BinaryNode node, Integer value){
        if (node == null)
            return null;
        else if (node.getValue1() == value)
            return node;
        else if (value< node.getValue1())
            return searchNode(node.getLeft(),value);
        else if(value> node.getValue1())
            return searchNode(node.getRight(),value);
        System.out.println("node not found");
        return null;
    }

    public void levelOrder(){
        if (root == null) {
            System.out.println("tree empty");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.getValue());
            if (presentNode.getLeft() != null)
                queue.add(presentNode.getLeft());
            if (presentNode.getRight() != null)
                queue.add(presentNode.getRight());
        }
    }

    public void preOrder(BinaryNode node){
        if(root==null)
            return;
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(BinaryNode node){
        if(root==null)
            return;
        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
    }

    public void postOrder(BinaryNode node){
        if(root==null)
            return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }

    public void deleteTree(){
        root=null;
        System.out.println("tree deleted");
    }
    void printTreeGraphically() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        Queue<Integer> level = new LinkedList<Integer>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if(root == null) {
            System.out.println("Tree does not exists !");
            return;
        }
        while (!queue.isEmpty()) {
            if(CurrentLevel == level.peek()) { //if we are in the same level
                if(queue.peek()==null) {
                    queue.add(null);level.add(CurrentLevel+1);
                }else {
                    queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
                    queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove() + "  ");level.remove();
            }else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if(previousLevelWasAllNull) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }
    }

}
