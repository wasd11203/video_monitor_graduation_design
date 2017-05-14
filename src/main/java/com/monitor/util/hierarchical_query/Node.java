package com.monitor.util.hierarchical_query;

/**
 * 评论的 自定义 节点
 * @author ganzhigang
 * 时间：2017年4月28日 下午3:58:07
 */
public class Node {

	/**
	 * 评论_id
	 */
	private Integer commentId;
	/**
	 * 评论的对象_id
	 */
	private Integer targetId;
	/**
	 * 评论的内容
	 */
	private String commnet;
	/**
	 * 评论的发起人
	 */
	private Integer sponsorId;
	
	public Node(){
		
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getCommnet() {
		return commnet;
	}

	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}

	public Integer getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}
	
}
