package co.kr.creaticoding.creaticode.vo;

import java.sql.Timestamp;

public class CommentAnswerVO {
	private Integer comment_idx;
	private Integer answer_idx;
	private String comment_content;
	private String writer_id;
	private Timestamp create_at;
	public Integer getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(Integer comment_idx) {
		this.comment_idx = comment_idx;
	}
	public Integer getAnswer_idx() {
		return answer_idx;
	}
	public void setAnswer_idx(Integer answer_idx) {
		this.answer_idx = answer_idx;
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

