import java.util.*;
class Main{
    Node root;
    Node first;
    Node last;
    Node prev;
    Node mid;

class Node{
    int data;
    Node left,right;
    Node(int k)
    {
        data=k;
        left=right=null;
    }
    
}
public  void buildTree(String str)
{
    if(str.length()==0||str.charAt(0)=='N')
    return;
    String ip[]=str.split(" ");
    root = new Node(Integer.parseInt(ip[0]));
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    int i=1;
    while(q.size()>0&&i<ip.length){
        Node currNo=q.peek();
        q.remove();
        String curval=ip[i];
        if(!curval.equals("N")){
            currNo.left=new Node(Integer.parseInt(curval));
            q.add(currNo.left);
        }
        i++;
        if(i>=ip.length)
        break;
        curval=ip[i];
        if(!curval.equals("N"))
        {
            currNo.right=new Node(Integer.parseInt(curval));
            q.add(currNo.right);
        }
        i++;
        }
    }
    public void Traversal(){
        TraversalRec(root);
    }
   public void TraversalRec(Node root)
		{
			if(root==null)
			return;
			TraversalRec(root.left);
			System.out.println(root.data+" ");
			TraversalRec(root.right);
		}
    public static void main(String[]args)
    {
        Scanner s=new Scanner (System.in);
        Main B=new Main();
        String t=s.nextLine();
        B.buildTree(t);
        B.Traversal();
    }
}
