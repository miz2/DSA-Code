import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumber {
  
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
    Collections.sort(nums);
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 1; i < nums.size() - 1; i++) {
        if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
            list.add(nums.get(i));
        }
    }

    if (nums.size() == 1) {
        list.add(nums.get(0));
    }

    if (nums.size() > 1) {
        if (nums.get(0) + 1 < nums.get(1)) {
            list.add(nums.get(0));
        }
        if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
            list.add(nums.get(nums.size() - 1));
        }
    }

    return list;
}


    public static void main(String[] args) {
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(1);
        pair.add(3);
        pair.add(5);
        pair.add(3);
        ArrayList<Integer> list = findLonely(pair);
        System.out.println(list);
    }
}
