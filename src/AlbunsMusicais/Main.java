package AlbunsMusicais;

import AlbunsMusicais.Dominio.Album;
import AlbunsMusicais.Dominio.Faixa;
import AlbunsMusicais.Dominio.Genero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

        Genero pop = new Genero();
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
                    casdastrarAlbuns(album);
                    break;
                case 2:
                    //Alterar album
                    break;
                case 3:
                    visualizarAlbum(album);
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
        }while(opcao != 5);
    }

    public static Album casdastrarAlbuns(Album album){
        Scanner input = new Scanner(System.in);

        Genero pop = new Genero();
        pop.setCodigo(1);
        pop.setDescricao("Pop");

        System.out.println("Digite o nome do album: ");
        album.setNome(input.next());
        System.out.println("Digite a data de lançamento: ");
        String data = album.setData(input.next());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date = formatter.parse(data);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        System.out.println("Digite a duração do album: ");
        album.setDuracao(input.next());
        //System.out.println("Digite o genero do album: ");
        //album.setGenero(input.);
        album.setGenero(pop);

        System.out.println("Faixas");
        Faixa faixaAlbum = new Faixa();
        System.out.println("Digite quantas faixas irao existir:");
        int qtnFaixas = input.nextInt();

        for(int i = 0; i < qtnFaixas; i++){
            System.out.println("Digite o nome da faixa " + (i+1) + ":");
            faixaAlbum.setNome(input.next());
            System.out.println("Digite a duração da faixa " + (i+1) + ":");
            faixaAlbum.setDuracao(input.next());
            faixaAlbum.setGenero(pop);

            album.adicionarFaixas(faixaAlbum);
        }

        return album;
    }

    public static Album visualizarAlbum(Album album){
        System.out.println("Nome: " + album.getNome());
        System.out.println("Ano: " + album.getData());
        System.out.println("Duração: " + album.getDuracao());
        System.out.println("Gênero: " + album.getGenero().getDescricao());


        //Retorna as faixas do album
        List<Faixa> faixasThriller = album.retornaFaixasAlbum();
        System.out.println("Faixas:");
        for(Faixa faixa :  faixasThriller) {
            System.out.println("Musica:" + faixa.getNome());
        }
        return album;
    }
}
