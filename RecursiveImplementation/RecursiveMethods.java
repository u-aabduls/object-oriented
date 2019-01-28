import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * 
	 * @param n the first n Fibonacci numbers
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] fibArray(int n) {
		if (n == 1) {
			int[] b1 = { 1 };
			return b1;
		}
		if (n == 2) {
			int[] b2 = { 1, 1 };
			return b2;
		}

		int[] fibArray = new int[n];
		fibArray[0] = 1;
		fibArray[1] = 1;

		fibArrayHelper(fibArray, 2);

		return fibArray;
	}

	public void fibArrayHelper(int[] fibArray, int from) {
		if (from < fibArray.length) {
			fibArray[from] = (fibArray[(from - 1)] + fibArray[(from - 2)]);
			fibArrayHelper(fibArray, from + 1);
		}
	}

	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence. The
	 * Fibonacci starts with the first two numbers being 1 and 1, then starting from
	 * the 3rd number, it is the sum of the previous two numbers. You can assume
	 * that n is positive. e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * 
	 * @param n the first n Fibonacci numbers
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 *         You are forbidden to use the fibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> fibList(int n) {
		List<Integer> fibList = new ArrayList();
		int i = Integer.valueOf(1);

		if (n == 1) {
			fibList.add(i);
			return fibList;
		}

		if (n == 2) {
			fibList.add(i);
			fibList.add(i);
			return fibList;
		}

		fibList.add(i);
		fibList.add(i);
		fibListHelper(fibList, 2, n);
		return fibList;
	}

	public void fibListHelper(List<Integer> fibList, int from, int length) {
		if (from < length) {
			int i = Integer.valueOf(
					((Integer) fibList.get(from - 1)).intValue() + ((Integer) fibList.get(from - 2)).intValue());
			fibList.add(from, i);
			fibListHelper(fibList, from + 1, length);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibArray({1, 2}) returns false and
	 * isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibList method below to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibArray(int[] a) {
		if (a.length == 1) {
			boolean check = a[0] == 1;
			return check;
		}

		if (a.length == 2) {
			boolean check = (a[0] == 1) && (a[1] == 1);
			return check;
		}

		return isFibArrayHelper(a, a.length - 1);
	}

	public boolean isFibArrayHelper(int[] a, int from) {
		boolean isFib = true;

		if ((a[0] != 1) || (a[1] != 1)) {
			return false;
		}

		if ((from > 2) && (a[from] == a[(from - 2)] + a[(from - 1)])) {
			isFib = true;
			isFibArrayHelper(a, from - 1);

		} else {
			isFib = false;
		}

		return isFib;
	}

	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci
	 * sequence. The Fibonacci starts with the first two numbers being 1 and 1, then
	 * starting from the 3rd number, it is the sum of the previous two numbers. The
	 * array may or may not be empty. e.g., isFibList({1, 2}) returns false and
	 * isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * 
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci
	 *         numbers; false otherwise.
	 * 
	 *         You are forbidden to use the isFibArray method above to solve this
	 *         problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isFibList(List<Integer> list) {
		if (list.size() == 1) {
			boolean check = ((Integer) list.get(0)).intValue() == 1;
			return check;
		}

		if (list.size() == 2) {
			boolean check = (((Integer) list.get(0)).intValue() == 1) && (((Integer) list.get(1)).intValue() == 1);
			return check;
		}

		return isFibListHelper(list, list.size() - 1);
	}

	public boolean isFibListHelper(List<Integer> list, int from) {
		boolean isFib = true;

		if ((((Integer) list.get(0)).intValue() != 1) || (((Integer) list.get(1)).intValue() != 1)) {
			return false;
		}

		if ((from > 2) && (((Integer) list.get(from)).intValue() == ((Integer) list.get(from - 2)).intValue()
				+ ((Integer) list.get(from - 1)).intValue())) {
			isFib = true;
			isFibListHelper(list, from - 1);

		} else {
			isFib = false;
		}

		return isFib;
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] bA = new int[a.length + 1];

		if (a.length == 0) {
			bA[0] = i;
			return bA;
		}

		insertIntoSortedArrayHelper(bA, a, i, 0, true, false);
		return bA;
	}

	public void insertIntoSortedArrayHelper(int[] bA, int[] a, int i, int count, boolean found, boolean done) {
		if (count == bA.length) {
			done = true;
		} else if ((count == a.length) && (!done) && (found)) {
			done = true;
			bA[count] = i;
		}
		if ((found) && (!done) && (i > a[count])) {
			bA[count] = a[count];
			insertIntoSortedArrayHelper(bA, a, i, count + 1, found, done);
		} else if ((!found) && (!done)) {
			bA[count] = a[(count - 1)];
			insertIntoSortedArrayHelper(bA, a, i, count + 1, found, done);
		} else if (!done) {
			bA[count] = i;
			found = false;
			insertIntoSortedArrayHelper(bA, a, i, count + 1, found, done);
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		List<Integer> bA = new ArrayList();

		if (list.size() == 0) {
			bA.add(Integer.valueOf(i));
			return bA;
		}

		insertIntoSortedListHelper(bA, list, i, 0, true, false);
		return bA;
	}

	public void insertIntoSortedListHelper(List<Integer> bA, List<Integer> a, int i, int count, boolean found,
			boolean done) {
		if (count == a.size() + 1) {
			done = true;
		} else if ((count == a.size()) && (!done) && (found)) {
			done = true;
			bA.add(count, Integer.valueOf(i));
		}
		if ((found) && (!done) && (i > ((Integer) a.get(count)).intValue())) {

			bA.add(count, (Integer) a.get(count));
			insertIntoSortedListHelper(bA, a, i, count + 1, found, done);
		} else if ((!found) && (!done)) {
			bA.add(count, (Integer) a.get(count - 1));
			insertIntoSortedListHelper(bA, a, i, count + 1, found, done);
		} else if (!done) {

			bA.add(Integer.valueOf(i));
			found = false;
			insertIntoSortedListHelper(bA, a, i, count + 1, found, done);
		}
	}

	/**
	 * Given two sorted arrays left and right, return a sorted array of size
	 * left.length + right.length, consisting of all elements of arrays left and
	 * right.
	 * 
	 * @param left  a sorted array
	 * @param right a sorted array
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArrays({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedLists method below to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		if (left.length == 0) {
			return right;
		}
		if (right.length == 0) {
			return left;
		}

		int[] merged = new int[left.length + right.length];
		mergeSortedArraysHelper(merged, left, right, 0, 0, 0, false, false);
		return merged;
	}

	public void mergeSortedArraysHelper(int[] merged, int[] left, int[] right, int cL, int cR, int cM, boolean rDone,
			boolean lDone) {

		/*
		 * cL = countLeft cR = countRight cM = countMerge rDone = rightDone lDone =
		 * leftDone
		 */

		if (cL == left.length) {
			lDone = true;
		}

		if (cR == right.length) {
			rDone = true;
		}

		if ((!rDone) && (!lDone) && (left[cL] > right[cR])) {
			merged[cM] = right[cR];
			mergeSortedArraysHelper(merged, left, right, cL, cR + 1, cM + 1, rDone, lDone);

		} else if ((!rDone) && (!lDone) && (right[cR] > left[cL])) {
			merged[cM] = left[cL];
			mergeSortedArraysHelper(merged, left, right, cL + 1, cR, cM + 1, rDone, lDone);
		}
		if ((!rDone) && (lDone)) {
			merged[cM] = right[cR];
			mergeSortedArraysHelper(merged, left, right, cL, cR + 1, cM + 1, rDone, lDone);
		} else if ((rDone) && (!lDone)) {
			merged[cM] = left[cL];
			mergeSortedArraysHelper(merged, left, right, cL + 1, cR, cM + 1, rDone, lDone);
		}
	}

	/**
	 * Given two sorted lists left and right, return a sorted list of size
	 * left.size() + right.size(), consisting of all elements of lists left and
	 * right.
	 * 
	 * @param left  a sorted list
	 * @param right a sorted list
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedLists({1, 3, 5,
	 *         7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         You are forbidden to use the mergeSortedArrays method above to solve
	 *         this problem.
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		if (left.size() == 0) {
			return right;
		}
		if (right.size() == 0) {
			return left;
		}

		List<Integer> merged = new ArrayList();
		mergeSortedListHelper(merged, left, right, 0, 0, 0, false, false);
		return merged;
	}

	public void mergeSortedListHelper(List<Integer> merged, List<Integer> left, List<Integer> right, int cL, int cR,
			int cM, boolean rDone, boolean lDone) {

		/*
		 * cL = countLeft cR = countRight cM = countMerge rDone = rightDone lDone =
		 * leftDone
		 */

		if (cL == left.size()) {
			lDone = true;
		}

		if (cR == right.size()) {
			rDone = true;
		}

		if ((!rDone) && (!lDone) && (((Integer) left.get(cL)).intValue() > ((Integer) right.get(cR)).intValue())) {

			merged.add((Integer) right.get(cR));
			mergeSortedListHelper(merged, left, right, cL, cR + 1, cM + 1, rDone, lDone);

		} else if ((!rDone) && (!lDone)
				&& (((Integer) right.get(cR)).intValue() > ((Integer) left.get(cL)).intValue())) {

			merged.add((Integer) left.get(cL));
			mergeSortedListHelper(merged, left, right, cL + 1, cR, cM + 1, rDone, lDone);
		}
		if ((!rDone) && (lDone)) {
			merged.add((Integer) right.get(cR));
			mergeSortedListHelper(merged, left, right, cL, cR + 1, cM + 1, rDone, lDone);
		} else if ((rDone) && (!lDone)) {
			merged.add((Integer) left.get(cL));
			mergeSortedListHelper(merged, left, right, cL + 1, cR, cM + 1, rDone, lDone);
		}
	}

}
