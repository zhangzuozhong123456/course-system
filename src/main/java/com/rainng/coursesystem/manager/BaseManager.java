package com.rainng.coursesystem.manager;
//最基本管理
public class BaseManager {
    //根据记录数，计算需要多少页
    protected int calcPageCount(int recordCount, int pageSize) {
        if (recordCount % pageSize == 0) {
            return recordCount / pageSize;
        }

        return (recordCount / pageSize) + 1;
    }
}
