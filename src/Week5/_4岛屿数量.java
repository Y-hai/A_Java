package Week5;

import java.io.*;

public class _4岛屿数量 {
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static final int N = 110;
    static int[][] q = new int[N][N];
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        for (int i = 1; i <= n; i++) {
            arr = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                q[i][j] = Integer.parseInt(arr[j - 1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (q[i][j] == 1) {
                    q[i][j] = 0;
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        out.write(Integer.toString(cnt));
        out.flush();
    }

    private static void bfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (q[nx][ny] == 1) {
                q[nx][ny] = 0;
                bfs(nx, ny);
            }
        }
    }
}
