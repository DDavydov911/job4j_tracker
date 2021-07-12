package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        int taskPriority = task.getPriority();
        for (Task element : tasks) {
            if (tasks.size() == 0) {
                break;
            }
            if (taskPriority > element.getPriority()) {
                index++;
            }
            if (taskPriority < element.getPriority()) {
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
