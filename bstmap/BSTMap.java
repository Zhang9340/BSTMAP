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
          size=0;
          root=null;
    }

    @Override
    public boolean containsKey(K key) {
       if(key==null ) throw  new IllegalArgumentException("The Input key is null");
       return  containsKey(root,key);
    }
    private  boolean containsKey(EntryNode node, K key){
        if(node== null ) return false;
        int cmd = key.compareTo(node.key);
        if(cmd < 0)  return  containsKey(node.left,key);
        else if(cmd> 0) return  containsKey(node.right,key);
        else  return  true;


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
        return size;
    }




    @Override
    public void put(K key, V value) {
        if(key== null ) throw new IllegalArgumentException("Input key or value is null");

        if (root==null){
            size++;
            root= new EntryNode(key,value);

        }else {
            put(root, key,value);

        }

    }
    private EntryNode put(EntryNode node , K key, V value){
          if(node == null) {
              size++;
              return new EntryNode(key, value);
          }
          int cmd = key.compareTo(node.key);
          if(cmd<0) node.left= put(node.left, key, value);
          else if (cmd>0)   node .right=put(node.right, key, value);
          else node.value= value;

          return node;

    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();

    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }



    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();

    }
}
