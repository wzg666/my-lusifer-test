import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author wzg
 * Date 2020/10/15 23:13
 * Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int[] regions = {18,19,241,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int[] spots1 = {13,8,9,14,17,241,47,57,58,59,69,70,71,72,83,84,85,86,98,99,100,101};
        int[] spots2 = {13,8,9,14,17,241,47,57,58,59,69,70,71,72,83,84,85,86,98,99,100,101};
        int[] spots3 = {13,8,9,14,17,241,47,57,58,59,69,70,71,72,83,84,85,86,98,99,100,101};
        int[] spots4 = {};
        int[] spots5 = {};
        Arrays.sort(regions);
        List regionsArr = new ArrayList();
        for (int i = 0; i < regions.length; i++) {
            regionsArr.add(regions[i]);
        }
        System.out.println(regionsArr);
        List<Integer> list = Test.getList(Test.getList(Test.getList(Test.getList(Test.getList(new ArrayList<>(), spots1), spots2), spots3), spots4), spots5);
        System.out.println(list);
    }

    public static List<Integer> listSort(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (set.add(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        Collections.sort(newList);
        return newList;
    }

    public static List<Integer> getList(List<Integer> list, int[] arr) {
        List<Integer> sortList = Test.listSort(list);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < sortList.size(); i++) {
            set.add(sortList.get(i));
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.add(arr[i])) {
                sortList.add(arr[i]);
            }
        }
        Collections.sort(sortList);
        return sortList;
    }
}
