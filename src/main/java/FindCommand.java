public class FindCommand extends Command{

    FindCommand(String str) {
        super(str);
    }

    public void execute(TaskList list, Ui ui, Storage storage) {
        String keyword = str.split(" ")[1];
        TaskList newList = new TaskList();
        for (Task t : list.getList()) {
            int index = t.toString().indexOf(keyword);

            if (index != -1) {
                newList.addTask(t);
            }
        }
        ui.showMatchingTask(newList);
    }
}
