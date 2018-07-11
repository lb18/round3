package question1;

import java.util.Arrays;

/**
 * Please implement Dynamic Array Interface 
 * @author 
 *
 */
public class MyCollection implements DynamicArray{
// Uncomment commented section
	
	/**
	 * You can declare local/global variables as per your requirement
	 */
	@SuppressWarnings("unused")
	private int[] numArray;
	private int cur_size, num_of_elements_added = 0, cnt = 0;
	/**
	 * It constructs an empty Collection object with an array capacity specified by the integer
		parameter "arraySize".
	 */
	public MyCollection(int arraySize){
		numArray = new int[arraySize];
		cur_size = arraySize;
	}

	public int search(int searchingNum) {
		// TODO Auto-generated method stub
		if (cnt == 0) return -1;
		int tmp[] = new int[cnt];
		for (int i = 0; i < cnt; i++) tmp[i] = numArray[i];
		Arrays.sort(tmp, 0, cnt);
		int st = 0, ed = cnt;
		while (st <= ed)
		{
			int mid = (st+ed)/2;
			if (numArray[mid] == searchingNum) return mid;
			else if (numArray[mid] > searchingNum) ed = mid-1;
			else st = mid+1;
		}
		return -1;
	}

	public boolean add(int numberToAdd) {
		// TODO Auto-generated method stub
		if (search(numberToAdd) == -1)
		{
			if (cnt+1 > cur_size) doubleCapacity();
			numArray[cnt] = numberToAdd;
			cnt++;
			num_of_elements_added++;
			return true;
		}
		return false;
	}

	public void doubleCapacity() {
		// TODO Auto-generated method stub
		cur_size *= 2;//System.out.println(cur_size);
		int tmp[] = new int[cur_size];
		for (int i = 0; i < cnt; i++)
			tmp[i] = numArray[i];
		numArray = tmp;
	}

	public boolean remove(int numberToRemove) {
		// TODO Auto-generated method stub
		if (search(numberToRemove) != -1)
		{
			int idx = 0;
			for (int i = 0; i < cnt; i++)
				if (numArray[i] == numberToRemove)
				{
					idx = i;
					break;
				}
			for (int i = idx; i < cnt-1; i++)
					numArray[i] = numArray[i+1];
			return true;
		}
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return num_of_elements_added;
	}

	public int[] rotate(int n) {
		// TODO Auto-generated method stub
		int tmp[] = new int[cur_size];
		for (int i = 0; i < cnt; i++) tmp[i] = numArray[(i+n)%cnt];
		for (int i = 0; i < cnt; i++) numArray[i] = tmp[i];
		return numArray;
	}
	
	public String toString()
	{
		String str = "{";
		for (int i = 0; i < cnt; i++)
		{
			if (i != cnt-1) str += numArray[i] + ",";
			else str += numArray[i];
		}
			
		str += "}";
		return str;
	}
	

}
