## Popular algorithm Q and Solutions

1. Given an array of integers, return indices of the two numbers such that they add up to a specific target.

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

```java

public static int[] findTwoSum (int[] input, int target) {
     int[] result = new int[2];
     Map<Integer, Integer> store = new HashMap<Integer, Integer>();
     for(int i=0; i< input.length; i++) {
        int rem = target-input[i];
        if (store.containsKey(rem)) {
            result[0] = store.get(rem);
            result[1] = i;
            return result;
        }
        store.put(input[i], i);
     }
     return new int[]{0,0};
}
  
```
