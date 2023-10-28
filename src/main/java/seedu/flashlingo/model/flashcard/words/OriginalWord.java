package seedu.flashlingo.model.flashcard.words;

import static java.util.Objects.requireNonNull;

/**
 * Represents the original word
 *
 * @author Nathanael M. Tan, Taanish Bhardwaj
 * @version 1.2
 * @since 1.2
 */
public class OriginalWord extends Word {
    /**
     * Constructs a new Original Word
     * @param word String to be encapsulated by this Original Word
     * @param language Language of the encapsulated word
     */
    public OriginalWord(String word, String language) {
        super(word, language);
    }
    /**
     * Evaluates whether this word is an original word
     * @return True or False depending on whether this is an original word
     */
    @Override
    public boolean isOriginalWord() {
        return true;
    }
    /**
     * Evaluates whether this word is a translated word
     * @return True or False depending on whether this is a translated word
     */
    @Override
    public boolean isTranslatedWord() {
        return false;
    }

    /**
     * Edits this word
     * @param newWord The new word to replace this word
     * @return The new word
     */
    @Override
    public OriginalWord editWord(String newWord) {
        return new OriginalWord(newWord, getLanguage());
    }

    /**
     * Checks whether this Original Word is equal to the passed object
     * @param other Passed object to check equality against
     * @return True or False depending on whether this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        return (other instanceof OriginalWord) && super.equals(other);
    }
}
