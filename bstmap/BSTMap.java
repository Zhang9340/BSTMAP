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
      if(key == null)  throw  new IllegalArgumentException("The key is null");
      if(containsKey(key)){
         V res= get(key);

         root =remove(root, key);

         return res;

      }
      return null;

    }
    private EntryNode remove(EntryNode node , K key){
        int cmd = key.compareTo(node.key);
        if(cmd<0){

             node.left= remove(node.left, key);

        } else if (cmd> 0) {

              node.right=remove(node.right, key);
        }else {
            // if the node has no children deleted
            // if the node has one child  delete the node and connect the node
            if(node.left==null) {
                size--;
                return node.right;

            }
            if(node.right == null){
                size--;
                return node.left;
            }

            // if the node has left and right node tree, we will take the biggest node in the left tree as new root
            //or use the smallest node in the right tree as new root;

            EntryNode rightmax= min(root.right);

             node.right=deleteMin(root.right);
             rightmax.left = node.left;
             rightmax.right = node.right;
             node =rightmax;

        }
        return node;

    }
    public EntryNode min(EntryNode root){
        if(root.left== null) return root;
        return min(root.left);

    }
    public EntryNode deleteMin(EntryNode root){
       if(root.left==null) {
           size--;
           root= root.right;
           return root;
       }

       root.left =deleteMin(root.left);
       return root;
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
