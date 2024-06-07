package PRAKTIKUM1;
public class binarytree23 {
    node23 root;

    public binarytree23(){
        root = null;
    }

    boolean isEmpty(){
        return root == null;
    }

    void add(int data){
        if(isEmpty()){ //tree is empty
            root = new node23(data);
        }else{
            node23 current = root;
            while(true){
                if(data<current.data){
                    if(current.left != null){
                        current = current.left;
                    }else{
                        current.left = new node23(data);
                        break;
                    }
                }else if(data>current.data){
                    if(current.right != null){
                        current = current.right;
                    }else{
                        current.right = new node23(data);
                        break;
                    }
                }else{// data is alredy exist
                    break;
                }
            }
        }
    }

    boolean find(int data){
        boolean hasil = false;
        node23 current = root;
        
        while(current != null){
            if(current.data == data){
                hasil = true;
                break;
            }else if(data < current.data){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return hasil;
    }

    void traversePreOrder(node23 node){
        if(node != null){
            System.out.print(" "+node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    void traversePostOrder(node23 node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" "+node.data);
        }
    }
    void traverseInOrder(node23 node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.print(" "+node.data);
            traverseInOrder(node.right);
        }
    }

    node23 getSuccessor(node23 del){
        node23 successor = del.right;
        node23 successorParent = del;
        while(successor.left != null){
            successorParent = successor;
            successor = successor.left;
        }
        if(successor != del.right){
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data){
        if(isEmpty()){
            System.out.println("Tree Is Empty!");
            return;
        }
        node23 parent = root;
        node23 current = root;
        boolean isLeftChild = false;
        while(current != null){
            if(current.data == data){
                break;                
            }else if(data<current.data){
                parent = current;
                current = current.left;
                isLeftChild = true;
            }else if(data>current.data){
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        if(current==null){
            System.out.println("Couldn't find data!");
            return;
        }else{
            if(current.left==null &&current.right==null){
                if(current==root){
                    root = null;
                }else{
                    if(isLeftChild){
                        parent.left = null;
                    }else{
                        parent.right = null;
                    }
                }
            }else if(current.left == null){
                if(current==root){
                    root = current.right;
                }else{
                    if(isLeftChild){
                        parent.left = current.right;
                    }else{
                        parent.right = current.right;
                    }
                }
            }else if(current.right == null){
                if(current==root){
                    root = current.left;
                }else{
                    if(isLeftChild){
                        parent.left = current.left;
                    }else{
                        parent.right = current.left;
                    }
                }
            }else{
                node23 successor = getSuccessor(current);
                if(current==root){
                    root = successor;
                }else{
                    if(isLeftChild){
                        parent.left = successor;
                    }else{
                        parent.right = successor;
                    }
                    successor.left = current.left;
                }
            }
        }
    }

    void addNodeR(int key){
        root = addNodeR(root, key);
    }

    public node23 addNodeR(node23 current, int data){
        if (current == null){
            return new node23(data);
        }
        if (data < current.data){
            current.left = addNodeR(current.left, data);
        }else if(data > current.data){
            current.right = addNodeR(current.right, data);
        }else{
            return current;
        }
        return current;
    }

    void maksimal(){
        node23 current = root;
        while(current.right != null){
            current = current.right;
        }
        System.out.println(current.data);
    }
    void minimal(){
        node23 current = root;
        while(current.left != null){
            current = current.left;
        }
        System.out.println(current.data);
    }

    void printLeft(node23 root){
        if(root == null){
        return;            
        }
        if(root.left == null && root.right == null){
            System.out.print(" "+ root.data);
            return;
        }if(root.left != null){
            printLeft(root.left);
        }if(root.right != null){
            printLeft(root.right);
        }
    }

    int jumlahLeft(){
        return jumlahLeft(root);
    }
    int jumlahLeft(node23 node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }else{
            return jumlahLeft(node.left)+jumlahLeft(node.right);
        }
    }
}
