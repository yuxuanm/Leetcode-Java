package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q40 {
	public static void main(String[] args) {
		int [] candidates = new int[] {4,4,2,1,4,2,2,1,3};
		Q40 q40 = new Q40();
		List<List<Integer>> res=q40.combinationSum2(candidates, 6);
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list;
        for(int i=0;i<candidates.length;i++){
        	if(i!=0&&candidates[i]==candidates[i-1])
        		continue;
            if(candidates[i]<=target){
                list=new ArrayList<Integer>();
                list.add(candidates[i]);
                subCombine(candidates, candidates[i],target,list,i+1,res);
            }
        }
        return res;
    }

    private void subCombine(int[] candidates, int sum, int target, List<Integer> list, int index,List<List<Integer>> res){
        if(sum==target){
        	for(List<Integer> l:res) {
        		Collections.sort(l);
        		Collections.sort(list);
        		if(l.equals(list))
        			return;
        	}
            res.add(new ArrayList<Integer>(list));
        }

        for(int i=index;i<candidates.length;i++){
            if(candidates[i]+sum>target)
                return;
            list.add(candidates[i]);
            subCombine(candidates,sum+candidates[i],target,list,i+1,res);
            list.remove(list.size()-1);
        }

        return;
    }
}
