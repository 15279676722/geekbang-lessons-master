package org.geekbang.thinking.in.spring.ioc.overview.domain;

import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.support.ManagedList;

import java.util.ArrayList;

public class MyMergeListType<E> extends ManagedList<E> {
    @Override
    public boolean isMergeEnabled() {
        return true;
    }

}
