package Algorithm.Sort.Counting;
// 계수 정렬
//숫자끼리 비교하지 않고 카운트를 세서 정렬
//카운팅을 위한 메모리 O(n + k)

import java.util.*;

public class Main {
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while(cntArr[i] > 0){
                arr[idx++] = i;
                cntArr[i] -= 1;
            }
        }

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int item: arr){
//            map.put(item, map.getOrDefault(item,0) + 1);
//        }
//
//        int idx2 = 0;
//        ArrayList<Integer> list = new ArrayList<>(map.keySet());
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            int cnt = map.get(list.get(i));
//            while( cnt > 0){
//                arr[idx2++] = list.get(i);
//                cnt--;
//            }
//        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
