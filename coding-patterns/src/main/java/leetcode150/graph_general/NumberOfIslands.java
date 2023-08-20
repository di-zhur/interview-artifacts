package leetcode150.graph_general;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int h = grid.length; // height
        if (h == 0)
            return 0;
        int w = grid[0].length; // width
        int count = 0;

        boolean[][] visited = new boolean[h][w];

        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    // No need to clear queue, since previous bfs stops only when queue is empty
                    queue.add(new Integer[]{i, j});
                    BFS(queue, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void BFS(Queue<Integer[]> queue, char[][] islandGrid, boolean[][] visited) {

        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (!queue.isEmpty()) {

            Integer[] x = queue.remove();
            int row = x[0];
            int col = x[1];

            if (row < 0 || col < 0 || row >= H || col >= L || visited[row][col] || islandGrid[row][col] != '1')
                continue;

            visited[row][col] = true;
            queue.add(new Integer[]{row, (col - 1)});
            queue.add(new Integer[]{row, (col + 1)});
            queue.add(new Integer[]{(row - 1), col});
            queue.add(new Integer[]{(row + 1), col});
        }
    }
}
