package interfaces;

import java.util.Set;

public interface IGeneratorString {
    Set<String> generateStringByGrammar(IGrammar grammar, int lenght);
}
