package ru.siksmfp.basic.structure.cloning;

import org.junit.Test;
import ru.siksmfp.basic.structure.utils.cloning.Cloner;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class CloneInnerAnonTest {
    class TestInner {
        public Object o = new Object();

        public CloneInnerAnonTest parent = CloneInnerAnonTest.this;

        public CloneInnerAnonTest getParent() {
            return CloneInnerAnonTest.this;
        }
    }

    @Test
    public void dontCloneParentOfInnerClassesPositive() {

        final Cloner cl = new Cloner();
        cl.setCloneAnonymousParent(false);

        final TestInner test = new TestInner();
        final TestInner testCloned = cl.deepClone(test);
        assertNotSame(this, testCloned.parent);
        assertNotSame(test.o, testCloned.o);
        assertSame(test.getParent(), testCloned.getParent());
    }

    @Test
    public void dontCloneParentOfInnerClassesNegative() {

        final Cloner cl = new Cloner();
        cl.setCloneAnonymousParent(true);

        final TestInner test = new TestInner();
        final TestInner testCloned = cl.deepClone(test);
        assertNotSame(this, testCloned.parent);
        assertNotSame(test.o, testCloned.o);
        assertNotSame(test.getParent(), testCloned.getParent());
    }
}