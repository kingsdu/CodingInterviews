package DoExercise.JianzhiOffer;

public class TestDay
{
    public static void main(String[] args)
    {
    
    }
    
    //基于双端链表实现队列
    public static class MyQueue<V>
    {
        private Node<V> head;
        private Node<V> tail;
        private int size;
        
        public MyQueue()
        {
            head = null;
            tail = null;
            size = 0;
        }
        
        public void offer(V Node)
        {
            Node<V> cur = new Node<>(Node);
            if (head == null)
            {
                head = cur;
                tail = cur;
            } else
            {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }
        
        public V poll()
        {
            V ans = null;
            if (head == null)
            {
                tail = null;
            } else
            {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
        
        public V peek()
        {
            V ans = null;
            if (head != null)
            {
                ans = head.value;
            }
            return ans;
        }
        
    }
    
    
    //基于单链表实现栈
    public static class MyStack<V>
    {
        private Node<V> head;
        int size;
        
        public void push(V node)
        {
            Node<V> cur = new Node<>(node);
            if (head != null)
            {
                cur.next = head;
            }
            head = cur;
            size++;
        }
        
        public V poll()
        {
            V ans = null;
            if (head != null)
            {
                ans = head.value;
                head = head.next;
                size--;
            }
            return ans;
        }
        
        public V peek()
        {
            V ans = null;
            if (head != null)
            {
                ans = head.value;
            }
            return ans;
        }
    }
    
    
    public static class Node<V>
    {
        public V value;
        public Node<V> next;
        
        public Node(V v)
        {
            value = v;
            next = null;
        }
    }
    
}
