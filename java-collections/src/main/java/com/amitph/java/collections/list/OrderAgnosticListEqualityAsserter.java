package com.amitph.java.collections.list;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class OrderAgnosticListEqualityAsserter {
    private final List<Integer> list1 = List.of(11, 12, 13, 14, 16);
    private final List<Integer> list2 = List.of(14, 13, 12, 16, 11);
    private final List<Integer> list3 = List.of(11, 12, 13, 14, 16, 12);

    public void usingTestNG() {
        Assert.assertTrue(
                list1.size() == list2.size()
                        && list1.containsAll(list2)
                        && list2.containsAll(list1));

        Assert.assertFalse(
                list1.size() == list3.size()
                        && list1.containsAll(list3)
                        && list3.containsAll(list1));
    }

    public void usingJUnit() {
        org.junit.Assert.assertTrue(
                list1.size() == list2.size()
                        && list1.containsAll(list2)
                        && list2.containsAll(list1));

        org.junit.Assert.assertFalse(
                list1.size() == list3.size()
                        && list1.containsAll(list3)
                        && list3.containsAll(list1));
    }

    public void usingAssertJ() {
        Assertions.assertThat(list1).containsExactlyInAnyOrderElementsOf(list2);
        Assertions.assertThat(list1).hasSameElementsAs(list3);
    }

    public void usingHamcrest() {
        MatcherAssert.assertThat(list2, Matchers.containsInAnyOrder(list2.toArray()));
    }

    public void usingApacheCommons() {
        Assert.assertTrue(CollectionUtils.isEqualCollection(list1, list2));
        Assert.assertFalse(CollectionUtils.isEqualCollection(list1, list3));
    }

    public static void main(String[] a) {
        OrderAgnosticListEqualityAsserter asserter = new OrderAgnosticListEqualityAsserter();

        asserter.usingTestNG();
        asserter.usingJUnit();
        asserter.usingAssertJ();
        asserter.usingHamcrest();
        asserter.usingApacheCommons();
    }
}
