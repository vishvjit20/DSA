package StacksAndQueue;

import java.util.*;

public class MaximumFrequencyStack {
    Map<Integer, Stack<Integer>> freqStack;
    Map<Integer, Integer> freqMap;
    int maxFreq = 0;

    public MaximumFrequencyStack() {
        freqStack = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int currFreq = freqMap.get(val);
        maxFreq = Math.max(maxFreq, currFreq);
        Stack<Integer> stk = freqStack.getOrDefault(currFreq, new Stack<>());
        stk.push(val);
        freqStack.put(currFreq, stk);
    }

    public int pop() {
        Stack<Integer> st = freqStack.get(maxFreq);
        int val = st.pop();
        freqMap.put(val, freqMap.getOrDefault(val, 0) - 1);
        if (st.size() == 0) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }

        return val;
    }
}
