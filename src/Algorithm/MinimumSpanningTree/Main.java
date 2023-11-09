package Algorithm.MinimumSpanningTree;
// 알고리즘 - 최소 신장 트리
// 크루스칼 알고리즘
// MST 그래프 상의 모든 노드들을 최소비용으로 연결하는 방법
// 간선중 최소 값을 가진 간선부터 연결
// 사이클 발생 시 다른 간선 선택
// 간선 수가 적을때 주로 사용 O(ElogE)
// 사이크 발생 체크 >> Unioin-Find : 자기자신 > 작은넘버링 변경

import java.util.Arrays;

public class Main {
    static int parents[];
    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;
        // 오름차순 정렬
        Arrays.sort(data, (x, y) -> x[2] - y[2]);

        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            if(find(data[i][0]) != find(data[i][1])){
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }


        return weightSum;
    }

    //연결이 되었을때 두개의 노드를 같은 집합으로 묶어줌
    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);
        if(aP != bP){
            parents[aP] = bP;
        }
    }
    //최종적으로 연결되잇는 노드를 찾음
    public static int find(int a){
        if(a == parents[a]){
            return a;
        }
        // 사이클 체크를 위한 업데이트
        return parents[a] = find(parents[a]);
    }
    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(kruskal(graph, v, e));
    }
}
