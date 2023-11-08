package org.example;

import java.util.*;

public class TaskRepository {
    private final List<Task> _tasks = new ArrayList<>();
    private final Comparator<Task> _priorityComparator = new PriorityComparator();
    int nextId = 0;

    public int addTask(String description, StatusEnum status, PriorityEnum priority, Date deadline, String category) {
        _tasks.add(new Task(nextId, description, status, priority, deadline, category));
        return nextId++;
    }

    public Collection<Task> getTasks() {
        return _tasks.stream().sorted(_priorityComparator).toList();
    }

    public boolean markTaskAsComplete(Integer id) {
        Optional<Task> foundTask = findTask(id);
        if (foundTask.isPresent()) {
            if (foundTask.get().getStatus() != StatusEnum.Completed) {
                foundTask.get().setStatus(StatusEnum.Completed);
                return true;
            }
        }

        return false;
    }

    public boolean removeCompletedTasks() {
        return _tasks.removeIf(task -> task.getStatus() == StatusEnum.Completed);
    }

    private Optional<Task> findTask(Integer id) {
        return _tasks.stream().filter(task -> task.getUniqueID() == id).findFirst();
    }
}
