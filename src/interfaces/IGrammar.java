package interfaces;

import java.util.Map;
import java.util.Set;

public interface IGrammar {
    void setRules(Character variable, String stringResulting);
    public Set<Character> getTerminals();
    public Set<Character> getVariables();
    public Character getInitialVariable();
    public Map<Character, Set<String>> getRules();
}
