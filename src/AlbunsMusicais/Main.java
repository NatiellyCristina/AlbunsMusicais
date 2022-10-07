package AlbunsMusicais;

import AlbunsMusicais.Dominio.Album;
import AlbunsMusicais.Dominio.Faixa;
import AlbunsMusicais.Dominio.Genero;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int opcao = 0;


        //Cadastro de Músicas
        //Cadastro de Compositor
        //Cadastro de Artista
        //Cadastro de Editora

        //testando o commit

        //Cadastro de Gênero

        Genero pop = new Genero();
        pop.setCodigo(1);
        pop.setDescricao("Pop");

        Genero rock = new Genero();
        rock.setCodigo(2);
        rock.setDescricao("Rock");

        do{
            switch(opcao){
                case 1:
                    Album thriller = new Album();
                    System.out.println("Digite o nome do album: ");
                    thriller.setNome(input.next());

                    thriller.setData(new Date(1982, Calendar.NOVEMBER,30));
                    //thriller.setNome("Thriller");
                    thriller.setDuracao("42:16");
                    thriller.setGenero(pop);
                    break;
                case 2:
                    System.out.println("Saindo do sistema");
                default:
                    System.out.println("Opação invalida");
            }
        }while(opcao < 2);





        //Cadastro de Albuns
        Album thriller = new Album();
        System.out.println("Digite o nome do album: ");
        thriller.setNome(input.next());

        thriller.setData(new Date(1982, Calendar.NOVEMBER,30));
        //thriller.setNome("Thriller");
        thriller.setDuracao("42:16");
        thriller.setGenero(pop);


        //Cadastro de Faixa
        Faixa theGirlsIsMine = new Faixa();
        theGirlsIsMine.setNome("The Girls Is Mine");
        theGirlsIsMine.setDuracao("3:42");
        theGirlsIsMine.setAlbum(thriller);
        theGirlsIsMine.setGenero(pop);

        Faixa billieJean = new Faixa();
        billieJean.setNome("Billie Jean");
        billieJean.setAlbum(thriller);
        billieJean.setDuracao("3:42");
        billieJean.setGenero(pop);

        thriller.adicionarFaixas(theGirlsIsMine);
        thriller.adicionarFaixas(billieJean);


        //Apresenta as informações do album cadastrado anteriormente
        System.out.println("Nome: " + thriller.getNome());
        System.out.println("Ano: " + thriller.getData());
        System.out.println("Duração: " + thriller.getDuracao());
        System.out.println("Gênero: " + thriller.getGenero().getDescricao());


        //Retorna as faixas do album
        List<Faixa> faixasThriller = thriller.retornaFaixasAlbum();
        System.out.println("Faixas:");
        for(Faixa faixa :  faixasThriller){
            System.out.println("Musica:" + faixa.getNome());
        }
    }
}
