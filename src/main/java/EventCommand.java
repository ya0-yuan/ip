import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventCommand extends Command{

    EventCommand(String str) {
        super(str);
    }

    public static String getLocalDate(String time) {
        LocalDate d = LocalDate.parse(time);
        return d.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    public void execute(TaskList list, Ui ui, Storage storage) {
        try {
            String string = str.substring(6);
            String description = string.split(" /at ")[0]; // split the stirng by "/by ", take first half
            String time = string.split(" /at ")[1];
            String date = getLocalDate(time);
            Task newTask = new Event(description, date);
            list.getList().add(newTask);
            ui.printAddTask(newTask, list.getList().size());
        } catch (IndexOutOfBoundsException e) {
            ui.printNoDateEvent();
        } catch (DateTimeParseException e) {
            ui.printInvalidDate();
        }
    }
}
