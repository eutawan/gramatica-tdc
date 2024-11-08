import interfaces.IGrammar;
import interfaces.IVerifyString;

import java.util.Set;

public class VerifyString implements IVerifyString {
    public boolean verifyStringIsWithinALanguage(String string, IGrammar grammar) {

        for (char x : string.toCharArray()) {
            if (!grammar.getTerminals().contains(x)) {
                System.out.println("Essa string não existe nessa gramática");
                return false;
            }
        }

        return deriveString(string, grammar, grammar.getInitialVariable().toString());
    }

    public boolean deriveString(String targetString, IGrammar grammar, String currentString) {

        if (currentString.equals(targetString)) {
            return true;
        }

        if (currentString.length() > targetString.length() + grammar.getVariables().size()) {
            return false;
        }

        for (int i = 0; i < currentString.length(); i++) {
            char currentChar = currentString.charAt(i);

            if (grammar.getVariables().contains(currentChar)) {
                Set<String> productions = grammar.getRules().get(currentChar);

                if (productions != null) {
                    for (String production : productions) {
                        String newString;
                        if (production.equals(" ")) {  // Verifica se a produção é epsilon.
                            newString = currentString.substring(0, i) + currentString.substring(i + 1);
                        } else {
                            newString = currentString.substring(0, i) + production + currentString.substring(i + 1);
                        }

                        if (deriveString(targetString, grammar, newString)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
