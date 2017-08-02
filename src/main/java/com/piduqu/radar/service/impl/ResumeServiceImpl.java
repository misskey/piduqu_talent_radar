package com.piduqu.radar.service.impl;

import com.piduqu.radar.entity.mongo.TalentResume;
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
    public <S extends TalentResume> List<S> save(Iterable<S> iterable) {
        return save(iterable);
    }

    @Override
    public <S extends TalentResume> S save(S s) {
        return save(s);
    }

    @Override
    public TalentResume findOne(Long aLong) {
        return findOne(aLong);
    }

    @Override
    public boolean exists(Long aLong) {
        return exists(aLong);
    }

    @Override
    public List<TalentResume> findAll() {
        return null;
    }

    @Override
    public Iterable<TalentResume> findAll(Iterable<Long> iterable) {
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
    public void delete(TalentResume talent_resume) {

    }

    @Override
    public void delete(Iterable<? extends TalentResume> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TalentResume> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TalentResume> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TalentResume> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TalentResume> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TalentResume> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends TalentResume> S insert(S s) {
        return null;
    }

    @Override
    public <S extends TalentResume> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TalentResume> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TalentResume> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TalentResume> boolean exists(Example<S> example) {
        return false;
    }
}
