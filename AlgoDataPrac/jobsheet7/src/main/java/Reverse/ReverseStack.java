package Reverse;

public class ReverseStack {
    int size, top;
    char[] sentence;

    public ReverseStack(int size){
        this.size = size;
        sentence = new char[size];
        top = -1;
    }

    public boolean isFull(){
        return (top == size-1);
    }

    public void push(char c){
        if (!isFull()){
            top++;
            sentence[top] = c;
        } else {
            System.out.println("Stack is full");
        }
    }

    public void print(){
        System.out.println("Stack content: ");
        for (int i = top; i >= 0; i--){
            System.out.print(sentence[i]);
        }
        System.out.println();
    }
}
