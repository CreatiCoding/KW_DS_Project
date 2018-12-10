package co.kr.creaticoding.creaticode.vo;

import java.sql.Timestamp;

public class CommentProblemVO {
	private Integer comment_idx;
	private Integer problem_idx;
	private String comment_content;
	private String writer_id;
	private Timestamp create_at;
	
	public Integer getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(Integer comment_idx) {
		this.comment_idx = comment_idx;
	}
	public Integer getProblem_idx() {
		return problem_idx;
	}
	public void setProblem_idx(Integer problem_idx) {
		this.problem_idx = problem_idx;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
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
