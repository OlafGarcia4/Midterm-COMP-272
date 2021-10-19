
import java.util.*;
import java.lang.*;
public class MyLinkedList<E>
{
    node<E> first;
    node<E> last;
    int size;
    
    public MyLinkedList()
    {
       first = null;
       last = null;
       size=0;
    }
    
    public boolean isEmpty() {
        
        return (size==0);
        
    }
    
    public void addFirst(E info) {
        
        node<E> n =new node<>();
        n.setInfo(info);
        
       if (isEmpty())  
           last=n;
           
    
       else {
        n.setNext(first);
        first.setPrev(n);
        
    }
    first=n;
    size++;
        
    }
    
    public E removeFirst() {
        
    if (!isEmpty()) {
        
    E val = first.getInfo();
        if (size>1) {
       
        first.getNext().setPrev(null);
        first=first.getNext();
        size--;
        
    }
    else if (size==1) {
       
         first=null;
         last=null;
         size--;
         
        
    }
      return val;  
    }
    else 
    throw new NoSuchElementException();

    }
    
    
    public E removeLast() {
        
    if (!isEmpty()) {
        
   
        E val = last.getInfo();
        if (size>1) {
        last.getPrev().setNext(null);
        last=last.getPrev();
        size--;
    }
       else if (size==1) {
           
         first=null;
         last=null;
         size--;
        }
        return val;
    }
    else 
    
        throw new NoSuchElementException();
}   
   
    public E remove(int k) {
        
        if (!isEmpty()) {
        node<E> temp = first;
        
        if ((k>=0) && (k<size)) {
            if (k==0) return removeFirst();
            else if (k==size-1) return removeLast();
            else {
                // get to k
               // int i=0;
                for (int i=0;i<k;i++) 
                temp = temp.getNext();
                E val=temp.getInfo();
              temp.getPrev().setNext(temp.getNext());
              temp.getNext().setPrev(temp.getPrev());
              size--;
              return val;
                
            }
        }
        else throw new IndexOutOfBoundsException();
    }
            else {
                System.out.println("list empty ..");
            
                throw new NoSuchElementException();
        }
    }
    
    
    // adds an item to the end of the list with info field set to val
    public void addLast(E val) {
        node<E> n =new node<>();
        n.setInfo(val);
       if (isEmpty())  
           first=n;
       else {
        n.setPrev(last);
        last.setNext(n);
        }
    last=n;
    size++;
    }
    
    // prints all items in the list from first to last taking care of situations when the list is empty
    // use exception handling
    public void printListForward() {
        if (!isEmpty()){
            node<E> temp = first;
            do {
            System.out.print(temp.getInfo()+",");
            temp = temp.getNext();  
        } while (temp!=null);
    }
        else throw new NoSuchElementException();
        
    }
    
    // prints all items in the list from last to first taking care of situations when the list is em
    // use exception handling
    public void printListBackward() {
        
        if (!isEmpty()){
            node<E> temp = last;
            do {
            System.out.println(temp.getInfo());
            temp = temp.getPrev(); 
            } while (temp!=null);
         }
    else throw new NoSuchElementException();
    }
    //returns true if and only if the list contains at least one element e such that 
    //Objects.equals(o,e)
    //return false if the list is empty
    public boolean contains(Object o) {
        if (!isEmpty()){
            node<E> temp = first;
            do {
            if (Objects.equals(temp.getInfo(),o))
            return true; 
            temp=temp.getNext();
            } while (temp!=null);
         return false;
        }
        else throw new NoSuchElementException();
    }
    
    // brings the current list back to an empty list
    public void clear() {
        first=null;
        last=null;
        size=0;
        
    }
    // returns the info value stored at node i 
    // throw IndexOutOfBounds exception of i is out of bounds or the list is empty
    public E get(int i) {
        int j=0;
        if (i>=0 && i<size) {
        if (!isEmpty()){
            node<E> temp = first;
            do {
            if (i==j) return temp.getInfo();  
            temp = temp.getNext();  
            j++;
        } while (temp!=null);
    }
     throw new NoSuchElementException();
    }
    else  throw new IndexOutOfBoundsException();
}
    
