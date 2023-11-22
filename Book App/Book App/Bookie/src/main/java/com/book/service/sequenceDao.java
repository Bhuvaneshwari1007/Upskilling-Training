package com.book.service;

import com.book.exception.SequenceException;

public interface sequenceDao {
	long getNextSequenceId(String key) throws SequenceException;
}
