package seedu.flashlingo.model.flashcard;

import java.util.Date;

import seedu.flashlingo.model.flashcard.words.OriginalWord;
import seedu.flashlingo.model.flashcard.words.TranslatedWord;

/**
 * Represents each flashcard
 *
 * @author Nathanael M. Tan
 * @version 1.0
 * @since 1.0
 */
public class FlashCard {
    private final OriginalWord originalWord;
    private final TranslatedWord translatedWord;
    private Date whenToReview; // Date the flashcard was needs to be reviewed
    private ProficiencyLevel currentLevel; // How many times successfully remembered
    private final ProficiencyLevel originalLevel; // For undo function

    private boolean toDelete = false;
    /**
     * Constructor for Flashcard
     *
     * @param originalWord   The word in the original language
     * @param translatedWord The word in the language you are learning
     * @param whenToReview   The date of when you need to review this word
     * @param level          The level of familiarity with the word
     */
    public FlashCard(OriginalWord originalWord, TranslatedWord translatedWord, Date whenToReview,
                     ProficiencyLevel level) {
        this.currentLevel = level;
        this.whenToReview = whenToReview;
        this.translatedWord = translatedWord;
        this.originalWord = originalWord;
        this.originalLevel = level;
    }
    public OriginalWord getOriginalWord() {
        return originalWord;
    }

    public TranslatedWord getTranslatedWord() {
        return translatedWord;
    }

    public Date getWhenToReview() {
        return whenToReview;
    }

    public ProficiencyLevel getProficiencyLevel() {
        return currentLevel;
    }

    public boolean isToBeDeleted() {
        return this.toDelete;
    }

    /**
     * Edits the flashCard
     * @param newWord The new word to replace the old word
     * @param newTranslation The new translation to replace old translation
     * @return The new flashcard
     */
    public FlashCard editFlashCard(String newWord, String newTranslation) {
        OriginalWord originalWord = this.originalWord.editWord(newWord);
        TranslatedWord translatedWord = this.translatedWord.editWord(newTranslation);
        if (this.originalWord.equals(originalWord) && this.translatedWord.equals(translatedWord)) {
            return null;
        } else {
            return new FlashCard(originalWord, translatedWord, whenToReview, currentLevel);
        }
    }

    /**
     * Returns true if both flashcards have the same originalWord and translatedWord.
     * This defines a weaker notion of equality between two flashcards.
     */
    public boolean isSameFlashCard(FlashCard otherFlashCard) {
        if (otherFlashCard == this) {
            return true;
        }

        return otherFlashCard != null
            && otherFlashCard.getOriginalWord().equals(getOriginalWord())
            && otherFlashCard.getTranslatedWord().equals(getTranslatedWord());
    }

    /**
     * Returns true if the original word or the translation contains the keyword.
     * @param inputWord The keyword to check for
     * @return True or False depending on whether the keyword is found
     */
    public boolean hasKeyword(String inputWord) {
        return this.originalWord.hasSubpart(inputWord) || this.translatedWord.hasSubpart(inputWord);
    }

    /**
     * Returns true if the review date is before the current date.
     * @return True or False depending on whether the review date is before the current date
     */
    public boolean isOverdue() {
        return this.whenToReview.before(new Date());
    }

    /**
     * Returns true if the original word or the translation is of the language.
     * @param language The language to check for
     * @return True or False depending on whether the language is found
     */
    public boolean isSameLanguage(String language) {
        return this.originalWord.isSameLanguage(language) || this.translatedWord.isSameLanguage(language);
    }

    /**
     * Update the flash card to next level
     */
    public void updateLevel(boolean isSuccess) {
        if (isSuccess) {
            getProficiencyLevel().upgradeLevel();
            updateReviewDate(getProficiencyLevel().calculateNextReviewInterval());
        } else {
            getProficiencyLevel().downgradeLevel();
            updateReviewDate(getProficiencyLevel().calculateNextReviewInterval());
        }
    }

    /**
     * Formats Flashcard for writing to textFile
     *
     * @return Tab separated String formatted for writing
     */
    @Override
    public String toString() {
        String sb = originalWord + " | " + originalWord.getLanguage() + " | " + translatedWord + " | "
                + originalWord.getLanguage() + " | " + whenToReview.toString() + " | " + currentLevel + "\n";
        return sb;
    }

    public void updateReviewDate(long timeInMs) {
        this.whenToReview = new Date(new Date().getTime() + timeInMs);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FlashCard)) {
            return false;
        }

        FlashCard otherFlashCard = (FlashCard) other;
        return originalWord.equals(otherFlashCard.originalWord)
                && translatedWord.equals(otherFlashCard.translatedWord)
                && whenToReview.equals(otherFlashCard.whenToReview)
                && originalLevel.equals(otherFlashCard.originalLevel);
    }
}
