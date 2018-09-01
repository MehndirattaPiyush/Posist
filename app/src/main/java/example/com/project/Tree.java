//package example.com.project;
//
//import java.util.Iterator;
//
//public class Tree
//{
//    // Root of Binary Tree
//    Node root;
//
//    // Constructors
//    Tree(int key)
//    {
//        root = new Node(key);
//    }
//
//    Tree()
//    {
//        root = null;
//    }
//
//    public static void main(String[] args)
//    {
//        Tree tree = new Tree();
//
//
//        tree.root = new Node(1);
//
//        tree.root.childReferenceNodeIdLeft = new Node(2);
//        tree.root.childReferenceNodeIdRight = new Node(3);
//
//        tree.root.childReferenceNodeIdLeft = new Node(4);
//    }
//    void printInorder(Node node)
//    {
//        if (node == null)
//            return;
//
//        printInorder(node.childReferenceNodeIdLeft);
//
//        System.out.print(node.nodeNumber + " ");
//
//        printInorder(node.c);
//    }
//    // A function used by DFS
////    void DFSUtil(int v,boolean visited[])
////    {
////        // Mark the current node as visited and print it
////        visited[v] = true;
////        System.out.print(v+" ");
////
////        // Recur for all the vertices adjacent to this vertex
////        Iterator<Integer> i = adj[v].listIterator();
////        while (i.hasNext())
////        {
////            int n = i.next();
////            if (!visited[n])
////                DFSUtil(n, visited);
////        }
////    }
////
////    // The function to do DFS traversal. It uses recursive DFSUtil()
////    void DFS(int v)
////    {
////        // Mark all the vertices as not visited(set as
////        // false by default in java)
////        boolean visited[] = new boolean[V];
////
////        // Call the recursive helper function to print DFS traversal
////        DFSUtil(v, visited);
////    }
//}