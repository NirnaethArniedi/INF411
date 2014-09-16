import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * An implementation of an ordered set based on binary search trees
 */
public class BSTSet // implements OrderedSet
{

	  TreeNode root;

	  /**
	   * Create an empty binary search tree
	   */
	  public BSTSet() {
		  this.root=null;
	  }
	  
	  /**
	   * Create an empty binary search tree
	   */
	  public BSTSet(TreeNode root) {
		  this.root=root;
	  }

	  /**
	   * Check whether a given element already exists
	   */
	  public boolean contains(int element) {
		  return TreeNode.contains(this.root, element);
	  }
	  
	  /**
	   * Return the smallest element in the set. Return null if the set is empty
	   */
	  public Integer getMin() {
		  return TreeNode.getMin(this.root);
	  }

	  /**
	   * Check whether the set is empty
	   */
	  public boolean isEmpty() {
		  return this.root==null;
	  }

	  /**
	   * Check whether two sets are equals
	   */
	  public boolean equals(BSTSet s) {
		  BSTSet t=(BSTSet)s;
		  return TreeNode.equals(this.root, t.root);
	  }

	  /**
	   * Check whether the set is a subset of s
	   */
	  public boolean subset(BSTSet s) {
		  BSTSet t=(BSTSet)s;
		  return TreeNode.subset(this.root, t.root);
	  }

	  /**
	   * Add a new element in the ordered set: order on elements is preserved
	   * Elements are added only once
	   */
	  public void add(int element) {
		  this.root=TreeNode.add(this.root, element);
	  }

	  /**
	   * Return a new set obtained as the union of two given sets
	   */
	  public BSTSet union(BSTSet s) {
		  BSTSet t=(BSTSet)s;
		  return new BSTSet(TreeNode.union(this.root, t.root));
	  }
	  
	  /**
	   * Return a String representing the (ordered) set
	   */
	  public String toString() {
		  if(this.root==null)
			  return "[]";
		  return "["+this.root.infixOrder()+"]";
	  }

}
