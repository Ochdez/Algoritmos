
public class Arbol{
	

	    public static void main(String[] args) {
		    Tree intTree = new Tree();
		    intTree.insert(25);
		    intTree.insert(20);
		    intTree.insert(15);
		    intTree.insert(27);
		    intTree.insert(30);
		    intTree.insert(29);
		    intTree.insert(26);
		    intTree.insert(22);
		    intTree.insert(32);

		    intTree.InOrden();
			
	    }
	
}


class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (value < data) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public void orden() {
        if(leftChild != null) {
            leftChild.orden();
        }
        System.out.print(data + " ");
        if (rightChild != null) {
            rightChild.orden();
        }
    }

    public void preorden() {

        System.out.print(data + " ");
        if(leftChild != null) {
            leftChild.preorden();
        }
        if(rightChild != null) {
            rightChild.preorden();
        }
    }

    public void postorden() {
        if(leftChild != null) {
            leftChild.postorden();

        }

        if(rightChild != null) {
            rightChild.postorden();
        }
        System.out.print(data + " ");

    }

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public void InOrden() {
        if (root != null) {
            root.orden();
        }

    }
    
        

}

