package blackBoxTesting.common;

public class ConsoleOutput {
    private static final String VALID_SCHEDULED_MEETING_OUTPUT = "\n" +
            "Enter the month of the meeting (1-12): \n" +
            "\n" +
            "Enter the day of the meeting (1-31): \n" +
            "\n" +
            "Enter the starting hour of the meeting (0-23): \n" +
            "\n" +
            "Enter the ending hour of the meeting (0-23): \n" +
            "The rooms open at that time are:\n" +
            "JO18.330\n" +
            "JO7.221\n" +
            "JO15.236\n" +
            "JO1.230\n" +
            "JO34.536\n" +
            "JO19.230\n" +
            "ML5.123\n" +
            "ML18.330\n" +
            "ML21.520\n" +
            "ML13.213\n" +
            "ML21.310\n" +
            "ML13.218\n" +
            "\n" +
            "Enter the desired room ID, or cancel to cancel: \n" +
            "The people available to attend at that time are:\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin\n" +
            "\n" +
            "Enter a person's name, or done if finished: \n" +
            "\n" +
            "Enter a person's name, or done if finished: \n" +
            "\n" +
            "Enter a description for the meeting: \n" +
            "\n" +
            "\n";

    private static final String VALID_BOOK_VACATIONS_OUTPUT = "\n" +
            "Enter the month that the vacation starts (1-12): \n" +
            "\n" +
            "Enter the day the vacation starts (1-31): \n" +
            "\n" +
            "Enter the month that the vacation ends (1-12): \n" +
            "\n" +
            "Enter the day the vacation ends (1-31): \n" +
            "Which person will be taking the vacation:\n" +
            "Justin Gardener\n" +
            "Ashley Matthews\n" +
            "Mary Jane Cook\n" +
            "Rose Austin\n" +
            "Mike Smith\n" +
            "Helen West\n" +
            "Steven Lewis\n" +
            "Edith Cowan\n" +
            "Mark Colin\n" +
            "Jacquie Martin\n" +
            "Jaci Johnston\n" +
            "Travis Colin\n" +
            "Ashley Martin\n" +
            "\n" +
            "Enter a person's name, or cancel to cancel the request: \n" +
            "\n" +
            "\n";

    //TODO: Check if these are needed by the others if not I will remove 🚀🚀🚀🚀
    private static final String VALID_CHECK_ROOM_OUTPUT = "";
    private static final String VALID_CHECK_PERSON_OUTPUT = "";
    private static final String VALID_CHECK_AGENDA_FOR_ROOM_OUTPUT = "";
    private static final String VALID_CHECK_AGENDA_FOR_PERSON_OUTPUT = "";

    public static String getValidScheduledMeetingOutput() {
        return VALID_SCHEDULED_MEETING_OUTPUT;
    }

    public static String getValidVacationsOutput() {
        return VALID_BOOK_VACATIONS_OUTPUT;
    }

    public static String getValidCheckRoomOutput() {
        return VALID_CHECK_ROOM_OUTPUT;
    }

    public static String getValidCheckPersonOutput() {
        return VALID_CHECK_PERSON_OUTPUT;
    }

    public static String getValidCheckAgendaForRoomOutput() {
        return VALID_CHECK_AGENDA_FOR_ROOM_OUTPUT;
    }

    public static String getValidCheckAgendaForPersonOutput() {
        return VALID_CHECK_AGENDA_FOR_PERSON_OUTPUT;
    }
}
