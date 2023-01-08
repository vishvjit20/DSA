package Implementations;

import java.util.*;

public class HashMapImplementation {
    public static class HM<K, V> {
        private class HMNode {
            K key;
            V val;

            public HMNode(K key, V val) {
                this.key = key;
                this.val = val;
            }

            public String toString() {
                return this.key + "=" + this.val;
            }
        }

        private int size;
        private LinkedList<HMNode>[] buckets;

        private void initBucket(int n) {
            buckets = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public HM() {
            initBucket(4);
            size = 0;
        }

        public void put(K key, V val) {
            int bucketIdx = findBucketIdx(key);
            int dataIdx = findWithinBucket(key, bucketIdx);

            if (dataIdx == -1) {
                LinkedList<HMNode> list = buckets[bucketIdx];
                HMNode node = new HMNode(key, val);
                list.add(node);
                size++;
            } else {
                LinkedList<HMNode> list = buckets[bucketIdx];
                HMNode node = list.get(dataIdx);
                node.val = val;
            }

            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2) {
                rehash();
            }
        }

        private void rehash() {
            LinkedList<HMNode>[] oldBuckets = buckets;
            initBucket(2 * oldBuckets.length);
            size = 0;
            for (int i = 0; i < oldBuckets.length; i++) {
                for (int j = 0; j < oldBuckets[i].size(); j++) {
                    HMNode node = oldBuckets[i].get(j);
                    put(node.key, node.val);
                }
            }
        }

        private int findBucketIdx(K key) {
            int hash = key.hashCode();
            return Math.abs(hash % buckets.length);
        }

        private int findWithinBucket(K key, int idx) {
            LinkedList<HMNode> list = buckets[idx];
            for (int i = 0; i < list.size(); i++) {
                HMNode node = list.get(i);
                if (key.equals(node.key)) {
                    return i;
                }
            }
            return -1;
        }

        public V get(K key) {
            int bucketIdx = findBucketIdx(key);
            int dataIdx = findWithinBucket(key, bucketIdx);

            if (dataIdx == -1)
                return null;
            else {
                LinkedList<HMNode> list = buckets[bucketIdx];
                HMNode node = list.get(dataIdx);
                return node.val;
            }
        }

        public boolean containsKey(K key) {
            int bucketIdx = findBucketIdx(key);
            int dataIdx = findWithinBucket(key, bucketIdx);

            return dataIdx != -1;
        }

        public V remove(K key) {
            int bucketIdx = findBucketIdx(key);
            int dataIdx = findWithinBucket(key, bucketIdx);

            if (dataIdx == -1) {
                return null;
            } else {
                LinkedList<HMNode> list = buckets[bucketIdx];
                HMNode node = list.get(dataIdx);
                V val = node.val;
                size--;
                list.remove(dataIdx);
                return val;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> res = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    HMNode node = buckets[i].get(j);
                    res.add(node.key);
                }
            }
            return res;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.print("{ ");
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    HMNode node = buckets[i].get(j);
                    System.out.print(node.key + "=" + node.val + ", ");
                }
            }
            System.out.print(" }");

        }
    }

    public static void main(String[] args) {
        HM<Character, Integer> map = new HM<>();
        String str = "vishwajeet singh kushwah";
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        map.display();
    }
}
