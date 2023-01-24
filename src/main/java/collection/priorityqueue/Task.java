package collection.priorityqueue;

public record Task(Position position,
                   String description,
                   int urgency) {
}
