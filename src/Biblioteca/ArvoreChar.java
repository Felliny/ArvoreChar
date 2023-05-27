package Biblioteca;


public class ArvoreChar {
    public class Arvore {
        No raiz;

        public Arvore() {
            raiz= null;
        }

        public void insert(char valor) {
            No no = new No();
            no.dado = valor;
            no.esquerda = null;
            no.direita = null;
            this.insertLeaf(no, this.raiz);
        }

        private void insertLeaf(No no, No raizSubArvore) {
            if (this.raiz == null) {
                this.raiz = no;
            } else if (no.dado < raizSubArvore.dado) {
                if (raizSubArvore.esquerda == null) {
                    raizSubArvore.esquerda = no;
                } else {
                    this.insertLeaf(no, raizSubArvore.esquerda);
                }
            } else if (no.dado >= raizSubArvore.dado) {
                if (raizSubArvore.direita == null) {
                    raizSubArvore.direita = no;
                } else {
                    this.insertLeaf(no, raizSubArvore.direita);
                }
            }

        }

        public void search(char valor) throws Exception {
            try {
                No no = this.nodeSearch(this.raiz, valor);
                int level = this.nodeLevel(this.raiz, valor);
                System.out.println("Valor: " + no.dado + " - NÃ\u00advel: " + level);
            } catch (Exception var4) {
                throw new Exception("Valor nÃ£o encontrado");
            }
        }

        private int nodeLevel(No raizSubArvore, char valor) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Arvore Vazia !!");
            } else if (raizSubArvore.dado > valor) {
                return 1 + this.nodeLevel(raizSubArvore.esquerda, valor);
            } else {
                return raizSubArvore.dado < valor ? 1 + this.nodeLevel(raizSubArvore.direita, valor) : 0;
            }
        }

        private No nodeSearch(No raizSubArvore, char valor) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Arvore Vazia !!");
            } else if (raizSubArvore.dado > valor) {
                return this.nodeSearch(raizSubArvore.esquerda, valor);
            } else {
                return raizSubArvore.dado < valor ? this.nodeSearch(raizSubArvore.direita, valor) : raizSubArvore;
            }
        }

        public void remove(char valor) throws Exception {
            try {
                this.removeChild(this.raiz, valor);
            } catch (Exception var3) {
                throw new Exception("Valor não encontrado");
            }
        }

        private No removeChild(No raizSubArvore, char valor) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Árvore Vazia !!");
            } else {
                if (raizSubArvore.dado > valor) {
                    raizSubArvore.esquerda = this.removeChild(raizSubArvore.esquerda, valor);
                } else if (raizSubArvore.dado < valor) {
                    raizSubArvore.direita = this.removeChild(raizSubArvore.direita, valor);
                } else if (raizSubArvore.esquerda == null && raizSubArvore.direita == null) {
                    raizSubArvore = null;
                } else if (raizSubArvore.esquerda == null) {
                    raizSubArvore = raizSubArvore.direita;
                } else if (raizSubArvore.direita == null) {
                    raizSubArvore = raizSubArvore.esquerda;
                } else {
                    No no;
                    for(no = raizSubArvore.esquerda; no.direita != null; no = no.direita) {
                    }

                    raizSubArvore.dado = no.dado;
                    no.dado = valor;
                    raizSubArvore.esquerda = this.removeChild(raizSubArvore.esquerda, valor);
                }

                return raizSubArvore;
            }
        }

        public void prefixSearch() throws Exception {
            this.prefix(this.raiz);
        }

        private void prefix(No raizSubArvore) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Árvore Vazia !!!");
            } else {
                System.out.print(raizSubArvore.dado + " ");
                if (raizSubArvore.esquerda != null) {
                    this.prefix(raizSubArvore.esquerda);
                }

                if (raizSubArvore.direita != null) {
                    this.prefix(raizSubArvore.direita);
                }

            }
        }

        public void infixSearch() throws Exception {
            this.infix(this.raiz);
        }

        private void infix(No raizSubArvore) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Árvore Vazia !!!");
            } else {
                if (raizSubArvore.esquerda != null) {
                    this.infix(raizSubArvore.esquerda);
                }

                System.out.print(raizSubArvore.dado + " ");
                if (raizSubArvore.direita != null) {
                    this.infix(raizSubArvore.direita);
                }

            }
        }

        public void postfixSearch() throws Exception {
            this.postfix(this.raiz);
        }

        private void postfix(No raizSubArvore) throws Exception {
            if (this.raiz == null) {
                throw new Exception("Árvore Vazia !!!");
            } else {
                if (raizSubArvore.esquerda != null) {
                    this.postfix(raizSubArvore.esquerda);
                }

                if (raizSubArvore.direita != null) {
                    this.postfix(raizSubArvore.direita);
                }

                System.out.print(raizSubArvore.dado + " ");
            }
        }
    }
}
