//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        /**
         * 深度优先
         */
//        int provinces=isConnected.length;//最多的省份个数
//        boolean[] visited =new boolean[provinces];
//        int count=0;//计数
//        for (int i = 0; i <provinces ; i++) {
//            if (!visited[i]){
//                dfs(isConnected,visited,provinces,i);
//                count++;
//            }
//        }
        /**
         * 广度优先算法
         */
//        int provinces=isConnected.length;
//        boolean[] visited=new boolean[provinces];
//        int count=0;
//        //定义队列
//        Queue<Integer> queue=new LinkedList<Integer>();
//        for (int i = 0; i <provinces ; i++) {
//            if (!visited[i]){
//                queue.offer(i);
//                while(!queue.isEmpty()){
//                      int j=queue.poll();
//                      visited[j]=true;//标记为已访问
//                      for (int k = 0; k <provinces ; k++) {
//                        if(isConnected[j][k]==1&&!visited[k])
//                            queue.offer(k);
//                    }
//                }
//                count++;
//            }
//        }
//        return count;

        /**
         * 并查集
         * 遍历矩阵，如果城市之间相互连接，则他们属于同一个分量，对他们合并
          */
        int provinces=isConnected.length;
        int[] parent=new int[provinces];
        for (int i = 0; i <provinces ; i++) {
            parent[i]=i;//每个城市都是独立的一个分量
        }
        for (int i = 0; i <provinces ; i++) {
            for (int j = i+1; j < provinces; j++) {
                if (isConnected[i][j]==1)
                    union(parent,i,j);//合并i和j
            }
        }
        //统计分量个数
        int count=0;
        for (int i = 0; i <provinces ; i++) {
            if(parent[i]==i)
                count++;
        }
        return count;

    }

    /**
     * 深度优先搜索
     * 时间复杂度O(n^2)
     * @param isConnected
     * @param visited
     * @param provinces
     * @param i
     */
    public void dfs(int[][] isConnected,boolean[] visited,int provinces,int i){
        for (int j = 0; j <provinces ; j++) {
            if (isConnected[i][j]==1&&!visited[j]){
                visited[j]=true;//标记为已访问
                dfs(isConnected,visited,provinces,j);
            }
        }
    }

    public void union(int[] parent,int i,int j){
        parent[find(parent,i)]=find(parent,j);

    }

    public int find(int[] parent,int index){
        if(parent[index]!=index){
            parent[index]=find(parent,parent[index]);
        }
        return parent[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
