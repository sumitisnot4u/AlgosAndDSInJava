package practice.otherProblems;

import java.util.LinkedList;
import java.util.List;

/**
 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:

 Input: [[1,1],2,[1,1]]
 Output: 10
 Explanation: Four 1's at depth 2, one 2 at depth 1.
 Example 2:

 Input: [1,[4,[6]]]
 Output: 27
 Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        LinkedList<NestedInteger> queue = new LinkedList<>();
        LinkedList<Integer> depth = new LinkedList<>();

        for(NestedInteger i: nestedList) {
            queue.offer(i);
            depth.offer(1);
        }
        while(!queue.isEmpty()) {
            NestedInteger top = queue.poll();
            int dep = depth.poll();

            if(top.isInteger()) {
                result += dep*top.getInteger();
            } else {
                for(NestedInteger i: top.getList()) {
                    queue.offer(i);
                    depth.offer(dep+1);
                }
            }
        }

        return result;
    }

    public interface NestedInteger {

        
                     // @return true if this NestedInteger holds a single integer, rather than a nested list.
                     public boolean isInteger();
        
                     // @return the single integer that this NestedInteger holds, if it holds a single integer
                     // Return null if this NestedInteger holds a nested list
                     public Integer getInteger();
        
                     // Set this NestedInteger to hold a single integer.
                     public void setInteger(int value);
        
                     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
                     public void add(NestedInteger ni);
        
                     // @return the nested list that this NestedInteger holds, if it holds a nested list
                     // Return null if this NestedInteger holds a single integer
                     public List<NestedInteger> getList();
         }
}