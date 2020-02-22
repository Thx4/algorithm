package queuewithstack;

public class DepthFirstSearch {
    private class Node{
        int val;
        int step;

        public Node(int val, int step){
            this.val = val;
            this.step = step;
        }
    }
//    boolean DFS(Node cur, Node target, Set<Node> visited) {
//        return true if cur is target;
//        for (next : each neighbor of cur) {
//            if (next is not in visited) {
//                add next to visted;
//                return true if DFS(next, target, visited) == true;
//            }
//        }
//        return false;
//    }
//    boolean DFS(int root, int target) {
//        Set<Node> visited;
//        Stack<Node> s;
//        add root to s;
//        while (s is not empty){
//            Node cur = the top element in s;
//            return true if cur is target;
//            for (Node next : the neighbors of cur){
//                if (next is not in visited){
//                    add next to s;
//                    add next to visited;
//                }
//            }
//            remove cur from s;
//        }
//        return false;
//    }
}
