public class CPTList {
    private CPTListNode front;
    // some methods
    public void method1(CPTList other){
        CPTListNode l = other.front;
        while (l.next != null){
            l = l.next;
        }
        l.next = front;
        front = other.front;
    }
}