package binaryTree;

import binaryTree.Node;
import exceptions.ArvoreVaziaException;
import exceptions.NoInexistenteException;


public interface IArvore {

  void addValue(Node Node, int value) throws Exception;
  Node remove(Node Node,Node current ) throws NoInexistenteException, ArvoreVaziaException;
  Node find(Node Node,Node root) throws NoInexistenteException, ArvoreVaziaException;

  Node visit(Node Node) throws NoInexistenteException;
  
  boolean isEmpty() throws ArvoreVaziaException;
  boolean isComplete();
  int height();
  
  void printTree();
}