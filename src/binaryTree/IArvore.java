package binaryTree;

import binaryTree.Node;
import exceptions.NoInexistenteException;


public interface IArvore {

  void addValue(Node Node, int value) throws Exception;
  Node remove(Node Node) throws NoInexistenteException;
  Node find(Node Node) throws NoInexistenteException;

  Node visit(Node Node) throws NoInexistenteException;
  
  boolean isEmpty();
  boolean isComplete();
  int height();
  
  void printTree();
}