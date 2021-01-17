package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Q46Permutations {

	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> tmp = new ArrayList<Integer>();
        backtrack(res, tmp, numsList);
		return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, List<Integer> nums){
        if(nums.size()==0)
            res.add(new ArrayList<Integer>(tmp));
        for(int i = 0; i< nums.size();i++){
            int cur = nums.remove(i);
            tmp.add(cur);
            backtrack(res, tmp, nums);
            tmp.remove(tmp.size()-1);
            nums.add(i,cur);
        }
    }
}
