package cc.janker.javaIntensively.concurrent;

import net.jcip.annotations.NotThreadSafe;

/**
 * Created by janker on 2017/7/27.
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