    // compares this MyLinkedList with the parameter otherList 
    // and returns true if the linkedlists have identical values from beginning to end
    // same size and this.get(i).equals(otherList.get(i)) should be true for all i
    // lists can be empty in which case return true
    //should run in O(n) time where n is the size of each list.
    public boolean equals(Object otherList) {
        if (otherList instanceof MyLinkedList) {
             MyLinkedList<E> p =(MyLinkedList<E>)otherList;
             if (size!=p.size) return false;
             else if (isEmpty()&&p.isEmpty()) return true;
             else {
                    node<E> t1= this.first;
                    node<E> t2 = p.first;
                    do { 
                        E e1 = t1.getInfo();
                        E e2 = t2.getInfo();
                        if (!e1.equals(e2)) return false;
                        t1=t1.getNext();
                        t2=t2.getNext();
                        }  while (t1!=null && t2!=null);
                        }
                        return true;
 
         }
 else return false;
}

    /**
     * returns a new MyLinkedList<E> that takes this MyLinkedList<E> and removes all
     * repetitions of any value. E.g., {1,2,3,3,4,2,1,5} list will return {1,2,3,4,5} when E is Integer.
     * You can assume existence of equals() method. The original list should be unaltered.
     */

public MyLinkedList<E> uniqueList() {


    MyLinkedList<E> unq= new MyLinkedList<>();
    if (this.isEmpty()){
        return unq;
    }
    unq.addLast(this.get(0));
    for (int i =1; i<this.size; i++){
        E val = this.get(i);
        if(!unq.contains(val)){
            unq.addLast(val);
        }
    }
    return unq;
}

    /**
     *
     * that takes this MyLinkedList and the other MyLInkedList and returns a MyLinkedList
     * containing values that are common to both lists with no repetitions. For example, given,
     * this List is ={1,2,3,3,4,2,1,5} and other List ={1,5,5,2,10,10,11}, method commonValues()
     * will return a new List {1,2,5}. If they have nothing in common, return an empty List.
     *
     */
    public MyLinkedList<E> commonValues (MyLinkedList<E> other) {
        MyLinkedList<E> cmmnVal= new MyLinkedList<>();
         int tList = this.size;
         int oList = other.size;
         if(this.isEmpty() || other.isEmpty()){
             return cmmnVal;
         }

         if(Math.max(tList,oList)==tList){
             for (int i =0; i<this.size;i++){
                 E val= this.get(i);
                 if(other.contains(val)){
                     if(cmmnVal.isEmpty()){
                         cmmnVal.addLast(val);
                     }
                     if(!cmmnVal.contains(val)){
                         cmmnVal.addLast(val);
                     }
                 }
             }
         }
         else{
             for (int i =0; i<other.size;i++){
                 E val= other.get(i);
                 if(this.contains(val)){
                     if(cmmnVal.isEmpty()){
                         cmmnVal.addLast(val);
                     }
                     if(!cmmnVal.contains(val)){
                         cmmnVal.addLast(val);
                     }
                 }
             }
         }
        cmmnVal.printListForward();

        return cmmnVal;
    }

    /**
     *
     * takes this List and the other List and returns a list containing everything from both lists
     * without repetitions. For example, given the two lists above, method union() will return
     * a new List {1,2,3,4,5,10,11}. If both are empty then return empty, if one is empty, return
     * the other eliminating repetitions. The original Lists should be unaltered after the method
     * call.
     *
     */
    public MyLinkedList<E> union (MyLinkedList<E> other) {
        MyLinkedList<E> uni= other;
        for(int i =0;i < this.size; i++){
            uni.addLast(this.get(i));
        }

        return uni.uniqueList();
    }
    
    
}

    
    

    
    