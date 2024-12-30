package data.structures.hashmap;

import java.util.HashMap;

public class RandomPool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(K key) {
        if (!this.keyIndexMap.containsKey(key)) {
            this.keyIndexMap.put(key, this.size);
            this.indexKeyMap.put(this.size, key);
            this.size = this.size + 1;
        }
    }

    public void delete(K key) {
        if (!this.keyIndexMap.containsKey(key)) {
            return;
        }
        Integer deleteIndex = this.keyIndexMap.get(key);
        //接下来要将map中最后一个index取出来，插到要删除的index处
        int lastIndex = this.size - 1;
        K lastKey = this.indexKeyMap.get(lastIndex);
        //将最后一个index处的key插入到要删除的index处
        this.keyIndexMap.put(lastKey, deleteIndex);
        this.indexKeyMap.put(deleteIndex, lastKey);
        //最后将要删除的key删掉
        this.keyIndexMap.remove(key);
        this.indexKeyMap.remove(lastIndex);
        this.size = this.size - 1;
    }

    public K getRandom() {
        if (this.size == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * this.size);
        return this.indexKeyMap.get(randomIndex);
    }


}
