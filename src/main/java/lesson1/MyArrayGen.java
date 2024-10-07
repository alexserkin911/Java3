package lesson1;

public class MyArrayGen<T> {

    private Object[] data;
    private int size, capacity;

    public MyArrayGen() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public void add(T o) {
        validateCapacity();
        data[size] = o;
        size++;
    }

    public void remove(){
        size--;
    }

    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T) data[index];
    }

    public void set(int index, T o){
        data[index] = o;
    }

    private void validateCapacity() {
        if (size == capacity - 1) {
            capacity *= 2;
            Object[] tmp = new Object[capacity];
            if (size >= 0) {
                System.arraycopy(data,0, tmp, 0, size);
            }
            data = tmp;
        }
    }
}
