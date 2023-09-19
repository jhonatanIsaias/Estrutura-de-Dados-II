package binaryTree;

import binaryTree.Node;
import exceptions.ArvoreVaziaException;
import exceptions.NoInexistenteException;

public interface IArvoreBinaria extends IArvore {

  boolean isEmpty() throws ArvoreVaziaException;

  void preOrdem(Node Node) throws NoInexistenteException;
  void iNoderdem(Node Node) throws NoInexistenteException;
  void posOrdem(Node Node) throws NoInexistenteException;
}