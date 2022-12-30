import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Classes.ComparadorData;
import Classes.ComparadorPreco;
import Classes.Produto;
import Classes.Venda;

public class AppProdutos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao; 
        Scanner in = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Listar produtos cadastrados");
            System.out.println("4 - Vendas por periodo");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

          if (opcao == 1) {
                if (opcao == 1) {
                  
                    Produto p = new Produto();
                    System.out.println("Digite o codigo do produto: ");
                    int nCodigo = in.nextInt();

                   try {
                       p.setCodigoP(nCodigo);
                   } catch (InputMismatchException e) {
                    System.out.println("O código do produto devera ser apenas numeros!!!  ");
                   }
     //1 Primeira verificação: Verificar se existe um produto com o codigo igual ao fornecido pelo usuario(Fazer uma busca). 
                   
                    boolean produto_existente = false;

                   for (Produto produto : produtos) 
                    if(p.getCodigoP() == produto.getCodigoP()){
                    System.out.println("O produto já está cadastrado...");
                    produto_existente=true;
                    }
                    if (produto_existente){
                    voltarMenu(in);
                    continue;
                    }


                      //2 Segunda verificação: Verificar se o codigo digitado é inteiro (Tratar a excessão com try/cat) - ok 

//-----------------------------------------------------------------------------------------------------------------------------------------
         
                   System.out.println("Nome do produto: ");
                    p.setNome(in.nextLine());
                    in.nextLine();

                    


                    System.out.println("Quantidade em estoque: ");
                    
                    try {
                    p.setQtdestoque(in.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("A quantidade devera deverá ser apenas numeros!!! ");
                    }

                    for (Produto produto : produtos){
                    if (produto.getQtdestoque() <= 0 ) {
                        System.out.println ("Cadastre mais que 0 produto(s) para prosseguir.");
  
                    }
                }
                    
                    
                    // 1 Primeira verificação: garantir que a quantidade seja maior ou igual a 0 - ok
                    

                    // 2 Segunda verificação: igual a verificação de cima - ok 


                    System.out.println("Preço do produto: ");
                    
                    try{
                    p.setPreco(in.nextInt());
                    }catch (InputMismatchException e) {
                        System.out.println("O preço do produto deverá ser apenas numeros!!!");
                    }

                    for (Produto produto : produtos){
                        
                        if ( produto.getpreco() <= 0 ) 
                            System.out.println ("O preço devera ser superior a 0 para ser válido!!");
                        }
                    // 1 Primeira verificação: garantir que a preço seja maior a 0 - ok 


                    // 2 Segunda verificação: igual a verificação de cima - ok


                    produtos.add(p);
                    voltarMenu(in);
                    continue;
                    }

                
              
                } else if (opcao == 2) {

                    if (produtos.isEmpty()){
                        System.out.println("Não existem produtos cadastrados no sistema. ");
                    } else {
    
                    System.out.println("Digite o codigo do produto a ser buscado: ");
                    int codigo = in.nextInt();
    
                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getCodigoP() == codigo) {
                            System.out.printf("\n---------------\n Nome: %\nProduto: %s \nCodigo: %d \nValor: %f \nQuantidade no estoque: %d \n---------------", produtos.get(i).getNome(), produtos.get(i).getCodigoP(), produtos.get(i).getPreco(), produtos.get(i).getQtdestoque());
                        } 
                    }
                }
                    in.nextLine();
    
                    voltarMenu(in);
            
            } else if (opcao == 3) {

                Double maior = Double.MIN_VALUE, medio = 0.0, menor = Double.MAX_VALUE;

                for (int i = 0; i < produtos.size(); i++) {
                
                    if (produtos.get(i).getPreco() > maior) {
                        maior = produtos.get(i).getPreco();
                    }
                    
                    if (produtos.get(i).getPreco() < menor) {
                        menor = produtos.get(i).getPreco();
                    }

                    medio = produtos.stream().collect(Collectors.averagingDouble(Produto::getPreco));

                }
                
                ComparadorPreco comparador = new ComparadorPreco(maior, medio, menor);

                if (produtos.isEmpty()){
                    System.out.println("Não existem produtos cadastrados no sistema.");
                } else {


                System.out.println("\nProdutos:");
                for (Produto p: produtos){
                    System.out.printf("\n---------------\nProduto: %s \nCodigo: %d \nValor unitario: %f \nQuantidade no estoque: %d\n--------------- ", p.getNome(), p.getCodigoP(), p.getPreco(), p.getQtdestoque()); 
                    
                }

                System.out.print(comparador.toString());
            }
                voltarMenu(in);
                
            }  else if (opcao == 4) {
                    if (vendas.isEmpty()) {
                        System.out.println("\nNão existe nenhum produto cadastrado!");
                    } else {
                    
                        Double maior = Double.MIN_VALUE, medio = 0.0, menor = Double.MAX_VALUE;
                        for (int i = 0; i < vendas.size(); i++) {
                    
                            if (vendas.get(i).getValor() > maior) {
                                maior = vendas.get(i).getValor();
                            }
                            
                            if (vendas.get(i).getValor() < menor) {
                                menor = vendas.get(i).getValor();
                            }
        
                            medio = vendas.stream().collect(Collectors.averagingDouble(Venda::getValor));
        
                        }
                        
                        ComparadorPreco comparador = new ComparadorPreco(maior, medio, menor);
    
                        vendas.sort(new ComparadorData());
                        String dia = vendas.get(0).getData();
                        String mes = vendas.get(vendas.size() -1).getData();
                        System.out.printf("\nVendas || %s - %s:" , dia, mes);
                        
                        for (Venda p : vendas){
                            for (int i=0; i < produtos.size(); i++) {
                                System.out.printf("\n--------------------\nData: %s\nProduto: %s - %d\nQuantidade obtida no estoque: %d\nValor unitario: %s\nValor Total: %s\n-------------------- ", p.getData(), produtos.get(i).getNome(), produtos.get(i).getCodigoP(),produtos.get(i).getQtdestoque(), produtos.get(i).getPreco(), p.getValorTotal());
                            }
                        }
                                System.out.print(comparador.toString());
                    }
                        
                             voltarMenu(in);   


            
            } else if (opcao == 5){
                
                Venda v = new Venda();

                System.out.println ("Código do produto que está sendo vendido: ");
                int codigo = in.nextInt();
                in.nextLine();
                Produto produto_buscado = busca(produtos, codigo);
                if (produto_buscado != null){
                    System.out.println("Produto encontrado");
                    v.setProduto_vendido(produto_buscado);
                }else {
                    voltarMenu(in);
                        continue;
                     }
                
                System.out.println("Digite data: ");

                String datav = in.nextLine();
                v.setDataVenda(LocalDate.parse(datav));

                System.out.println("Digite o codigo do produto: ");
                int codigop = in.nextInt();
                in.nextLine();

                System.out.println("Quantidade desejada: ");
                int quantidadev = in.nextInt();
                in.nextLine();

                if (quantidadev<=0){
                    System.out.println("Quantidade invalida!");
                    System.out.println("Venda intemrrompida");
                    voltarMenu(in);
                    continue;
                }
                List<Produto> p2 = produtos.stream().
                filter(p -> p.getCodigoP()==codigop).
                collect(Collectors.toList());

                if(quantidadev>p2.get(0).getQtdestoque()){
                    System.out.println("Quantidade invalida!");
                    System.out.println("Venda intemrrompida");
                    voltarMenu(in);
                    continue;
                    
                }
               v.setProduto_vendido(p2.get(0));
                v.setQtdvendida(quantidadev);
                vendas.add(v);
                
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
                }
    
    
private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
    private static Produto busca (List<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (codigo == produto.getCodigoP());{
                return produto;
        }
    }

        return null; 
}

}


       
        