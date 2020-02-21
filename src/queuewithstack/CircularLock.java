package queuewithstack;

import java.util.*;

public class CircularLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d: deadends) {
            dead.add(d);
        }

        Queue<String> queue = new LinkedList();
        // boolean offer(E e)
        //将对象e插入队列尾部，成功返回true，失败（没有空间）返回false；
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            //E poll(); 获取并移除队列头部元素，如果队列为空，返回null；
            String node = queue.poll();
            if (node == null) {
                depth++;
                //E peek() 获取但不移除队列头部元素，如果队列为空，返回null；
                //如果队首元素不为null 则在队尾添加null 作为这一层的分界
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                // 遍历这个数的四位各加减1的情况
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d += 2) {
                        // +- 1
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        // don't include endindex
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int openLock2(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        // 如果deadends包含起始状态"0000"直接返回-1
        if (visited.contains("0000")) {
            return -1;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                //移除并返回第一个元素
                String cur = queue.removeFirst();
                if (cur.equals(target)) {
                    return level;
                }
                // 获取下一层能达到的状态注意要越过deadends中包含的
                char[] chars = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char temp = chars[j];
                    chars[j] = (temp == '9' ? '0' : (char) (temp + 1));
                    String next = String.valueOf(chars);
                    if (visited.add(next)) {
                        queue.addLast(next);
                    }
                    chars[j] = (temp == '0' ? '9' : (char) (temp - 1));
                    next = String.valueOf(chars);
                    if (visited.add(next)) {
                        queue.addLast(next);
                    }
                    chars[j] = temp;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        openLock (deadends,"0202");
    }


}
