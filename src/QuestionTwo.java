import domain.Grammar;
import interfaces.IGeneratorString;
import interfaces.IGrammar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QuestionTwo {
    public static void main(String[] args) {
        Set<Character> terminals = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        Set<Character> variables = new HashSet<>(Arrays.asList('A', 'B', 'S'));

        IGrammar grammar = new Grammar(terminals, variables, 'S');

        grammar.setRules('S', "aA");
        grammar.setRules('S', "bB");
        grammar.setRules('S', "c");
        grammar.setRules('A', "aA");
        grammar.setRules('A', " ");
        grammar.setRules('B', "bB");
        grammar.setRules('B', " ");

        IGeneratorString verifyStrings = new GeneratorString();

        Set<String> hasThisString = verifyStrings.generateStringByGrammar(grammar, 4);

        for (String string : hasThisString) {
            System.out.printf("String: %s", string);
            System.out.println(" ");
        }
    }
}
