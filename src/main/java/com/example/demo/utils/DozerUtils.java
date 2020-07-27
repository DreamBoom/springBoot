package com.example.demo.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DozerUtils {
    static DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    public static <T>List<T> mapList(Collection sourceList,Class<T> destinationClass){
        List destinationList = Lists.newArrayList();
        for (Iterator i$=sourceList.iterator(); i$.hasNext();){
            Object sourceObject = i$.next();
            dozerBeanMapper.map(sourceObject,destinationClass);
            destinationList.add(sourceObject);
        }
        return destinationList;
    }
}