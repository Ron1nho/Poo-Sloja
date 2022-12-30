public class Produto {
    
    private double preco;
    private int codigoP, Qtdestoque;
    private String nome;


    
    
    // Construtores
    
    public Produto(double preco, int codigoP, int qtdestoque, String nome, int Integer) {
       
    if (codigoP != Integer) {
        throw new NumberFormatException ("O código do produto deverá ser um numero inteiro.");
       }
       
        this.preco = preco;
        this.codigoP = codigoP;
        Qtdestoque = qtdestoque;
        this.nome = nome;
    }
    
    //Getters & setters
    
    public Produto() {
    }



    public double getpreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getCodigoP() {
        return codigoP;
    }
    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }

    public int getQtdestoque() {
        return Qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        Qtdestoque = qtdestoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
   

   



}

