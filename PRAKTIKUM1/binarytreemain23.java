package PRAKTIKUM1;
public class binarytreemain23 {
    
    public static void main(String[] args) {
        binarytree23 bt = new binarytree23();
    
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);

        System.out.println("Pre0rder Travel: ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.println("In0rder Travel: ");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.println("Pre0rder Travel: ");
        bt.traversePostOrder(bt.root);
        System.out.println("");
        System.out.println("Find Node: "+bt.find(5));
        System.out.println("Delete Node 8");
        bt.delete(8);
        System.out.println("");
        System.out.println("Pre0rder Travel: ");
        bt.traversePreOrder(bt.root);
        System.out.println("");
    }
}