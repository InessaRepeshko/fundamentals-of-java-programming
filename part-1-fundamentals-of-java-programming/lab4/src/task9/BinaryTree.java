package task9;

/**
 * The {@link BinaryTree} class representing ordinary (unbalanced) binary tree.
 */
public class BinaryTree {
    /** The {@link Node} class representing a node in the binary tree. */
    public static class Node {
        /** The node key of a binary tree. */
        int key;

        /** The node data of a binary tree. */
        String value;

        /** The left descendant(child) of the node of the binary tree. */
        Node leftChild;

        /** The right descendant(child) of the node of the binary tree. */
        Node rightChild;

        /**
         * Constructor for creation of a node with a key and value.
         * @param key the node key;
         * @param name the value of the node.
         */
        Node(int key, String name) {
            this.key = key;
            this.value = name;
        }

        /**
         * Provides the string representing the object.
         * @return the string representing the object.
         */
        @Override
        public String toString() {
            return "Key:\t" + key + "\tValue:\t\'" + value + "\'";
        }
    }

    /**
     * The root node of a binary tree.
     */
    private Node root;

    /**
     * Add the node to the binary tree.
     * @param key the node key;
     * @param value the value of the node.
     */
    public void addNode(int key, String value) {
        Node newNode = new Node(key, value);

        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;

            while (true) {
                parent = currentNode;

                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;

                    if (currentNode == null) {
                        parent.leftChild = newNode;

                        return;
                    }
                } else {
                    currentNode = currentNode.rightChild;

                    if (currentNode == null) {
                        parent.rightChild = newNode;

                        return;
                    }
                }
            }
        }
    }

    /**
     * Traverse nodes in ascending key order.
     * @param currentNode the node from which its child nodes are traversed.
     */
    public void traverseTree(Node currentNode) {
        if (currentNode != null) {
            traverseTree(currentNode.leftChild);
            System.out.println(currentNode);
            traverseTree(currentNode.rightChild);
        }
    }

    /**
     * Traverse nodes in ascending key order starting from the root of the binary tree.
     */
    public void traverseTree() {
        traverseTree(root);
    }

    /**
     * Search for a node in a binary tree by its key.
     * @param key the node key;
     * @return the found node.
     */
    public Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }

    /**
     * Process the case when the node has zero children at removal.
     * @param currentNode the node to be removed;
     * @param parent the parent node for {@code currentNode}.
     */
    private void removeNodeWithZeroChildren(Node currentNode, Node parent) {
        if (parent == null) {
            root = null;
        } else if (parent.leftChild == currentNode) {
            parent.leftChild = null;
        } else {
            parent.rightChild = null;
        }
    }

    /**
     * Process the case when the node has only the right child at removal.
     * @param currentNode the node to be removed;
     * @param parent the parent node for {@code currentNode}.
     */
    private void removeNodeWithRightChild(Node currentNode, Node parent) {
        if (parent == null) {
            root = currentNode.rightChild;
        } else if (parent.leftChild == currentNode) {
            parent.leftChild = currentNode.rightChild;
        } else {
            parent.rightChild = currentNode.rightChild;
        }
    }

    /**
     * Process the case when the node has only the left child at removal.
     * @param currentNode the node to be removed;
     * @param parent the parent node for {@code currentNode}.
     */
    private void removeNodeWithLeftChild(Node currentNode, Node parent) {
        if (parent == null) {
            root = currentNode.leftChild;
        } else if (parent.leftChild == currentNode) {
            parent.leftChild = currentNode.leftChild;
        } else {
            parent.rightChild = currentNode.leftChild;
        }
    }

    /**
     * Handling the case when a node has both children.
     * @param currentNode the node to be removed;
     * @param parent the parent node for {@code currentNode}.
     */
    private void removeNodeWithBothChildren(Node currentNode, Node parent) {
        Node parentOfChild = currentNode;
        Node child = currentNode.rightChild;

        while (child.leftChild != null) {
            parentOfChild = child;
            child = child.leftChild;
        }

        if (parentOfChild != currentNode) {
            parentOfChild.leftChild = child.rightChild;
            child.rightChild = currentNode.rightChild;
        }

        child.leftChild = currentNode.leftChild;

        if (parent == null) {
            root = child;
        } else if (parent.leftChild == currentNode) {
            parent.leftChild = child;
        } else {
            parent.rightChild = child;
        }
    }

    /**
     * Remove the node with processing based on the existence of children.
     * @param currentNode the node to be removed;
     * @param parent the parent node for {@code currentNode}.
     */
    private void removeNodeWithChildren(Node currentNode, Node parent) {
        if (currentNode.leftChild == null
                && currentNode.rightChild == null) {
            removeNodeWithZeroChildren(currentNode, parent);
        } else if (currentNode.leftChild == null) {
            removeNodeWithRightChild(currentNode, parent);
        } else if (currentNode.rightChild == null) {
            removeNodeWithLeftChild(currentNode, parent);
        } else {
            removeNodeWithBothChildren(currentNode, parent);
        }
    }

    /**
     * Remove the node by key.
     * @param key the node key;
     * @return {@code true} if the node was found and successfully removed, {@code false} otherwise.
     */
    public boolean removeNode(int key) {
        Node currentNode = root;
        Node parent = null;

        while (currentNode != null) {
            if (key < currentNode.key) {
                parent = currentNode;
                currentNode = currentNode.leftChild;
            } else if (key > currentNode.key) {
                parent = currentNode;
                currentNode = currentNode.rightChild;
            } else {
                removeNodeWithChildren(currentNode, parent);

                return true;
            }
        }

        return false;
    }

    /**
     * Performs testing of the {@link BinaryTree} class functionality. The {@code args} are not used.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Initial binary tree:");
        BinaryTree continents = new BinaryTree();
        continents.addNode(1, "Europe");
        continents.addNode(3, "Africa");
        continents.addNode(5, "Australia");
        continents.addNode(4, "America");
        continents.addNode(2, "Asia");
        continents.addNode(6, "Antarctica");
        continents.traverseTree();
        System.out.println();

        System.out.println("Testing node removal by index:");
        int key = 9;
        System.out.println("Removing the node with an invalid index " + key + ":\t" + continents.removeNode(key));
        continents.traverseTree();
        System.out.println();

        key = 6;
        System.out.println("Removing the node with a valid index " + key + " (has zero children):\t\t\t"
                + continents.removeNode(key));
        continents.traverseTree();
        System.out.println();

        key--;
        System.out.println("Removing the node with a valid index " + key + " (has only right children):\t"
                + continents.removeNode(key));
        continents.traverseTree();
        System.out.println();

        key--;
        System.out.println("Removing the node with a valid index " + key + " (has only left children):\t"
                + continents.removeNode(key));
        continents.traverseTree();
        System.out.println();

        key--;
        System.out.println("Removing the node with a valid index " + key + " (has both children):\t\t\t"
                + continents.removeNode(key));
        continents.traverseTree();
        System.out.println();

        key++;
        System.out.println("Continent with key " + key + ":\t" + continents.findNode(key) + "\n");

        key = 2;
        System.out.println("Continent with key " + key + ":\n" + continents.findNode(key) + "\n");
    }
}


