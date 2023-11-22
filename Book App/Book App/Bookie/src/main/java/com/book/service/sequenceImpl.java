package com.book.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.book.model.DataSeq;

@Repository
public class sequenceImpl implements sequenceDao{

    private MongoOperations mongoOperations;

    @Autowired
    public sequenceImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long getNextSequenceId(String seqName) {

        DataSeq counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
          new Update().inc("seq",1), options().returnNew(true).upsert(true),
          DataSeq.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;

    }
}