package binaryTree;

import binaryTree.Node;
import exceptions.NoInexistenteException;

public interface IArvoreBinaria extends IArvore {

  boolean isEmpty();

  void preOrdem(Node Node) throws NoInexistenteException;
  void iNoderdem(Node Node) throws NoInexistenteException;
  void posOrdem(Node Node) throws NoInexistenteException;
}