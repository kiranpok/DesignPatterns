package Assignment11_Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoHistory; // Memento Undo history
    private List<IMemento> redoHistory; // Memento Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToUndoHistory();
        model.setOption(optionNumber, choice);

        redoHistory.clear();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToUndoHistory();
        model.setIsSelected(isSelected);

        redoHistory.clear();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            if (redoHistory.isEmpty()) {
                saveToRedoHistory();
            }

            System.out.println("Undo");
            IMemento previousState = undoHistory.remove(undoHistory.size() - 1);

            redoHistory.add(previousState);

            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (redoHistory.size() > 1) {
            System.out.println("Redo");

            undoHistory.add(redoHistory.remove(redoHistory.size() - 1));

            model.restoreState(redoHistory.get(redoHistory.size() - 1));
            gui.updateGui();
        }
    }

    private void saveToUndoHistory() {
        IMemento currentState = model.createMemento();
        undoHistory.add(currentState);
    }

    private void saveToRedoHistory() {
        IMemento currentState = model.createMemento();
        redoHistory.add(currentState);
    }

    public List<IMemento> getHistoryList() {
        List<IMemento> historyList = Stream.concat(undoHistory.stream(), redoHistory.stream()).toList();

        return historyList;
    }

    public void restoreState(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }
}