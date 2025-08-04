package com.library.Service;

import com.library.entities.IssuesRecords;

public interface IssuedBookServiceInterface {
	
	public IssuesRecords createIssueRecords(Long id);
	
    public IssuesRecords returnBooks(Long issuedId);
}
