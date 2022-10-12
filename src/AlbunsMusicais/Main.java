package AlbunsMusicais;

import AlbunsMusicais.Dominio.Album;
import AlbunsMusicais.Dominio.Genero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao = 0;

        Album album = new Album();



        //Cadastro de Músicas
        //Cadastro de Compositor
        //Cadastro de Artista
        //Cadastro de Editora

        //Cadastro de Gênero

        /*Genero pop = new Genero();
        pop.setCodigo(1);
        pop.setDescricao("Pop");

        Genero rock = new Genero();
        rock.setCodigo(2);
        rock.setDescricao("Rock");


        do{
            System.out.println("|-------------Albuns Musicais---------------|");
            System.out.println("| 1 - Cadastrar album                       |");
            System.out.println("| 2 - Alterar album                         |");
            System.out.println("| 3 - Visualizar album                      |");
            System.out.println("| 4 - Excluir album                         |");
            System.out.println("| 5 - Sair                                  |");
            System.out.println("|-------------------------------------------|");

            System.out.println("Digite uma das opções acima");
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    album.cadastrarAlbum(album);
                    break;
                case 2:
                    //Alterar album
                    break;
                case 3:
                    album.visualizarAlbum(album);
                    break;
                case 4:
                    //Excluir album
                    break;
                case 5:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opação invalida");
                    break;
            }
        }while(opcao != 5);*/
    }
}
