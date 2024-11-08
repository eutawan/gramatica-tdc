package domain;

import interfaces.IGrammar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grammar implements IGrammar {
    final Set<Character> terminals;
    final Set<Character> variables;
    Character initialVariable = null;
    Map<Character, Set<String>> rules = new HashMap<>();

    public Grammar(Set<Character> terminals, Set<Character> variables, Character initialVariable) {
        this.terminals = terminals;
        this.variables = variables;

        if (this.variables.contains(initialVariable)) {
            this.initialVariable = initialVariable;
        }
        else {
            System.out.println("Esta variável não existe nesta gramática");
        }
    }

    public void definirRegras(Character variavel, String stringResulting) {
        if (variables.contains(variavel)) {
            if (rules.containsKey(variavel)) {
                rules.get(variavel).add(stringResulting);
            } else {
                rules.put(variavel, new HashSet<>());
                rules.get(variavel).add(stringResulting);
            }

        } else {
            System.out.println("Essa variável não existe");
        }
    }


    @Override
    public void setRules(Character variable, String stringResulting) {

    }

    public Set<Character> getTerminals() {
        return terminals;
    }

    public Set<Character> getVariables() {
        return variables;
    }

    public Character getInitialVariable() {
        return initialVariable;
    }

    public Map<Character, Set<String>> getRules(){
        return rules;
    }

}
