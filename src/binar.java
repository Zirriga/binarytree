import jdk.nashorn.internal.runtime.regexp.joni.ast.AnyCharNode;
import org.omg.CORBA.Any;

import java.util.ArrayList;

public class binar<t1 extends Comparable<t1>, t2> {
    static class Node<t1, t2> {
        t1 key;
        t2 value;
        Node<t1, t2> left, right;

        Node(t1 key, t2 value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<t1, t2> root = null;

    public boolean ContainsKey(t1 k) {
        Node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return true;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return false;
    }

    public t2 Get(t1 k) {
        Node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return x.value;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public void Add(t1 k, t2 v) {
        Node<t1, t2> x = root, y = null;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                x.value = v;
                return;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        Node<t1, t2> newNode = new Node<>(k, v);
        if (y == null) {
            root = newNode;
        } else {
            if (k.compareTo(y.key) < 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }

    }

    public void Remove(t1 k) {
        Node<t1, t2> x = root, y = null;
        while (x != null) {
            int comp = k.compareTo(x.key);
            if (comp == 0) {
                break;
            } else {
                y = x;
                if (comp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        if (x == null) {
            return;
        }
        if (x.right == null) {
            if (y == null) {
                root = x.left;
            } else {
                if (x == y.left) {
                    y.left = x.left;
                } else {
                    y.right = x.left;
                }
            }
        } else {
            Node<t1, t2> leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) {
                y.left = leftMost.right;
            } else {
                x.right = leftMost.right;
            }
            x.key = leftMost.key;
            x.value = leftMost.value;
        }
    }

    public t2 GetParent(t1 k) {
        Node<t1, t2> x = root;
        t2 y = null;
        while ((x != null)) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                if (y != null) {
                    return y;
                } else return null;
            } else {
                if (cmp < 0) {
                    y = x.value;
                    x = x.left;
                } else {
                    y = x.value;
                    x = x.right;
                }
            }
        }
        return null;
    }

    public t2 GetRightChild(t1 k) {
        Node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                if (x.right != null) {
                    return x.right.value;
                } else {
                    return null;
                }
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }

    public t2 GetLeftChild(t1 k) {
        Node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                if (x.left != null) {
                    return x.left.value;
                } else {
                    return null;
                }
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }
}
