package coderpad;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    //strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }


    TreeNode root =  new TreeNode(6);
    root.insert(4);
    root.insert(8);
    root.insert(3);
    root.insert(5);
    root.insert(7);
    root.insert(9);
    root.insert(1);
    root.insert(20);

    ArrayList<Integer> inorderlist =  new ArrayList<Integer>();

    root.getInoderTraversal(inorderlist);


    int kthindex = 3;
    
    System.out.println("Inorder list "+ inorderlist);

    System.out.println("Kth element index "+kthindex +" is : " + inorderlist.get(kthindex));



  }
}

class TreeNode{

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }



  public void insert(int data){

    if(data > this.val){

      if(right==null){
        right = new TreeNode(data);
      }else{
        right.insert(data);
      }

    }else{

      if(left==null){
        left = new TreeNode(data);
      }else{
        left.insert(data);
      }


    }


  }



  public TreeNode getRightNode(List<Integer> vals){

    vals.add(this.val);
    if(this.right == null) {

      if(this.left!=null) {
        return this.left.getRightNode(vals);
      }else {
        return null;
      }
    }else {
      return this.right.getRightNode(vals);
    }

  }


  public void getInoderTraversal(ArrayList<Integer> resultlist){

	  if(left!=null) {

		  left.getInoderTraversal(resultlist);
	  }

    resultlist.add(val);

    if(right!=null) {
    	right.getInoderTraversal(resultlist);
    }



  }







}
