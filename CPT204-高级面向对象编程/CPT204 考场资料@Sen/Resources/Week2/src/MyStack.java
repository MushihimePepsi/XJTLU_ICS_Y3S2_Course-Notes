import java.util.ArrayList;
public class MyStack extends ArrayList<Object> {
    // 检查栈是否为空
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // 获取栈的大小
    public int getSize() {
        return super.size();
    }

    // 返回栈顶元素
    public Object peek() {
        if (isEmpty()) return null;
        return super.get(getSize() - 1);
    }

    // 移除并返回栈顶元素
    public Object pop() {
        if (isEmpty()) return null;
        return super.remove(getSize() - 1);
    }

    // 向栈中添加元素
    public void push(Object o) {
        super.add(o);
    }

    // 查找元素在栈中的位置
    public int search(Object o) {
        return super.lastIndexOf(o);
    }

    // 返回栈的字符串表示
    public String toString() {
        return "stack: " + super.toString();
    }
}

