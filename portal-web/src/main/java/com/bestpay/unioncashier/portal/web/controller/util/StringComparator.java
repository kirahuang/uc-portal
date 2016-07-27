package com.bestpay.unioncashier.portal.web.controller.util;

import java.util.Comparator;

/**
 * 比较器
 * Author: luwanchuan
 * Date: 2016/7/1
 */
public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}
