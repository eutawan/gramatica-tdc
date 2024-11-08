import domain.Grammar;
import interfaces.IGrammar;
import interfaces.IVerifyString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QuestionThree {
    public static void main(String[] args) {
        Set<Character> terminals = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        Set<Character> variables = new HashSet<>(Arrays.asList('A', 'B', 'S', 'C'));

        IGrammar grammar = new Grammar(terminals, variables, 'S');

        grammar.setRules('S', "aA");
        grammar.setRules('S', "bB");
        grammar.setRules('S', "cC");
        grammar.setRules('A', "aA");
        grammar.setRules('A', " ");
        grammar.setRules('B', "bB");
        grammar.setRules('B', " ");
        grammar.setRules('C', "cC");
        grammar.setRules('C', " ");

        IVerifyString verifyStrings = new VerifyString();

        String stringToVerify = "cccc";

        boolean hasThisString = verifyStrings.deriveString(stringToVerify, grammar, grammar.getInitialVariable().toString());

        if (hasThisString) {
            System.out.printf("The String %s is a string " +
                    "from the language accept by the grammar " +
                    "of the first question%n", stringToVerify);
        } else {
            System.out.printf("The String %s don't is a string " +
                    "from the language accept by the grammar " +
                    "of the first question%n", stringToVerify);
        }
    }
}
