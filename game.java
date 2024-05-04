
import java.io.*;
// used for input / output operations from java library
import java.util.Scanner;

public class game {
    // declares class & member variables:
    private Node root;
    // root (instance of node class)

    private Scanner scanner;
    // scanner (instance of scanner class)

    public game() {
        // constructor
        // root varibale with new node object
        this.scanner = new Scanner(System.in);
        this.root = new Node("Is it lipgloss?");
        // initial question
        this.root.yes = new Node("Is it Dior?");
        // child node with answer 1
        this.root.no = new Node("Is it Milani lipgloss?");
        // child node with chapter 2
    }

    private boolean getUserInput() {
        // method which returns a boolean value
        while (true) {
            // starts an infinite loop until return statement breaks the loop
            String input = scanner.nextLine().trim().toLowerCase();
            // trims whitespace and converts to lowercase
            if (input.equals("yes")) {
                // if the user sys yes, the method returns true
                return true;
            } else if (input.equals("no")) {
                // if the user saus no, it returns no
                return false;
            } else {
                System.out.println("Please answer 'yes' or 'no'.");
                // if the user types something random
            }
        }
    }

    public void playGame() {
        // void because it doesnt return any values
        Node current = this.root;
        // initializes node variable named current
        // is the root node of the gamettree of the current instance of the game class
        Node parent = null;
        // node variable which will be used to keep track of the parent node
        boolean yesBranch = true;
        // variable that is used to track whether the current node is a yes branch or a no branch in the game tree

        while (current != null) {
            // while loop that keeps going as long as there are more nodes to traverse in the game tree
            if (current.yes == null && current.no == null) {
                // checks if the node is a leaf node (has no children) which are the yes/no branches
                // if tthe node is a leaf node then the game has to make a guess
                System.out.println("Is your makeup item " + current.data + "?");
                if (getUserInput()) {
                    System.out.println("I got it!");
                    // the item is correct

                } else {
                    System.out.println("Please give me a clue!");
                    // it asks for a clue
                    String object = scanner.nextLine();
                    // scanes the clue and stores it in a string "object"
                    System.out.println("What was your item?");
                    // asks for the current item
                    String question = scanner.nextLine();
                    // stores user input in a variable called question

                    Node newQuestion = new Node(question);
                    // contains question to distingush the guessed item from the correct item
                    Node newObject = new Node(object);
                    // represents the correct makeup item

                    // determines if to attach new quesion node as the "yes" or "no" leaf branch of current node based on value of yesBranch
                    if (yesBranch) {
                        current.yes = newQuestion;
                    } else {
                        current.no = newQuestion;
                    }

                }
                return;
                // if the current node is not a leaf node
            } else {
                System.out.println(current.data);
                // prints the question stored in the current node to the console
                parent = current;
                // updates parent variable to store the current node
                if (getUserInput()) {
                    // calls user input method to get user's response
                    yesBranch = false;
                    // sets yesbranch variable to false if the user responds no
                }

                if (yesBranch) {
                    current = current.yes;
                    // if yes branch is true it moves to the yes branch, otherwise moves to the no branch
                } else {
                    current = current.no;
                }
            }
        }
    }

    // creates instance of game class and calls playgame mehod to start the game

    public static void main(String[] args) {
        game myGame = new game();
        myGame.playGame();
    }

    // class node
    static class Node  {
        // static so it can be accessed without creating an instance of the game class
        String data;
        // represents data stored in the node
        // child nodes
        Node yes;
        Node no;

        // constructor 
        Node(String data) {
            this.data = data;
            this.yes = null;
            this.no = null;
        }
    }
}
