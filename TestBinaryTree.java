import java.util.Scanner;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree newTree = new BinaryTree();//тут простенький код по добавлению элементов в дерево
        //и разовой демонстрации 3 методов - добавления элемента, вывода всего
        //дерева в порядке возрастания и подсчёт количества неполных узлов

        newTree.insertNode(newTree.ROOT, 10);
        newTree.insertNode(newTree.ROOT, 8);
        newTree.insertNode(newTree.ROOT, 20);
        newTree.insertNode(newTree.ROOT, 15);
        newTree.insertNode(newTree.ROOT, 13);
        newTree.insertNode(newTree.ROOT, 17);
        newTree.insertNode(newTree.ROOT, 25);


        newTree.printInOrder(newTree.ROOT);

        Scanner in = new Scanner(System.in);
        System.out.println ("\nEnter which element to add:");
        newTree.insertNode(newTree.ROOT, in.nextInt());

        newTree.printInOrder(newTree.ROOT);
        System.out.println("\nThere are " + newTree.countIncompleteNodes(newTree.ROOT) + " incomplete nodes in our tree.");;
    }
}