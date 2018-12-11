package co.kr.creaticoding.creaticode.vo;

import java.sql.Timestamp;

public class ProblemVO {
	private Integer problem_idx;
	private String problem_title;
	private Integer difficulty;
	private Integer like_count;
	private Integer hate_count;
	private String contents;
	private String testcase;
	private String notes;
	private Integer accepted_count;
	private Integer submitted_count;
	private String writer_id;
	private Timestamp create_at;
	public Integer getProblem_idx() {
		return problem_idx;
	}
	public void setProblem_idx(Integer problem_idx) {
		this.problem_idx = problem_idx;
	}
	public String getProblem_title() {
		return problem_title;
	}
	public void setProblem_title(String problem_title) {
		this.problem_title = problem_title;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getLike_count() {
		return like_count;
	}
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}
	public Integer getHate_count() {
		return hate_count;
	}
	public void setHate_count(Integer hate_count) {
		this.hate_count = hate_count;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTestcase() {
		return testcase;
	}
	public void setTestcase(String testcase) {
		this.testcase = testcase;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getAccepted_count() {
		return accepted_count;
	}
	public void setAccepted_count(Integer accepted_count) {
		this.accepted_count = accepted_count;
	}
	public Integer getSubmitted_count() {
		return submitted_count;
	}
	public void setSubmitted_count(Integer submitted_count) {
		this.submitted_count = submitted_count;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Timestamp getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Timestamp create_at) {
		this.create_at = create_at;
	}
	
}

