package Stack;

public class Stacks {
    int top = -1;
    char stackArray[];
    int stackArrayInt[];
    int size;

    public Stacks(int size) {
        this.size = size;
        stackArray = new char[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size-1;
    }

    void push(char data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = data;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArrayInt[++top] =  data;
    }

    public char pop() {
        if (isEmpty()) {
            return 'f';   // if -1 is a value in the stack then return -99999. something larger out of stack domain or
                         // return toString
        }
//        int tempTop = top;
//        top--;
        return stackArray[top--];
    }

    char peek() {
        return stackArray[top];
    }

    int size() {
        return top+1;
    }
}
