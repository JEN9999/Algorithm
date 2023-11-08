package Algorithm.Devide;
//분할 정복(Divide and Conquer
// 큰 문제를 작은 부분 문제로 나누어 해결 : 합병정렬, 퀵정렬, 이진검색 ...
// 과정
// 1. 문제를 하나이상의 작은 부분으로 분할
// 2. 부분을 각각 정ㄴ복
// 3. 부분들의 해답을 통해 원래 문제의 답을 구함

public class Main {

    public static int getMax(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if(left == right){
            return arr[left];
        }

        left = getMax(arr,left, mid);
        right = getMax(arr, mid+1, right);

        return (left > right) ? left : right;
    }


    public static void main(String[] args) {
        int arr[] = {6, 2, 9, 8, 1, 4, 17, 5};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
