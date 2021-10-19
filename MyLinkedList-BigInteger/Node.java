

public class Node<E> // E is any object type
{
    E info;
    node<E> prev;
    node<E> next;
    
    public Node()
    {
       info=null;
       prev=null;
       next=null;
    }
    
    public void setNext(node<E> n){
       next = n; 
        
    }
    
    public void setPrev(node<E> p){
        prev=p;
    }
    
    public void setInfo(E val) {
        
        info =val;
    }
    
    public E getInfo() {
        
        return info;
        
    }
    
    public node<E> getNext() {
        return next;
        
    }
      public node<E> getPrev() {
        return prev;
        
    }
    

    

    
}
