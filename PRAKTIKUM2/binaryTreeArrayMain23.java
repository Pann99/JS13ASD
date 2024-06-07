package PRAKTIKUM2;

public class binaryTreeArrayMain23 {
    public static void main(String[] args) {
        binaryTreeArray23 bta = new binaryTreeArray23();
        int [] data = {6,4,8,3,5,7,9,0,0,0};
        int idxLast = 6;
        bta.populateData(data, idxLast);
        bta.traverseInOrder(0);
    
        System.out.println("\n-------------------------------");
        System.out.println("          Hasil Tugas          ");
        System.out.println("-------------------------------");
        bta.add(90);
        bta.add(72);
        System.out.println("Traverse PreOrder: ");
        bta.traversePreOrder(0);
        System.out.println();
        System.out.println("Traverse PostOrder: ");
        bta.traversePostOrder(0);
        System.out.println();
    }
}