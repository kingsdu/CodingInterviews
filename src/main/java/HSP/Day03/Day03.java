package HSP.Day03;

public class Day03
{
    
    public static void main(String[] args)
    {
        SingleLinkedListHSP ls = new SingleLinkedListHSP();
        ls.addFirst(1);
        ls.addNode(2);
        ls.addNodeIndex(3,3);
        ls.addNodeIndex(4,4);
        ls.addNodeReverse(5);
        ls.addNodeReverse(6);
        ls.removeLastNode();
        ls.removeNodeIndex(4);
        ls.editNodeIndex(1,7);
        ls.removeNodeElement(1);
        ls.removeNodeElement(6);
        ls.printLinkedList();
        System.out.println(ls.containsElement(5) ? "有":"没有");
        System.out.println(ls.getNodeIndex(2));
    }
}
