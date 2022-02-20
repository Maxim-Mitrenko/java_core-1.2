public class Worker {

    final private OnTaskDoListener callback;
    final private OnTaskErrorListener error;

    @FunctionalInterface
    public interface OnTaskDoListener {
        void onDone(String work);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String message);
    }

    public Worker(OnTaskDoListener callback, OnTaskErrorListener error) {
        this.callback = callback;
        this.error = error;
    }

    public void start() {
        for (int i = 1; i < 100; i++) {
            if (i == 33) {
                error.onError("Во время выполнения работы " + i + " произошла ошибка!");
                continue;
            }
            callback.onDone("Работа " + i + " Выполнена.");
        }
    }
}