package com.amitph.java.collections.list;

import org.junit.Assert;

import java.util.List;

public class ListEqualityAsserter {
    private final List<Integer> list1 = List.of(10, 11, 12, 14);
    private final List<Integer> list2 = list1;
    private final List<Integer> list3 = List.of(10, 11, 12, 14);
    private final List<Integer> list4 = List.of(14, 12, 11, 10);

    public void usingEquals() {
        assert list1.equals(list2);
        assert list1 == list2;
        assert list1.equals(list3);
        assert list1 != list3;
        assert !list1.equals(list4);
    }

    public void usingJUnit() {
        Assert.assertEquals(list1, list2);
        Assert.assertSame(list1, list2);
        Assert.assertEquals(list1, list3);
        Assert.assertNotSame(list1, list3);
        Assert.assertNotEquals(list1, list4);
    }

    public void usingTestNG() {
        org.testng.Assert.assertEquals(list1, list2);
        org.testng.Assert.assertSame(list1, list2);
        org.testng.Assert.assertEquals(list1, list3);
        org.testng.Assert.assertNotSame(list1, list3);
        org.testng.Assert.assertNotEquals(list1, list4);
    }

    public void usingAssertJ() {
        org.assertj.core.api.Assertions.assertThat(list1)
                .isEqualTo(list2)
                .isSameAs(list2)
                .isEqualTo(list3)
                .isNotSameAs(list3)
                .isNotEqualTo(list4);
    }

    public static void main(String[] a) {
        ListEqualityAsserter asserter = new ListEqualityAsserter();

        asserter.usingEquals();
        asserter.usingJUnit();
        asserter.usingTestNG();
        asserter.usingAssertJ();
    }
}