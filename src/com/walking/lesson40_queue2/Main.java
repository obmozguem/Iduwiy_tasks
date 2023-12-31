package com.walking.lesson40_queue2;

import com.walking.lesson40_queue2.model.Task;
import com.walking.lesson40_queue2.service.TaskService;

/**
 * Реализуйте класс Задание. Он должен содержать поле Название,
 * состав остальных полей - на ваше усмотрение.
 * <p>
 * Реализуйте сервис, хранящий задания.
 * Он должен иметь методы для добавления заданий и их "выполнения".
 * Задания должны обрабатываться в порядке очереди.
 * Критерием выполнения задания будем считать выведение в консоль фразы
 * "Задание %название задания% выполнено!".
 * <p>
 * Также добавьте вывод сообщения в консоль о том,
 * что задание (с указанием названия) добавлено.
 */
public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();

        taskService.add(new Task("1"));
        taskService.add(new Task("2"));
        taskService.add(new Task("3"));

        taskService.complete();
        taskService.complete();

        taskService.add(new Task("4"));

        taskService.complete();
        taskService.complete();

        taskService.complete();
        taskService.complete();
    }
}
