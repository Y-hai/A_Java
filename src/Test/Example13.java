package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class seg {
    int l, r;

    public seg(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

class Main {
    static int N = (int) 1e5+10;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(in.readLine());

        seg[] segs = new seg[n];
        String[] arr;
        for (int i = 0; i < n; i++) {
            arr = in.readLine().split(" ");
            int l = Integer.parseInt(arr[0]);
            int r = Integer.parseInt(arr[1]);
            segs[i] = new seg(l, r);
        }

        //将这些区间按右侧端点从小到大排序
        Arrays.sort(segs, new Comparator<seg>() {
            @Override
            public int compare(seg s1, seg s2) {
                return s1.r - s2.r;
            }
        });

        ///遍历整个区间集合
        int res = 0;
        int ed = (int) -2e9;
        for (int i = 0; i < n; i++) {
            seg cur = segs[i];
            if (ed < cur.l) {
                res++;
                ed = cur.r;
            }//如果当前的这个点不能覆盖这个区间，就更新ed的值
            //如果可以覆盖这个区间，就pass
        }
        System.out.println(res);
    }
}