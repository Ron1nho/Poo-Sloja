import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppProdutos {
    public static void main(String[] args, Produto Q) throws InterruptedException, IOException {
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

                
              voltarMenu(in);
            }else if (opcao == 2) {
                
                if (produtos.size() == 0){
                    System.out.println("Não existem produtos a serem buscados.");
                    voltarMenu(in);
                    continue;
                }

                System.out.println("Digite o codigo do produto desejado: ");
                int escolha = in.nextInt();
                in.nextLine();

                for (Produto produto : produtos) {
                    if(escolha == produto.getCodigoP()){
                        System.out.println("Produto encontrado - " + produto);
                       // System.out.println(produto);
                        voltarMenu(in);
                    }
                }
                //Retornar "Nenhum produto encontrado" caso a escolha seja nenhum codigo dos produtos cadastrados - ok
               
               
               
                voltarMenu(in);

            
            } else if (opcao == 3) {
                //Se a lista estiver vazia não há o que procurar.

               /*  if (produtos.size() == 0) {
                    System.out.println("Não existem produtos a serem listados.");
                    voltarMenu(in);
                    continue;
                }
                
 
                //Ordenar pelo nome: usando o metodo sort separado ou na stream

                   private static void testSortOne(List<Produto> produtos) {		
                    //Usando classe anonima
                    Collections.sort(produtos, new Comparator<Produto>() {		
                          public int compare(Produto p1, Produto p2) {
                                return p1.getName().compareTo(p2.getName());
                            
                          }
              });
            }
        
        
                        
          
          for (Produto produto : produtos) {		
            System.out.println(produto.toString());
          }*/
          
        
        

     /* private static void testSortTwo(List<Produto> produtos) {
        produtos.stream()
               .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
               .forEach(p -> System.out.println(p)); */

  //Adequar a listagem ao anunciado da prova(Pode ser da quantidade em estoque ou do preço do produto)
        
            } else if (opcao == 4) {
                
            }
             else if (opcao == 5){
                //Primeira verificar se existem produtos na lista de produtos
                //Pedir codigo do produto ao usuario
                //Segunda verificar se o codigo fornecido pelo usuario está contido na lista de produtos
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

                
                //Pedir a quantidade a ser vendida
                //Verificar se a quantidade é maior que 0
                //verificar se a quantidade a ser vendida é menor que a quantidade em estoque do produto
                //Fazer a baixa do estoque  
                
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

       
        