package seedu.flashlingo.model.flashcard.words;

/**
 * Represents the translated word
 *
 * @author Nathanael M. Tan, Taanish Bhardwaj
 * @version 1.2
 * @since 1.2
 */
public class TranslatedWord extends Word {
    /**
     * Constructs a new Translated Word
     * @param word String to be encapsulated by this Translated Word
     * @param language Language of the encapsulated word
     */
    public TranslatedWord(String word, String language) {
        super(word, language);
    }
    /**
     * Evaluates whether this word is an original word
     * @return True or False depending on whether this is an original word
     */
    @Override
    public boolean isOriginalWord() {
        return false;
    }
    /**
     * Evaluates whether this word is a translated word
     * @return True or False depending on whether this is a translated word
     */
    @Override
    public boolean isTranslatedWord() {
        return true;
    }

    /**
     * Edits this word
     * @param newWord The new word to replace this word
     * @return The new word
     */
    @Override
    public TranslatedWord editWord(String newWord, String newLanguage) {
        return new TranslatedWord(
                newWord.isEmpty() ? getWord() : newWord,
                newLanguage.isEmpty() ? getLanguage() : newLanguage);
    }

    /**
     * Checks whether this Translated Word is equal to the passed object
     * @param other Passed object to check equality against
     * @return True or False depending on whether this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TranslatedWord)) {
            return false;
        }
        TranslatedWord otherTranslatedWord = (TranslatedWord) other;
        return getWord().equalsIgnoreCase(otherTranslatedWord.getWord())
                && getLanguage().equalsIgnoreCase(otherTranslatedWord.getLanguage());
    }
}
