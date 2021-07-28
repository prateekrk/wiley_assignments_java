package DSA.Trees;

public class BinarySearchTree {

    class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data=data;
            left=right=null;
        }
    }

    Node root;

    private Node insertValue(Node root,int key) {
        Node node=new Node(key);
        if(root==null) {
            root=node;
            return root;
        }
        else if(key<root.data)
            root.left=insertValue(root.left,key);
        else if(key>root.data)
            root.right=insertValue(root.right, key);

        return root;
    }

    public void insert(int key) {
        root=insertValue(root, key);
    }

    private void inorderRec(Node root) {
        if(root!=null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    public void inorder() {
        inorderRec(root);

    }

    private void postOrderRec(Node root){
        if(root!=null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.data);
        }
    }

    public void postOrder(){
        postOrderRec(root);
    }

    private  void preOrderRec(Node root){
        if(root!=null){
            System.out.println(root.data);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    public void preOrder(){
        preOrderRec(root);
    }

    int findMax(Node root){
        if(root.right==null){
            return root.data;
        }
        int x=0;
        while(root!=null){
            x=root.data;
            root=root.right;
        }
        return x;
    }
    int maxElement(){
        return findMax(root);
    }
    int findMin(Node root){
        if(root.left==null){
            return root.data;
        }
        int x=0;
        while(root!=null){
            x=root.data;
            root=root.left;
        }
        return x;
    }

    int minElement(){
        return findMin(root);
    }

    int height(Node root){
       if(root==null){
           return 0;
       }
       int depl=height(root.left);
       int depr=height(root.right);

       if(depl>depr){
           return depl++;
       }
       else {
          return  depr++;
       }

    }

}
