
package curalli;

/**
 *
 * @author masutha
 */

class CNode{
    Checkup cu;
    CNode next,pre;

    public CNode() {
        
    }

    public CNode(Checkup cu) {
        this.cu = cu;
        next=null;
        pre=null;
    }
    
    
}

public class CheckupList {
    CNode head,tail;

    public CheckupList() {
        head=null;
        tail=null;
    }
    
    public void Enqueue (Checkup cu){
        CNode node = new CNode(cu);
        
        if(head==null || tail==null){
            head=node;
            tail=node;
        }
        else if(head.cu.getPriority()<cu.getPriority()){
            head.next=node;
            node.pre=head;
            head=node;  
        }
        else if(tail.cu.getPriority()>=cu.getPriority()){
            tail.pre=node;
            node.next=tail;
            tail=node;
        }
        else{
            CNode temp=tail;
            while(temp!=null){
                if(temp.cu.getPriority()>=cu.getPriority()){
                    break;
                }
                temp=temp.next;
            }
            
            node.next=temp;
            node.pre=temp.pre;
            temp.pre.next=node;
            temp.pre=node;
        }
    }
    
    public Checkup dequeue(){
        if(head==null){
           return null;  
        }
       CNode checkup=head;
    head=head.next;
    return checkup.cu;
    }
  
    public void addRecommendation(int index, String rec){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i){
                temp.cu.setRecommendation(rec);
                break;
            }
            i++;
            temp=temp.pre;
        }
    }
    
    public Patient getPatient(int index){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i){
                break;
            }
            i++;
            temp=temp.pre;
        }
        return temp.cu.getPatient();
    }
    
      public void Print(){
        CNode temp=head;
        while(temp!=null){
            System.out.println(temp.cu.getPriority()+"      "+temp.cu.getRecommendation());
            
            temp=temp.pre;
        }
    }
    
}
