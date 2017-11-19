package com.teamwork.interf;

import java.util.List;

public interface IService<T> {

    /**
     *更新
     * @param
     */
    public T update(T t) throws Exception;

    /**
     *根据ID删除
     * @param id
     */
    public boolean deleteById(Long id)throws Exception;


    /**
     * 根据ID查找
     *
     * @param id
     * @return
     */
    public T findById(String id) throws Exception;

    /**
     * 新增用户
     * @param user
     */
    public T add(T user) throws Exception;

    /**
     * find all
     * @param
     * @return
     */
    public List<T> findAllByOffset(long start, long end) throws Exception;

}
