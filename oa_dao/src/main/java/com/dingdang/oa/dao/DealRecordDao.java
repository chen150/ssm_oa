package com.dingdang.oa.dao;

import com.dingdang.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRecordDao {

    void insert(DealRecord dealRecord);

    List<DealRecord> selectByClaimVoucher(int cvid);
}
