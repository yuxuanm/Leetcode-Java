package array;

public class Q739DailyTemperatures {

        /**
        * Method 1: Brute force
         *  two iterations
        *
        * @Result: runtime: 1398 ms beats 11.67% memory 47.8 mb beats 23.08
        * */
        public int[] dailyTemperatures(int[] temperatures) {
            int [] res = new int[temperatures.length];
            int cnt = 1;
            for(int i =0;i<temperatures.length;i++){
                if(i==temperatures.length-1){
                    res[i]=0;
                }else{
                    for(int j = i+1; j< temperatures.length; j++){
                        if(temperatures[j]<=temperatures[i]){
                            if(j==temperatures.length-1){
                                res[i]=0;
                                cnt =1;
                                break;
                            }
                            cnt+=1;
                        }
                        else{
                            res[i] = cnt;
                            cnt = 1;
                            break;
                        }
                    }
                }
            }
            return res;
        }

        /**
         * Method 2: stack
         * one stack stores values
         * one stack stores index
         *
         * Results: runtime 51 ms beats 24.42% memory 55.5MB beats 5.01%
         * */
        public int[] dailyTemperatures2(int[] temperatures) {
            int res [] = new int[temperatures.length];

            Stack<Integer> value = new Stack<Integer>();
            Stack<Integer> index = new Stack<Integer>();

            for (int i = 0;i<temperatures.length;i++){
                if(value.isEmpty()){
                    value.push(temperatures[i]);
                    index.push(i);
                }else{
                    while(!value.isEmpty() && temperatures[i]>value.peek()){
                        value.pop();
                        res[index.peek()]= i - index.pop();
                    }
                    value.push(temperatures[i]);
                    index.push(i);
                }

                if(i==temperatures.length-1){
                    res[i] = 0;
                    if(!value.isEmpty()){
                        res[index.peek()] = 0;
                    }
                }
            }
            return res;
        }

        /**
         * Improvement on method 2:
         * use one stack to store index
         *
         * Results : runtime 39ms beats 34.32% memory 47.4mb beats 35.16%
         * */
        public int[] dailyTemperatures3(int[] temperatures) {
            int res []= new int[temperatures.length];
            Stack<Integer> stack = new Stack<Integer>();
            for(int i = 0; i < temperatures.length; i++){
                int temperature = temperatures[i];
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    while(!stack.isEmpty()&&temperature > temperatures[stack.peek()]){
                        res[stack.peek()] = i - stack.pop();
                    }
                    stack.push(i);
                }

                if(i==temperatures.length-1){
                    res[i] = 0;
                    if(!stack.isEmpty())
                        res[stack.pop()]=0;
                }
            }
            return res;
        }
}

