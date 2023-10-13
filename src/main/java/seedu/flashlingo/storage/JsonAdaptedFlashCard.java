package seedu.flashlingo.storage;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.flashlingo.commons.exceptions.IllegalValueException;
import seedu.flashlingo.model.flashcard.FlashCard;
import seedu.flashlingo.model.flashcard.OriginalWord;
import seedu.flashlingo.model.flashcard.Translation;


/**
 * Jackson-friendly version of {@link FlashCard}.
 */
public class JsonAdaptedFlashCard {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Flash card's %s field is missing!";

    private final String originalWord;
    private final String translatedWord;
    private final String whenToReview;
    private final int level;
    /**
     * Constructs a {@code JsonAdaptedFlashCard} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedFlashCard(@JsonProperty("originalWord") String originalWord,
                                @JsonProperty("translatedWord") String translatedWord,
                                @JsonProperty("whenToReview") String whenToReview,
                                @JsonProperty("level") int level) {
        this.originalWord = originalWord;
        this.translatedWord = translatedWord;
        this.whenToReview = whenToReview;
        this.level = level;
    }

    /**
     * Converts a given {@code FlashCard} into this class for Jackson use.
     */
    public JsonAdaptedFlashCard(FlashCard source) {
        originalWord = source.getOriginalWord().toString();
        translatedWord = source.getTranslatedWord().toString();
        whenToReview = source.getWhenToReview().toString();
        level = source.getLevel().getLevel();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public FlashCard toModelType() throws IllegalValueException {
        if (originalWord == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, OriginalWord.class.getSimpleName()));
        }
        final String modelOriginalWord = originalWord;

        if (translatedWord == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Translation.class.getSimpleName()));
        }
        final String modelTranslatedWord = translatedWord;

        if (whenToReview == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

        LocalDateTime localDateTime = LocalDateTime.parse(whenToReview, formatter);

        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Singapore"));
        Date modelWhenToReview = Date.from(zonedDateTime.toInstant());

        final int modelLevel = level;

        return new FlashCard(new OriginalWord(modelOriginalWord), new Translation(modelTranslatedWord), modelWhenToReview, modelLevel);
    }
}
