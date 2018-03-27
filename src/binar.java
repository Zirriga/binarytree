import jdk.nashorn.internal.runtime.regexp.joni.ast.AnyCharNode;
import org.omg.CORBA.Any;

import java.util.ArrayList;

public class binar<t1 extends Comparable<t1>, t2> {
    static class node<t1, t2> {
        t1 key;
        t2 value;
        node<t1, t2> left, right, parent;

        node(t1 key, t2 value) {
            this.key = key;
            this.value = value;
        }
    }

    private node<t1, t2> root = null;

    public boolean containsKey(t1 k) {
        node<t1, t2> x = root;
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

    public t2 get(t1 k) {
        node<t1, t2> x = root;
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

    public void add(t1 k, t2 v) {
        node<t1, t2> x = root, y = null;
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
        node<t1, t2> newNode = new node<>(k, v);
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

    public void remove(t1 k) {
        node<t1, t2> x = root, y = null;
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
            node<t1, t2> leftMost = x.right;
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
    public t2 getParent(t1 k) {
        node<t1, t2> x = root, y = null;
        while ((x.right != null)|(x.left != null)) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return y.value;
            }
            if (cmp < 0) {
                x = x.left;
                y = x;
            } else {
                x = x.right;
                y = x;
            }
        }
        return null;
    }
    public t2 getRightChild(t1 k) {
        node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                x = x.right;
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
    public t2 getLeftChild(t1 k) {
        node<t1, t2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                x = x.left;
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
}
