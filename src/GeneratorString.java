import interfaces.IGeneratorString;
import interfaces.IGrammar;

import java.util.HashSet;
import java.util.Set;

public class GeneratorString implements IGeneratorString {
    @Override
    public Set<String> generateStringByGrammar(IGrammar grammar, int length) {
        Set<String> results = new HashSet<>();
        generateStringsRecursive(grammar, grammar.getInitialVariable().toString(), length, results);
        return results;
    }

    private void generateStringsRecursive(IGrammar grammar, String currentString, int maxLength, Set<String> results) {
        // Se a string atual só tem terminais e está dentro do comprimento desejado, adiciona ao resultado
        if (isOnlyTerminals(currentString, grammar)) {
            results.add(currentString);
            return;
        }

        // Se o comprimento atual for maior que o desejado, interrompe a expansão
        if (currentString.length() > maxLength + 1) {
            return;
        }

        for (int i = 0; i < currentString.length(); i++) {
            char currentChar = currentString.charAt(i);

            if (grammar.getVariables().contains(currentChar)) {
                Set<String> productions = grammar.getRules().get(currentChar);

                if (productions != null) {
                    for (String production : productions) {
                        String newString;
                        if (production.equals(" ")) { // Aplica transição épsilon, eliminando a variável
                            newString = currentString.substring(0, i) + currentString.substring(i + 1);
                        } else {
                            newString = currentString.substring(0, i) + production + currentString.substring(i + 1);
                        }

                        // Chamada recursiva para expandir mais
                        generateStringsRecursive(grammar, newString, maxLength, results);
                    }
                }
            }
        }
    }

    // Função auxiliar para verificar se a string contém apenas terminais
    private boolean isOnlyTerminals(String str, IGrammar grammar) {
        for (char c : str.toCharArray()) {
            if (!grammar.getTerminals().contains(c)) {
                return false;
            }
        }
        return true;
    }

}
