package Algorithm.Sort.Shell;
// 셸 정렬
//삽입 정렬의 약점을 보완
//- 오름 차순 정렬 기준, 내림차순으로 구성된 데이터에 대해서는 앞의 데이터와 하나씩비교하여 모두 교환
//이전의 모든 데이터와 비교하지 않고 일정 간격을 두고 비교 O(n^2)

import java.util.Arrays;

public class Main {

    public static void shellSort(int[] arr) {
        int gap = arr.length /2;

        for (int g = gap; g > 0 ; g /= 2) {
            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];

                int j = 0;
                for (j = i - g; j >= 0 ; j-= g) {
                    if(arr[j] > tmp){
                        arr[j + g] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j + g] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        shellSort(arr);
        System.out.println("셸 정렬: " + Arrays.toString(arr));
    }
}
