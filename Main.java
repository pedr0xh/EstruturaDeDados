package ArvoreEx;

import java.util.TreeSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        int x = 0;
        String nome;
        String apelido;
        String posicao;
        double altura;

        TreeSet<Atleta> atletaAr = new TreeSet<Atleta>();
        funcionalidades f = new funcionalidades();
        Scanner ler = new Scanner(System.in);

        do {
            f.menu();
            x = ler.nextInt();
            ler.nextLine(); // Consumir a quebra de linha

            switch (x) {

                case 1:
                    System.out.println("Digite o nome:");
                    nome = ler.next().toUpperCase();
                    ler.nextLine();
                    System.out.println("Digite o apelido:");
                    apelido = ler.next().toUpperCase();
                    ler.nextLine();
                    System.out.println("Digite a posição:");
                    posicao = ler.next().toUpperCase();
                    ler.nextLine();
                    System.out.println("Digite a altura:");
                    altura = ler.nextDouble();

                    boolean apelidoEsta = false;
                    for (Atleta atleta : atletaAr) {
                        if (atleta.getApelido().equalsIgnoreCase(apelido)) {
                            apelidoEsta = true;
                            break;
                        }
                    }

                    if (apelidoEsta) {
                        System.out.println("Já existe um atleta com este apelido. Cadastre com um apelido diferente.");
                    } else {
                        atletaAr.add(new Atleta(posicao, apelido, nome, altura));
                        System.out.println("Atleta cadastrado!");
                    }
                    break;

                case 2:
                    if (atletaAr.isEmpty()) {
                        System.out.println("Ninguem cadastrado, por favor cadastre atletas!");
                    } else {
                        System.out.println("Lista de Atletas:");
                        for (Atleta atleta : atletaAr) {
                            System.out.println(atleta);
                        }
                    }
                    break;

                case 3:
                    if (atletaAr.isEmpty()) {
                        System.out.println("Ninguem cadastrado, por favor cadastre atletas!");
                    } else {
                        System.out.println("Lista de Atletas por altura (decrescente):");
                        ArrayList<Atleta> listaAtletas = new ArrayList<>(atletaAr);
                        Collections.sort(listaAtletas, Collections.reverseOrder());
                        for (Atleta atleta : listaAtletas) {
                            System.out.println(atleta);
                        }
                    }
                    break;

                case 4:
                    if (atletaAr.isEmpty()) {
                        System.out.println("Ninguem cadastrado, por favor cadastre atletas!");
                    } else {
                        System.out.println("Digite o apelido do atleta que deseja remover:");
                        apelido = ler.next().toUpperCase();
                        Atleta atletaParaRemover = null;
                        for (Atleta atleta : atletaAr) {
                            if (atleta.getApelido().equalsIgnoreCase(apelido)) {
                                atletaParaRemover = atleta;
                                break;
                            }
                        }
                        if (atletaParaRemover != null) {
                            atletaAr.remove(atletaParaRemover);
                            System.out.println("Atleta removido com sucesso.");
                        } else {
                            System.out.println("Nenhum atleta encontrado com o apelido: " + apelido);
                        }
                    }
                    break;

                case 5:
                    if (atletaAr.isEmpty()) {
                        System.out.println("Ninguem cadastrado, por favor cadastre atletas!");
                    } else {
                        System.out.println("Digite o apelido de quem deseja encontrar:");
                        apelido = ler.next().toUpperCase();
                        boolean encontrado = false;
                        for (Atleta atleta : atletaAr) {
                            if (atleta.getApelido().equalsIgnoreCase(apelido)) {
                                System.out.println(atleta);
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Nenhum atleta encontrado com o apelido: " + apelido);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Estou de saida!");
                    break;

                default:
                    System.out.println("Digite uma opção válida!");
            }

        } while (x != 6);
        ler.close();
    }
}
