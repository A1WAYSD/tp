package flashlingo.logic.parser;

import flashlingo.logic.parser.exceptions.ParseException;
import seedu.flashlingo.commons.core.index.Index;
import seedu.flashlingo.logic.commands.EditCommand;
import seedu.flashlingo.model.flashcard.FlashCard;
import seedu.flashlingo.model.flashcard.ProficiencyLevel;
import seedu.flashlingo.model.flashcard.words.OriginalWord;
import seedu.flashlingo.model.flashcard.words.TranslatedWord;

import java.util.Date;

import static java.util.Objects.requireNonNull;
import static seedu.flashlingo.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.flashlingo.logic.parser.CliSyntax.*;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_ORIGINAL_WORD, PREFIX_ORIGINAL_WORD_LANGUAGE,
                    PREFIX_TRANSLATED_WORD, PREFIX_TRANSLATED_WORD_LANGUAGE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_ORIGINAL_WORD, PREFIX_ORIGINAL_WORD_LANGUAGE,
                PREFIX_TRANSLATED_WORD, PREFIX_TRANSLATED_WORD_LANGUAGE);

        OriginalWord word = new OriginalWord(argMultimap.getValue(PREFIX_ORIGINAL_WORD).get(),
                argMultimap.getValue(PREFIX_ORIGINAL_WORD_LANGUAGE).get());
        TranslatedWord translation = new TranslatedWord(argMultimap.getValue(PREFIX_TRANSLATED_WORD).get(),
                argMultimap.getValue(PREFIX_TRANSLATED_WORD_LANGUAGE).get());
        return new EditCommand(index, new FlashCard(word, translation, new Date(), new ProficiencyLevel(1)));
    }
}
