package Test;

import java.util.Scanner;

// 迷宫解救
public class Example12 {
    static int n, m, p, q, min = 99999999;//n,m为迷宫的边界  （p，q）为最终位置      min代表最小步数
    static int[][] a = new int[51][51];//迷宫的方位图
    static int[][] book = new int[51][51];//标记哪些位置已经走过的 1代表走过，反则为0

    static void dfs(int x, int y, int step) {
        int[][] next = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//分别代表向右，下，左，上
        int tx, ty, k;//(tx,ty)代表实时位置     k代表中间量
        if (x == p && y == q) {
            if (step < min) {
                min = step;
            }
            return;
        }
        for (k = 0; k <= 3; k++) {
            tx = x + next[k][0];
            ty = y + next[k][1];
            //判断越界
            if (tx < 1 || tx > n || ty < 1 || ty > m) {
                continue;
            }
            //判断该点是否为障碍物点或者已经走过的点
            if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                book[tx][ty] = 0;
            }
        }
        return;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();//迷宫的行列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = input.nextInt();//输入迷宫哪些地方有障碍物，有为1，没有为0
            }
        }
        int startx = input.nextInt();
        int starty = input.nextInt();//输入起始点
        p = input.nextInt();
        q = input.nextInt();//输入目标点
        book[startx][starty] = 1;//起始位置绝对走过
        dfs(startx, starty, 0);
        System.out.println(min);
        input.close();
    }

}