import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.stream.Stream;

public class PassengerSupplier {

    private Deque<PassengerEntity> frequentFlyers;
    private Deque<PassengerEntity> regularFlyers;

    /**
     * A default constructor that initializes an empty queue.
     */
    public PassengerSupplier() {
        this.frequentFlyers = new ArrayDeque<>();
        this.regularFlyers = new ArrayDeque<>();
    }

    /**
     * A constructor to construct a PassengerSupplier based on the
     * PassengerEntities provided.
     * @param frequentFlyers the PassengerEntities that are frequent flyers.
     * @param regularFlyers the PassengerEntities that are regular flyers.
     */
    public PassengerSupplier(Stream<PassengerEntity> frequentFlyers,
                             Stream<PassengerEntity> regularFlyers) {
        Objects.requireNonNull(frequentFlyers);
        Objects.requireNonNull(regularFlyers);

        this.frequentFlyers = new ArrayDeque<>();
        this.regularFlyers = new ArrayDeque<>();

        frequentFlyers.forEach(passenger -> this.frequentFlyers.offer(passenger));
        regularFlyers.forEach(passenger -> this.regularFlyers.offer(passenger));
    }

    /**
     * A method to get the next passenger in line. The method
     * first attempts to get a passenger from the frequentFlyers
     * queue. If the frequentFlyers queue is empty, then a
     * passenger from the regularFlyers queue is returned. If
     * both queues are empty, then null is returned.
     * @return the next passenger in line or null if the line is empty.
     */
    public PassengerEntity getNextPassenger() {
        return (!this.frequentFlyers.isEmpty())
                ? this.frequentFlyers.poll()
                : this.regularFlyers.poll();
    }

    /**
     * A method to return whether this PassengerSupplier is emtpy.
     * @return true if both the frequentFlyers and regularFlyers queues are empty.
     */
    public boolean isEmpty() {
        return this.frequentFlyers.isEmpty() && this.regularFlyers.isEmpty();
    }

    /**
     * Peeks at the next PassengerEntity in line.
     * @return the next PassengerEntity in line without removing it.
     */
    public PassengerEntity peekNextPassenger() {
        return (!this.frequentFlyers.isEmpty())
                ? this.frequentFlyers.peek()
                : this.regularFlyers.peek();
    }
}