public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T element){
        if (size < data.length){
            data[size] = element;
            size++;
        } else{
            throw new IllegalStateException("Stack is filled");
        }
    }

    public T pop(){
        if (size > 0){
            T element = data[size-1];
            size--;
            data[size] = null;
            return element;
        } else{
            throw new IllegalStateException("Stack in empty");
        }
    }

    public T peek() {
        if (size > 0){
            return data[size-1];
        } else{
            throw new IllegalStateException("Stack in empty");
        }
    }
}
