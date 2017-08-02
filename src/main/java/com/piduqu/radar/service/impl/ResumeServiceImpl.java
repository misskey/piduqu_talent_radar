package com.piduqu.radar.service.impl;

import com.piduqu.radar.entity.mongo.Talent_Resume;
import com.piduqu.radar.service.IResumeService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangxue on 2017/7/27.
 * Cell:15884457479
 * Email:zhangyun.liu@hirebigdata.cn
 * Description:
 * <p/>
 * Functions:
 * 1.
 */
@Service("resume")
public class ResumeServiceImpl implements IResumeService {


    @Override
    public <S extends Talent_Resume> List<S> save(Iterable<S> iterable) {
        return save(iterable);
    }

    @Override
    public <S extends Talent_Resume> S save(S s) {
        return save(s);
    }

    @Override
    public Talent_Resume findOne(Long aLong) {
        return findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return exists(aLong);
    }

    @Override
    public List<Talent_Resume> findAll() {
        return null;
    }

    @Override
    public Iterable<Talent_Resume> findAll(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Talent_Resume talent_resume) {

    }

    @Override
    public void delete(Iterable<? extends Talent_Resume> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Talent_Resume> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Talent_Resume> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Talent_Resume> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Talent_Resume> boolean exists(Example<S> example) {
        return false;
    }
}
