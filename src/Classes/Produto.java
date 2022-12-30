package Classes;
import java.time.LocalDate;

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



   /* public String getProduto_buscado() {
        return produto_buscado;
    }

    public void setProduto_buscado(String produto_buscado) {
        this.produto_buscado = produto_buscado;
    }
        */
    

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

  

   
    

    public Produto(int qtdestoque) {
        Qtdestoque = qtdestoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getName() {
        return null;
    }
   
   

    @Override
    public String toString() {
        return "Produto { " + "nome = " + nome + ", preço = " + preco + "codigo=" +codigoP +"}";
     }

    public double getPreco() {
        return preco;
    }

    public int getQtdestoque() {
        return Qtdestoque;
    }

    public void setQtdestoque(int qtdestoque) {
        Qtdestoque = qtdestoque;
    };



}

