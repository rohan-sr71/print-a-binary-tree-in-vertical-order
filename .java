class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
class BinaryTree
{
    static void verticalOrder(Node root)
    {
        TreeMap<Integer,ArrayList<Integer>> tm=new TreeMap<>();
        Queue<Node> q=new LinkedList<Node>();
        int hd=0;
        root.hd=0;
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node r;
            r=q.remove();
            int hd1=r.hd;
            if(tm.containsKey(hd1))
            {
                ArrayList<Integer> al=tm.get(hd1);
                al.add(r.data);
                tm.put(hd1,al);
            }
            else
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(r.data);
                tm.put(hd1,al);
            }
            
            if(r.left!=null)
            {
                r.left.hd=hd1-1;
                q.add(r.left);
            }
            if(r.right!=null)
            {
                r.right.hd=hd1+1;
                q.add(r.right);
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> t:tm.entrySet())
        {
            ArrayList<Integer> al=t.getValue();
            for(int i=0;i<al.size();i++)
            {
                System.out.print(al.get(i)+" ");
            }
        }
    }
}
