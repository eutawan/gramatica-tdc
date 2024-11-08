package interfaces;

public interface IVerifyString {
    boolean verifyStringIsWithinALanguage(String string, IGrammar grammar);
    boolean deriveString(String targetString, IGrammar grammar, String currentString);
}
