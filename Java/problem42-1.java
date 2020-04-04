class Solution {

    public int trap(int[] height) {
        int left = 0;
        int prev = 0;
        while (left < height.length) {
            if (height[left] >= prev) {
                prev = height[left++];
            }
            else {
                --left;
                break;
            }
        }
        if (left >= height.length - 2) {
            return 0;
        }
        // 保存各个峰的位置
        DoubleLinkList peaks = new DoubleLinkList();
        peaks.add(left);
        int right = left + 1;
        while (right < height.length) {
            right = left + 1;
            // 下坡到谷底
            while (right < height.length && height[right] <= height[right - 1]) {
                ++right;
            }
            if (right >= height.length) {
                break;
            }
            prev = height[right];
            // 上坡到峰顶
            while (right < height.length) {
                if (height[right] >= prev) {
                    if (right == height.length - 1) {
                        // 可以看做在最后一个位置后面还有一个0，所以只要最后一个比倒数第二高也算是个峰
                        peaks.add(right);
                        break;
                    }
                    prev = height[right++];
                }
                else {
                    peaks.add(--right);
                    break;
                }
            }
            left = right;
        }

        boolean hasRemove = true;
        while (hasRemove) {
            hasRemove = false;
            Node node = peaks.head.next, tail = peaks.tail;
            if (node == null) {
                return 0;
            }
            // 去掉在比两侧峰还低的峰，因为这样的峰必然会被水淹没
            while (node != tail) {
                if (height[node.value] <= height[node.prev.value] && height[node.value] <= height[node.next.value]) {
                    Node tmp = node.next;
                    node.remove();
                    node = tmp;
                    hasRemove = true;
                }
                else {
                    node = node.next;
                }
            }
        }
        Node leftNode = peaks.head, rightNode = peaks.head.next;
        int result = 0;
        while (rightNode != null) {
            int more = 0, minHeight = Math.min(height[leftNode.value], height[rightNode.value]);
            for (int i = leftNode.value + 1; i < rightNode.value; ++i) {
                more += Math.min(minHeight, height[i]);
            }
            result += (rightNode.value - leftNode.value - 1) * minHeight - more;
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return result;
    }
}

class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int v) {
        value = v;
        prev = null;
        next = null;
    }

    public void remove() {
        // 注意此题不会删除首尾节点，所以不用考虑null的情况
        prev.next = next;
        next.prev = prev;
    }
}

// 双向链表
class DoubleLinkList {
    public Node head;
    public Node tail;

    public DoubleLinkList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        if (head != null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else {
            head = node;
            tail = node;
        }
    }
}
