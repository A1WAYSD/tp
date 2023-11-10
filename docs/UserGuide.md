---
layout: page
title: User Guide
---

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Introduction
Flashlingo is a versatile desktop application centered around learning words through flashcards. It is optimized for use via a Command Line Interface (CLI),
while also providing the advantages of a Graphical User Interface (GUI). Tailored with a focus on beginner language
learners, Flashlingo specializes in expanding vocabulary.

The application leverages the scientifically-proven principle of the [**Forgetting Curve**](https://en.wikipedia.org/wiki/Forgetting_curve).
By incorporating the forgetting curve concept, Flashlingo schedules review sessions, ensuring words are revisited at
optimal intervals to enhance long-term memory retention. This method assists users in effectively retaining and expanding their vocabulary over time.

--------------------------------------------------------------------------------------------------------------------

## Application Features
Flashlingo predominantly consists of two main features: **Managing flash cards** and **Reviewing flash cards**
- **Managing flash cards**
  - Users are given the ability to add, delete and edit flash cards. And each flashcard is assigned with a `level`, which
  indicates the proficiency of the user with the word. The level of the flashcard will be updated after each review session.
* **Reviewing flash cards**
   - In each review session, words that require reviewing will be presented to users one by one. For each word, users can indicate whether
     - they have memorized the word
     <br>
     This will advance the word into the next `level`, meaning less frequent review for the word in the near future.
     - they have forgotten the word
     <br>
        This will decrease the `level` by 1, meaning more frequent review for the word in the near future.

**:information_source: Notes about the command format:**<br>

* The higher the `Level` is, the higher the proficiency of the user with the word is. The maximum level is 5, and it will be displayed as `word mastered`.

* Words which are indicated as `word mastered` will not appear in review session.

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `flashlingo.jar` from [here](https://github.com/AY2324S1-CS2103T-T11-4/tp/releases) (Not finished yet).

3. Copy the file to the folder you want to use as the _home folder_ for your Flashlingo.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar flashlingo.jar` command to run the application.
   Below shows the steps to perform such a task
    1. Open up the terminal.
    * For mac users, press `Command + Space` to open Spotlight search, type `Terminal`, and press `Enter`.
      ![img.png](images/Terminal.png)
    * For windows users, press `Windows + R` keys simultaneously, type `cmd` and press `Enter`.
    2. Navigate to the folder containing the jar file. In this example, it is in the Downloads folder.
       <br>
       ``cd Downloads```
    3. Simply type in `java -jar flashlingo.jar` to get started!

       A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
       ![Ui](images/MainUi.png)

### Using the application

1. Type the command in the command box and press Enter to execute it.
   <img width="728" alt="Screenshot 2023-10-27 at 3 14 07 PM 1" src="https://github.com/itsNatTan/tp/assets/64185574/a4a8dbd2-94ff-417d-84a4-175bf85ff100">

2. The image below shows the result of typing in a command. A log message will be displayed below the command box to give information about the outcome of the command.
   <img width="729" alt="Screenshot 2023-10-27 at 3 11 50 PM" src="https://github.com/itsNatTan/tp/assets/64185574/48b74efc-2a39-48d5-b0aa-70f165484c5e">

3. Refer to the [Commands](#commands) below for details of each command.


--------------------------------------------------------------------------------------------------------------------

## Commands

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

| Notation         | Description                                                   | Example Command                                                     | Example Usage                    |
|------------------|---------------------------------------------------------------|---------------------------------------------------------------------|----------------------------------|
| `<PARAMETER>`    | Parameter to be supplied by the user                          | `delete <INDEX>`                                                    | `delete 1`                       |
| `[<OPTIONAL>]`   | Indicates an optional parameter                               | `add w/<WORD> t/<TRANSLATION> [wl/WORD_LANG] [tl/TRANSLATION_LANG]` | `add w/Hello t/你好`               |
 | `<PARAMETER...>` | Commands that can take in multiple comma seperated parameters | `find <KEYWORD...>`                                                 | `find hello, bye`                |
| `...`            | Parameter that will not be used                               | `help ...`                                                          | `help 123` is the same as `help` |
</div>


| :warning: Commands Supported Only Outside Review Session                                                                             | :warning: Commands Supported Only Inside Review Session |
|--------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| `add` <br> `delete` <br> `edit` <br> `find` <br> `start` <br> `list` <br> `load` <br> `language` <br> `review` <br> `stats`          | `yes` <br> `no` <br> `end`                              |
| *Error Message:* `Sorry, currently you are in a review session. Your command is not supported. Please end the review session first.` | *Error Message:* `You are not in a review session.`     |


### Adding a flash card: `add`
:information_source: Notes about adding words:
* In order to give users full customizability, there's no any restriction on input, as long as it is not empty.

Adds a word to the flash card with its translation.
* Creates a wild flash card.
* Works to add a word with its translation in their respective languages.
* The already saved translation can be overridden with a new translation in a different language.

Format: `add w/<WORD> t/<TRANSLATION> [wl/<WORD_LANGUAGE>] [tl/<TRANSLATION_LANGUAGE>]`
> The default language for both word and translation are blank (`""`)

Examples:
* `add w/雪 t/snow` saves the translation of **雪** as **snow**
* `add w/雪 wl/Chinese t/snow tl/English` saves the translation of the **Chinese** word **雪** as an **English** word **snow**

| Words without language  | ![img.png](images/WordWithoutLanguage.png) |
|:-----------------------:|:------------------------------------------:|
| **Words with language** |  ![img.png](images/WordWithLanguage.png)   |

**Note**
* Users are not allowed to add two **exact** same flash cards
    * Same word **and** word language
    * Same translation **and** translation language
* Users can add two flash cards with the **same word and translation BUT in different language**<br>
  The following three commands can exist in the same list:
    * `add w/雪 t/snow`
    * `add w/雪 t/snow wl/Chinese tl/English`
    * `add w/雪 t/snow wl/Japanese tl/English`
> The error message:<br>
> This flash card already exists


### Deleting a flash card : `delete`

Deletes a words and its related information
* Deletes a flash card.

Format: `delete <INDEX>`

Examples:
* `delete 2` deletes the word and its translation at index 2

Output:

|  Before delete   | ![img.png](images/BeforeDelete.png) |
|:----------------:|:-----------------------------------:|
| **After delete** | ![img.png](images/AfterDelete.png)  |

### Editing a flash card : `edit`

Edits the word and its translation at the given index.
* Edits a wild flash card.

Format: `edit <INDEX> [w/<WORD>] [t/<TRANSLATION>] [wl/<WORD_LANGUAGE>] [tl/<TRANSLATION_LANGUAGE>]`

Examples:
* `edit 1 w/こんにちわ t/Hello` edits the translation at index 1

Output:

|  Before edit   |![img.png](images/BeforeEdit.png)  |
|:--------------:|:---------------------------------:|
| **After edit** | ![img.png](images/AfterEdit.png)  |

**Note**
* Users are not allowed to edit a flash card to an existing flash card
* `<INDEX>` is the index of each flash card in the `list`
* Users change at **LEAST** one certain parameter by using certain prefix
    * Word: `w/WORD`
    * Word Language: `wl/WORD_LANGUAGE`
    * Translation: `t/TRANSLATION`
    * Translation Language: `tl/TRANSLATION_LANGUAGE`
> The error message: <br>
> `This flash card already exists in Flashlingo`

### Finding a flash card : `find`

Finds words whose original word or translation contains the given keyword.
* Finds a flash card.
* The search is insensitive. e.g `look` will match `Look`

Format: `find <KEYWORDS...>`

Examples:
* `find look` returns the flash card list and its translation that contains the keyword `look`
* `find look, hello, goodbye` returns the flash card list that has all flash cards that contain `look`, `hello` and `goodbye`

### Listing all flash cards : `list`

Shows the list of flash cards with both the original word and the corresponding translation.
* Lists all the flash cards saved
  
Format: `list ...`
> All the saved flash cards, regardless of the review date, are listed.

Output:

| Outside the review session | ![img.png](images/ListSuccess.png) |
|:-----------------------:|:------------------------------------------:|
| **During the review session** | ![img.png](images/ListDuringReview.png) |


**Note:**
* `list` command cannot be used during a review session
   * To ensure retention, only the flash cards - with the words to be reviewed - can be seen during the review session.
   * As soon as the review session ends, all the flash cards can be listed once again
> The error message:<br>
> Sorry, currently you are in a review session. Your command is not supported.<br>
> Please end the review session first.

### Getting list for revision : `review`

Displays the flash cards of all the words to be reviewed that day
* The review command will present flash cards selected by Flash Lingo based on your level, utilizing the Leitner system.
* If you wish to view all your saved flash cards without the Leitner system's selection criteria, please use the list command.

Format: `review ...`

Output:
![img.png](images/ReviewSuccess.png)

**Note:**
* The error message `0 flash card(s) listed!` occurs when:
    * There are no flash cards scheduled for today's review.
    * You have finished reviewing all flash cards for the day.

###  Starts review session : `start`

To start a review session, user simply needs to type in `start` command.

Format: `start ...`

Output: `Review Session has been started.`

**Note**
* If there are no words to review, users will not be able to start review session. `You have no more words to review!`
  will be displayed.


### Ending the current review session : `end`

Ends the current flash card session and returns to the main menu.

Format: `end ...`

Output: `Review Session has ended.`

### Revealing the other side of the flashcard: `reveal`

To show the translation of the flash card in

Format: `reveal [<INDEX>]`

Output : `Flashcard has been revealed!`

Examples:![img.png](images/Reveal.png)

**Note**
* When <INDEX> is omitted, the default value is 1.
* Pressing `reveal` or `hide` button will have the same effect.

### Indicating user has memorized the word : `yes`

Marks the word as memorized and advances the word into the next retention stage. If there are still remaining words to review,
they will be automatically shown in the section below. Otherwise, review session will be closed by default.

Format: `yes ...`

Output: ![img.png](images/Yes.png)
or
![img.png](images/Yes2.png)
if there's no word left in the review session.

**Note**
* Pressing `yes` button will have the same effect.

###  Indicating user has forgotten the word : `no`

Marks the word as not grasped and leaves it in its current retention stage. If there are still remaining words to review,
they will be automatically shown in the section below. Otherwise, review session will be closed by default.

Format: `no ...`

Output: ![img.png](images/No.png)
or
![img.png](images/No2.png)
if there's no word left in the review session.
**Note**
* Pressing `no` button will have the same effect.

### Show learning statistics : `stats`

To help track user progress and inspire continued learning, this command offers detailed statistics:
* Total Flash Cards: Displays the total count of flash cards you have saved.
* Remembered Words: Shows the number of terms you have successfully retained in this session.
* Success Rate: Presents a percentage representing your learning success for this session, motivating you to keep improving.

Format: `stats ...`

Example:
* `stats` would give the following output

Output:

![img.png](images/Stats.png)

**Note:**
* The `stats` command is operational exclusively outside active review sessions.
* The success rate is calculated solely on the basis of the current session.
* If attempted inside a review session, the system will respond with the following error message:
> Sorry, currently you are in a review session. Your command is not supported.<br>
> Please end the review session first.

### Filtering list with specified language : `language`

Displays a list where each word is from specified language.

Format: `language <SPECIFIED_LANGUAGE>`

<div id="load">

### Loading list of words: `load`
Loads an Excel file of words into the app. The words will be added to the current list of flash cards and included in the
review session automatically.
</div>

Format: `load <FILE_NAME>`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the file input:**<br>
* **File format:** The file must be an Excel Workbook with the `.xlsx` extension.
* **File location:** The file must be located in the **same folder** as the `flashlingo.jar` file.
* **File content:** The app would only read the **first sheet** of the workbook. The sheet must contain only the following
  **two** columns:
    1. First column - The original words
    2. Second column - The translation of the words
* **Resources:** A sample file can be found [here](SampleData.xlsx).
</div>

Output:
* You have successfully loaded file: `<FILE_NAME>`: Successful loading.
* File not found or accessible:
> ⚠️ Make sure the file is in the correct directory with read permission.
* File cannot be read due to invalid content or format:
>⚠️ Make sure the file contains only two columns with the valid words/translations.
* `FLASH_CARD` flash card already exists!:
>⚠️ Modify the duplicated word/translation in the file.

### Switching color theme : `switch`
Switches between light and dark appearance of UI dashboard.
* The theme will be saved and loaded when Flashlingo is restarted.
* Default color theme is the **light theme**.

Format: `switch ...`

Output:

|  light theme   | ![img.png](images/LightTheme.png) |
|:--------------:|:---------------------------------:|
| **dark theme** | ![img.png](images/DarkTheme.png)  |

### Viewing help : `help`

Opens a browser with the help page (User Guide). Pressing the `Help` button and then clicking `Help F1` will achieve the same effect.

Format: `help ...`

### Exiting the program : `exit`

Safely terminates the Flashlingo application and closes the graphical user interface (GUI).

Format: `exit ...`

Example:
* Input `exit` to end your session and close the application


### Saving the data

Flashlingo data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Flashlingo data are saved automatically as a JSON file `[JAR file location]/data/flashlingo.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Flashlingo will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

--------------------------------------------------------------------------------------------------------------------

## Planned Enhancement

### Adding language tags in UI

The UI will display translation language tag of the flash cards to users. This will allow users to distinguish different languages of the translations and help them
recall the translation and verify the correctness of the translation by further entering the `reveal` command.

UI Prototype:
![img.png](images/LanguageTag.png)


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Flashlingo home folder.

**Q**: How can I import my data to the app?<br>
**A**: Save your words and translations in the format specified above in an Excel file. Move the file to the same folder with `flashlingo.jar`.
Then, use the `load` command to import the data.

**Q**: What may be the reasons why my data cannot be loaded into the app?<br>
**A**: 
* First, check your file name by opening the located folder. The file name should be directly displayed. Also, you can right-click the file to view the file name in its detailed info.
* If Flashlingo still cannot read the file, try inputting file name with and without the extension `.xlsx` in the `load` command. This may solve potential issues with file name loading within different systems.
* Secondly, ensure the content in your file is correctly formatted and valid. All rules can be found [here](#load).

**Q**: After I reviewed a flash card, I edited details of the card by the `edit` command. Will I see these changes immediately reflected in the review session?<br>
**A**:
* Unfortunately, no. The card is updated synchronously in the card list and the review session of Flashlingo. However, since the user has already reviewed the same card on the day, the card will not be included in the review session again.
* To see the edits made, User can use the `list` or `find` command to locate the specific card in the card list. The changes will also be reflected in the next review session for that flash card.

**Q**: If the displayed level of a flash card is "Word Mastered", what can I do if I want to review the card again?<br>
**A**:
* Currently, there's no way for user to manually change the level of a flash card. Flashlingo is designed to automatically remove words that learners are familiar with from the review session.
* However, if user must review the card, he/she can first use the `delete` command to delete the card and then use the `add` command to re-add the same card. The new card will be reset to level 1 and added in the review session.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                  | Format, Examples                                                                                                           | Supported Period       |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------|------------------------|
| **Add**                 | `add w/<WORD> t/<TRANSLATION> [wl/<WORD_LANGUAGE>] [tl/<TRANSLATION_LANGUAGE>]` <br> e.g., `add w/regarder t/look`         | Outside review session |
| **Delete**              | `delete <Index>`<br> e.g., `delete 1`                                                                                      | Outside review session |
| **Edit**                | `edit <INDEX> [w/<WORD>] [t/<TRANSLATION>] [wl/<WORD_LANGUAGE>] [tl/<TRANSLATION_LANGUAGE>]`<br> e.g., `edit 1 w/bye t/再见` | Outside review session |
| **Find**                | `find KEYWORD`<br> e.g., `find bye`                                                                                        | Outside review session |
| **List**                | `list`                                                                                                                     | Outside review session |
| **Review**              | `review`                                                                                                                   | Outside review session |
| **Start**               | `start`                                                                                                                    | Outside review session |
| **End**                 | `end`                                                                                                                      | Inside review session  |
| **Reveal**              | `reveal <INDEX>`                                                                                                           | Both                   |
| **Yes**                 | `yes`                                                                                                                      | Inside review session  |
| **No**                  | `no`                                                                                                                       | Inside review session  |
| **Learning Statistics** | `stats`                                                                                                                    | Outside review session |
| **Language**            | `language SPECIFIED_LANGUAGE`<br> e.g., `language French`                                                                  | Outside review session |
| **Load**                | `load <FILE_NAME>`<br> e.g., `load SampleData.xlsx`                                                                        | Outside review session |
| **Switch**              | `switch`                                                                                                                   | Both                   |
| **Help**                | `help`                                                                                                                     | Outside review session |
| **Exit**                | `exit`                                                                                                                     | Both                   |


--------------------------------------------------------------------------------------------------------------------

## Glossary

| Term                                  | Definition                                                                                                                                                                                                                                                                                                                      | 
| ------------------------------------- |---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **CLI**                               | A command line interface (CLI) is a text-based interface where you can input commands that interact with a computer's operating system.                                                                                                                                                                                         |
| **GUI**                               | A graphical user interface (GUI) is a digital interface in which a user interacts with graphical components such as icons, buttons, and menus.                                                                                                                                                                                  |
| **JSON (JavaScript Object Notation)** | JSON is a lightweight data format commonly used for representing structured data.                                                                                                                                                                                                                                               |
| **Level**                             | The level represents the proficiency with a specific flashcard. The higher the `Level` is, the higher the proficiency of the user with the word is.                                                                                                                                                                             |
| **Review Session**                    | A review session is a designated phase within the system where words requiring review are presented individually. Users can confirm their understanding or signal a need for further review.                                                                                                                                    |
| **Forgetting Curve**                  | The forgetting curve illustrates the decline in memory retention over time if information is not periodically reviewed or reinforced. It demonstrates a rapid loss of information shortly after learning, with the most significant decline in the initial hours or days. The rate of forgetting gradually decreases over time. |
