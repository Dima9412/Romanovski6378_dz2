interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void releaseFromQueue();
}