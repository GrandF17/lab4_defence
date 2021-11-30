public class BinaryTree {
    int data;
    int incompleteNodes = 0;
    BinaryTree parent;
    BinaryTree left;
    BinaryTree right;
    BinaryTree ROOT;

    public BinaryTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public BinaryTree() {
        this.ROOT = null;
    }
    public BinaryTree(BinaryTree element) {
        this.data = data;
        if (element != null) {
            this.left = new BinaryTree(element.left);
            this.right = new BinaryTree(element.right);
        }
    }

    void insertNode(BinaryTree element, int data) {
        if (ROOT == null) { //если ROOT ещё не установлен то мы его устанавливаем и начинаем ветвление дерева
            element = new BinaryTree(data);
            ROOT = element;
        }
        else if (data < element.data && element.left == null) {
            element.left = new BinaryTree(data);
            element.left.parent = element;
        }
        else if (data >= element.data && element.right == null) {
            element.right = new BinaryTree(data);
            element.right.parent = element;
        }
        else {
            if (data < element.data)
                insertNode(element.left, data);
            else
                insertNode(element.right, data);
        }
    }

    public int countIncompleteNodes(BinaryTree element) {
        boolean hasLeft = false;
        boolean hasRight = false;
        if(element.left != null) {
            countIncompleteNodes(element.left);
            hasLeft = true;
        }
        if(element.right != null){
            countIncompleteNodes(element.right);
            hasRight = true;
        }
        if(!(hasLeft && hasRight || (!hasLeft && !hasRight))) {
            incompleteNodes++;
        }//несовсем понял что конкрентно подразумевается под НЕПОЛНЫМ узлом (ведь элемент не имеющий потомков - лист)
        //принял за истинупервое попавшееся и более-менее адекватное в интернете
        //суждение - "родитель у которого только один ребёнок"
        //если я неправ, готов и могу исправить
        return incompleteNodes;
    }

    public void printInOrder(BinaryTree element) {
        if(element.left != null) {
            printInOrder(element.left);
        }
        System.out.print(element.data + ", ");
        if(element.right != null) {
            printInOrder(element.right);
        }
    }
}