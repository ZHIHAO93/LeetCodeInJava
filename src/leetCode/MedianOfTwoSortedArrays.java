package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		TreeMap<Double, Double> tree = new TreeMap<Double, Double>();
		double median = 0.0;
		int p = 0, q = 0;
		int size = 0;

		while (p < nums1.length || q < nums2.length) {
			if (p < nums1.length) {
				tree.put((double) size, (double) nums1[p]);
				p++;
				size++;
			}
			if (q < nums2.length) {
				tree.put((double) size, (double) nums2[q]);
				q++;
				size++;
			}
		}

		ArrayList<Double> list = new ArrayList<Double>(tree.values());
		list.sort(new Comparator<Double>() {

			public int compare(Double o1, Double o2) {
				if (o1 < o2)
					return 1;
				else if (o1 > o2)
					return -1;
				else
					return 0;
			}

		});
		int n = size / 2;

		if (size % 2 == 0)
			median = (list.get(n - 1) + list.get(n)) / 2;
		else
			median = list.get(n);

		return median;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 2 };
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
	}
}
