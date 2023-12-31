package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию о среднем возрасте сотрудников компании.
 */
public class Task13 implements StatisticTask<Double> {
    @Override
    public Double calculate(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .collect(Collectors.averagingInt(Employee::getAge));
    }
}
