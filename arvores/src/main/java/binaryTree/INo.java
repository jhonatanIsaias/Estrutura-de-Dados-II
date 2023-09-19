package binaryTree;

public interface INo extends Comparable<Node> {

  void setValue(int valor);
  void setFather(Node node);
  void setLeft(Node node);
  void setRight(Node node);
  
  int getValue();
  Node getFather();
  Node getLeft();
  Node getRight();
  
}