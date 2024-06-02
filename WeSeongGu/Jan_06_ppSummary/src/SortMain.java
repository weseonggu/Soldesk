import java.util.Arrays;

public class SortMain {
	public static void bubbleSort(int[] no) {
		int t = 0;
		for (int i = 1; i < no.length; i++) {
			for (int j = 0; j < no.length-i; j++) {
				if (no[j] >= no[j+1]) {
					t = no[j];
					no[j] = no[j+1];
					no[j+1] = t;
				}
			}
		}
	}
	
	public static void mySort(int[] no) {
		int t = 0;
		for (int i = 0; i < no.length; i++) {
			for (int j = 1 + i; j < no.length; j++) {
				if (no[i] >= no[j]) {
					t = no[i];
					no[i] = no[j];
					no[j] = t;
				}
			}
		}
	}
	public static void selectionSort(int[] no) {
		int min;
		int minIndex;
		int t;
		for (int turn = 0; turn < no.length; turn++) {
			min=no[turn];
			minIndex=turn;
			for (int i = turn+1; i < no.length; i++) {
				if(min>no[i]) {
					min=no[i];
					minIndex=i;
				}
			}
			t= no[turn];
			no[turn]=no[minIndex];
			no[minIndex]=t;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] no = { 15,999, 4665, 4189, 357, 15, 654, 21, 655, 777, 777 };
		for (int i : no) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
//		bubbleSort(no);
//		selectionSort(no);
		Arrays.sort(no);

		for (int i : no) {
			System.out.print(i + " ");
		}
	}
}
