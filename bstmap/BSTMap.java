package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    private int size;
    private EntryNode root;
    public BSTMap(){

    }


    private class EntryNode{
        private K key;
        private V value;
        EntryNode left;
        EntryNode right;

        EntryNode(K key,V value){
            this.key=key;
            this.value= value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


    }
    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return get(key, root) != null;
    }

    @Override
    public V get(K key) {
        if(key==null) throw  new IllegalArgumentException("The  Input key is null");
        return  get(key, root);
    }

    private  V get(K key, EntryNode node){
        if(node== null ) return null;
        int cmd = key.compareTo(node.key);
        if(cmd < 0)  return  get(key, node.left);
        else if(cmd> 0) return  get(key, node.right);
        else  return  node.value;

    }




    @Override
    public int size() {
        return 0;
    }




    @Override
    public void put(K key, V value) {
        if(key== null || value==null) throw new IllegalArgumentException("Input key or value is null");
        if (root==null){
            root= new EntryNode(key,value);

        }else {
            put(root, key,value);

        }

    }
    private EntryNode put(EntryNode node , K key, V value){
          if(node == null) return new EntryNode(key, value);
          int cmd = key.compareTo(node.key);
          if(cmd<0) node.left= put(node.left, key, value);
          else if (cmd>0)   node .right=put(node.right, key, value);
          else node.value= value;

          return node;

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }



    @Override
    public Iterator iterator() {
        return null;
    }
}
