package binaryTree;

import exceptions.ArvoreVaziaException;
import exceptions.NoInexistenteException;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree implements IArvoreBinaria{
    private Node root;



    /**
     *
     * @param node esse parâmetro indica o nó o qual queremos adicionar na árvore.
     * @param value esse parâmetro indica o valor que deve ser adicionado dentro do nó
     *
     * o método addValue adiciona  o valor dentro nó e chama a função addNode que ,de forma recursiva
     * localiza o local certo de inserção do nó.
     */
    @Override
    public void addValue(Node node, int value) throws Exception {
        node.setValue(value);
        root = addNode(root,node);


    }

    /**
     *
     * @param current indica a posição a ser testada para adicionar o nó caso ela seja nula.
     * @param node indica o nó a ser adicionado.
     *
     *  esse metodo testa se o no a ser adicionado deve ficar na sub arvore direita, caso seja maior que o root, ou esquerda caso
     *  seja menor. fazendo chamadas recursivas até encontrar a posição correta.
     * @return
     */
    private Node addNode(Node current, Node node) {

        if(current == null){
            current = node;

        }
        else if(current.compareTo(node) > 0){
            current.setLeft(addNode(current.getLeft(),node));
            current.getLeft().setFather(current);
        }
        else if(current.compareTo(node) < 0){
            current.setRight(addNode(current.getRight(),node));
            current.getRight().setFather(current);
        }

        return current;
    }

    /**
     * Remove um nó da árvore . Fazendo a chamada do método removeRoot caso o no a ser removido seja o root.caso  contrário
     * o método a ser chamado seria o removeNode, procurando o no a ser removido na arvore e passando seu pai.
     *
     * @param node O nó a ser removido.
     * @return O nó removido.
     * @throws NoInexistenteException Se o nó não existe na árvore.
     * @throws ArvoreVaziaException   Se a árvore estiver vazia.
     */
    @Override
    public Node remove(Node node) throws NoInexistenteException, ArvoreVaziaException {


        if(isEmpty()){
            throw new ArvoreVaziaException("arvore vazia");
        }
        if(node.compareTo(root) == 0){
            return removeRoot();
        }
        Node nodeRemove = find(node);
        Node nodeFather = nodeRemove.getFather();

        removeNode(nodeRemove,nodeFather);


        return nodeRemove;
    }

    /**
     *  esse método testa o cenários que o nó a ser removido pode se encontrar. ele pode estar a direita ou a esquerda do seu pai
     *  mudando assim a posição de seus proprios filhos dependo do lado.
     *
     * @param nodeRemove nó a ser removido
     * @param nodeFather pai do nó a ser removido
     */

    private void removeNode(Node nodeRemove,Node nodeFather){
        if(nodeRemove.compareTo(nodeFather) > 0){
            if(nodeRemove.getRight() == null && nodeRemove.getLeft() == null){
                nodeFather.setRight(null);
            }
            else if(nodeRemove.getRight() == null && nodeRemove.getLeft() != null){
                nodeFather.setRight(nodeRemove.getLeft());
            }
            else if(nodeRemove.getRight() != null && nodeRemove.getLeft() == null ){
                nodeFather.setRight(nodeRemove.getRight());
            }
            else{
                nodeFather.setRight(nodeRemove.getRight());
                nodeFather.getRight().setLeft(nodeRemove.getLeft());
            }
        }
        else{
            if(nodeRemove.getRight() == null && nodeRemove.getLeft() == null){
                nodeFather.setLeft(null);
            }
            else if(nodeRemove.getRight() == null && nodeRemove.getLeft() != null){
                nodeFather.setLeft(nodeRemove.getLeft());
            }
            else if(nodeRemove.getRight() != null && nodeRemove.getLeft() == null ){
                nodeFather.setLeft(nodeRemove.getRight());
            }
            else{
                nodeFather.setLeft(nodeRemove.getRight());
                nodeFather.getLeft().setLeft(nodeRemove.getLeft());
            }
        }
    }

    /**
     *
     * método testa o cenario que o root se encontra, com dois filhos, com um único filho a direita ou com um único filho a esquerda.
     * se tiver ambos os filhos é procurado o maior nó na subarvore esquerda que será o novo root.
     * @return retorna o valor do root removido
     * @throws NoInexistenteException Se o nó não existe na árvore.
     * @throws ArvoreVaziaException   Se a árvore estiver vazia.
     */
    private Node removeRoot() throws ArvoreVaziaException, NoInexistenteException {
        Node rootRemove = root;
        if (root.getLeft() == null && root.getRight() == null) {

            root = null;
            return rootRemove;
        }
        if (root.getLeft() != null && root.getRight() == null) {

            root = root.getLeft();
            root.setFather(null);
            return rootRemove;
        }
        if (root.getLeft() == null && root.getRight() != null) {

            root = root.getRight();
            root.setFather(null);
            return rootRemove;
        }


        if (root.getLeft() != null && root.getRight() != null) {
            Node nodeMax = findMax(root.getLeft());
            this.remove(nodeMax);

            nodeMax.setLeft(root.getLeft());
            nodeMax.setRight(root.getRight());
            root = nodeMax;
            return rootRemove;
        }

        return null;
    }

    /**
     * Encontra um nó na árvore.
     *
     * @param node O nó a ser encontrado.
     * @return O nó encontrado.
     * @throws NoInexistenteException Se o nó não existe na árvore.
     * @throws ArvoreVaziaException   Se a árvore estiver vazia.
     */
    @Override
    public Node find(Node node) throws NoInexistenteException, ArvoreVaziaException {

        if(isEmpty()){
            throw new ArvoreVaziaException("arvore vazia");
        }else{
            return findRecursive(node,root);
        }


    }

    /**
     *
     * @param nodeSubArvoreEsquerda representa o inicio da sub arvore esquerda
     * @return retorna o maior numero na subarvore esquerda.
     */
    private Node findMax(Node nodeSubArvoreEsquerda){
        while(nodeSubArvoreEsquerda.getRight() != null){
            nodeSubArvoreEsquerda = nodeSubArvoreEsquerda.getRight();
        }
        return nodeSubArvoreEsquerda;
    }

    /**
     *
     * @param node  O nó a ser encontrado.
     * @param current a posição atual da árvore durante a pesquisa
     * @return retorna o nó encontrado.
     * @throws NoInexistenteException Se o nó não existe na árvore.
     */
    private Node findRecursive(Node node ,Node current) throws NoInexistenteException {
        if (current != null) {
            if (current.compareTo(node) == 0) {
                return current;
            } else if (current.compareTo(node) > 0) {

                return findRecursive(node, current.getLeft());
            } else if (current.compareTo(node) < 0) {
                return findRecursive(node, current.getRight());
            }

        }

        throw new NoInexistenteException("nó não existe");


    }
    @Override
    /**
     * representa uma operação qualquer feita no nó.
     */
    public Node visit(Node node) throws NoInexistenteException {
        System.out.print(node.getValue() +" ");
        return node;
    }

    @Override
    public boolean isEmpty()  {
        return root == null;
    }

    /**
     * utiliza uma fila para armezenar os nós da arvore caso aconteça de
     * algum nó ser nulo e seu irmão não ser a árvore já não é completa
     * pois ela precisa ser cheia até o nivel n - 1.
     * @return retorna se o a ávore é completa ou não
     */
    @Override
    public boolean isComplete() {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean endLevel = false;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                endLevel = true;
            } else {
                if (endLevel) {
                    return false;
                }

                queue.offer(current.getLeft());
                queue.offer(current.getRight());
            }
        }

        return true;

    }

    /**
     *
     * @return retorna a altura(niveis) da árvore.
     */
    @Override
    public int height() {

        return countNivel(root) - 1;
    }

    public void calcBalanceTree(Node current){

        if(current.getLeft() != null) calcBalanceTree(current.getLeft());
        if(current.getRight() != null) calcBalanceTree(current.getRight());


        if(current.getLeft() == null && current.getRight() == null){
            current.setBalance(0);
        }
        else if(current.getLeft() == null && current.getRight() != null){
            current.setBalance(-(countNivel(current.getRight())));
        }
        else if(current.getLeft() != null && current.getRight() == null){
            current.setBalance(countNivel(current.getLeft()));
        }
        else {
            current.setBalance(countNivel(current.getLeft()) - (countNivel(current.getRight())));
        }


    }

    /**
     *
     * @param node posição a ser testada durante a recursão
     * @return retorna a quantidade de níveis existentes na árvore
     */
    private int countNivel(Node node){
        if (node == null) {
            return 0;
        } else {
            int alturaEsquerda = countNivel(node.getLeft());
            int alturaDireita = countNivel(node.getRight());


            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    /**
     * usa o método printTreeRecursive que pecorre o a árvore recusivamente e imprime usando pré ordem
     */
    @Override
    public void printTree() {
        printTreeRecursive(root,"",true);
    }
    private void printTreeRecursive(Node node, String ligador, boolean isLeft){
        this.calcBalanceTree(root);
        if (node != null) {
            System.out.println(ligador + (isLeft ? "├── " : "└── ") + node.getValue() +" " + node.getBalance());
            printTreeRecursive(node.getLeft(), ligador + (isLeft ? "│   " : "    "), true);
            printTreeRecursive(node.getRight(), ligador + (isLeft ? "│   " : "    "), false);
        }
    }

    /**
     * Percorre a árvore em pré-ordem, realizando uma ação em cada nó visitado.
     *
     * @param node O nó a ser visitado.
     * @throws NoInexistenteException Se o nó não existe na árvore.
     */
    @Override
    public void preOrdem(Node node) throws NoInexistenteException {
        if(node!= null) {
            visit(node);
            preOrdem(node.getLeft());
            preOrdem(node.getRight());
        }
    }

    /**
     *
     * @param node  O nó a ser visitado.
     * @throws NoInexistenteException  Se o nó não existe na árvore.
     */
    @Override
    public void iNoderdem(Node node) throws NoInexistenteException {
        if(node != null) {
            iNoderdem(node.getLeft());
            visit(node);
            iNoderdem(node.getRight());
        }
    }
    /**
     * Percorre a árvore em pós-ordem, realizando uma ação em cada nó visitado.
     *
     * @param node O nó a ser visitado.
     * @throws NoInexistenteException Se o nó não existe na árvore.
     */
    @Override
    public void posOrdem(Node node) throws NoInexistenteException {
        if(node != null) {
            posOrdem(node.getLeft());
            posOrdem(node.getRight());
            visit(node);
        }
    }

    public Node getRoot() {
        return root;
    }
}
