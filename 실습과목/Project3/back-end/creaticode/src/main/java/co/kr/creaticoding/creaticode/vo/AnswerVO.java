package co.kr.creaticoding.creaticode.vo;

import java.sql.Timestamp;

public class AnswerVO {
	private Integer answer_idx;
	private Integer problem_idx;
	private String answer_code;
	private Boolean accepted;
	private String writer_id;
	private Timestamp create_at;
	
	public Integer getAnswer_idx() {
		return answer_idx;
	}
	public void setAnswer_idx(Integer answer_idx) {
		this.answer_idx = answer_idx;
	}
	public Integer getProblem_idx() {
		return problem_idx;
	}
	public void setProblem_idx(Integer problem_idx) {
		this.problem_idx = problem_idx;
	}
	public String getAnswer_code() {
		return answer_code;
	}
	public void setAnswer_code(String answer_code) {
		this.answer_code = answer_code;
	}
	public Boolean getAccepted() {
		return accepted;
	}
	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
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
