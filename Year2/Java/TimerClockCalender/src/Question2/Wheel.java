package Question2;

public abstract class Wheel<T> {
    private T value;

    public void setValue(T value) {//setter
        this.value = value;
    }
    public T getValue(){//getter
        return value;
    }

    public abstract void reset();

    public abstract Boolean isRolledOver();

}
