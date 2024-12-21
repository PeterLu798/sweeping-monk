package data.structures.greed;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_IPO {
    public class Node {
        //成本
        public int cost;
        //净利润
        public int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    //小根堆：成本越小的排前面
    public class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    //大根堆：利润最大的排前面
    public class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    /**
     * 计算最多能挣多少钱
     *
     * @param k       最多能接多少项目
     * @param capital 启动资金
     * @param profits 项目利润
     * @param costs   项目成本
     * @return
     */
    public int findMaximizedCapital(int k, int capital, int[] profits, int[] costs) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Node(costs[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().cost <= capital) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return capital;
            }
            capital += maxProfitQ.poll().profit;
        }
        return capital;
    }
}
