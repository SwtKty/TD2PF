package td2;

import java.util.function.Predicate;

public class Paire <T,U>{
    public T fst;
    public U snd;
    public Paire(T fst, U snd){
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public String toString(){
        return String.format("(%s,%s)",fst.toString(),snd.toString());
    }

    public static void main(String[] args) {

        Predicate<Integer> tropPetite = taille -> taille <100;
        Predicate<Integer> tropGrande = taille -> taille >200;
        Predicate<Integer> tailleIncorrecte = tropPetite.or(tropGrande);
        Predicate<Integer> tailleCorrecte = tailleIncorrecte.negate();

        Predicate<Double> tropLourd = poids -> poids > 150.0;
        Predicate<Double> poidsCorrect = tropLourd.negate();

        System.out.println(tropPetite.test(50));
        System.out.println(tropPetite.test(150));
        System.out.println(tropGrande.test(300));
        System.out.println(tropGrande.test(150));
        System.out.println(tailleIncorrecte.test(50));
        System.out.println(tailleCorrecte.test(150));
        System.out.println(tailleCorrecte.test(0));
        System.out.println(tailleCorrecte.test(300));

    }
}
