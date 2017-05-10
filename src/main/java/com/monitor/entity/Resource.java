package com.monitor.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源 ----基本信息 Entity
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:27:33
 *
 */
public class Resource implements Serializable{

	private static final long serialVersionUID = 321970315889987900L;

	/**
	 * 视频id
	 */
	private Integer vId;

	/**
	 * 视频标题
	 */
	private String vTitle;
	
	/**
	 * 视频名称
	 */
	private String vName;
	
	/**
	 * 视频显示图片
	 */
	private String vPic;
	
	/**
	 * 视频介绍
	 */
	private String vIntroduce;
	
	/**
	 * 视频入库时间
	 */
	private Date inTime;
	
	/**
	 * 删除标识
	 */
	private Integer isDel;
	
	/**
	 * 禁止评论标识
	 */
	private Integer disComment;
	
	/**
	 * 视频所属的一级分类Id
	 */
	private Integer vTopId;
	/**
	 * 视频所属的一级分类名称
	 */
	private String vTopName;
	
	/**
	 * 视频所属的二级分类id
	 */
	private Integer vSecId;
	/**
	 * 视频所属的二级分类名称
	 */
	private String vSecName;
	
	public Resource(){
		
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvPic() {
		return vPic;
	}

	public void setvPic(String vPic) {
		this.vPic = vPic;
	}

	public String getvIntroduce() {
		return vIntroduce;
	}

	public void setvIntroduce(String vIntroduce) {
		this.vIntroduce = vIntroduce;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getDisComment() {
		return disComment;
	}

	public void setDisComment(Integer disComment) {
		this.disComment = disComment;
	}

	public Integer getvTopId() {
		return vTopId;
	}

	public void setvTopId(Integer vTopId) {
		this.vTopId = vTopId;
	}

	public String getvTopName() {
		return vTopName;
	}

	public void setvTopName(String vTopName) {
		this.vTopName = vTopName;
	}

	public Integer getvSecId() {
		return vSecId;
	}

	public void setvSecId(Integer vSecId) {
		this.vSecId = vSecId;
	}

	public String getvSecName() {
		return vSecName;
	}

	public void setvSecName(String vSecName) {
		this.vSecName = vSecName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disComment == null) ? 0 : disComment.hashCode());
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result + ((isDel == null) ? 0 : isDel.hashCode());
		result = prime * result + ((vId == null) ? 0 : vId.hashCode());
		result = prime * result + ((vIntroduce == null) ? 0 : vIntroduce.hashCode());
		result = prime * result + ((vName == null) ? 0 : vName.hashCode());
		result = prime * result + ((vPic == null) ? 0 : vPic.hashCode());
		result = prime * result + ((vSecId == null) ? 0 : vSecId.hashCode());
		result = prime * result + ((vSecName == null) ? 0 : vSecName.hashCode());
		result = prime * result + ((vTitle == null) ? 0 : vTitle.hashCode());
		result = prime * result + ((vTopId == null) ? 0 : vTopId.hashCode());
		result = prime * result + ((vTopName == null) ? 0 : vTopName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (disComment == null) {
			if (other.disComment != null)
				return false;
		} else if (!disComment.equals(other.disComment))
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (vId == null) {
			if (other.vId != null)
				return false;
		} else if (!vId.equals(other.vId))
			return false;
		if (vIntroduce == null) {
			if (other.vIntroduce != null)
				return false;
		} else if (!vIntroduce.equals(other.vIntroduce))
			return false;
		if (vName == null) {
			if (other.vName != null)
				return false;
		} else if (!vName.equals(other.vName))
			return false;
		if (vPic == null) {
			if (other.vPic != null)
				return false;
		} else if (!vPic.equals(other.vPic))
			return false;
		if (vSecId == null) {
			if (other.vSecId != null)
				return false;
		} else if (!vSecId.equals(other.vSecId))
			return false;
		if (vSecName == null) {
			if (other.vSecName != null)
				return false;
		} else if (!vSecName.equals(other.vSecName))
			return false;
		if (vTitle == null) {
			if (other.vTitle != null)
				return false;
		} else if (!vTitle.equals(other.vTitle))
			return false;
		if (vTopId == null) {
			if (other.vTopId != null)
				return false;
		} else if (!vTopId.equals(other.vTopId))
			return false;
		if (vTopName == null) {
			if (other.vTopName != null)
				return false;
		} else if (!vTopName.equals(other.vTopName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resource [vId=" + vId + ", vTitle=" + vTitle + ", vName=" + vName + ", vPic=" + vPic + ", vIntroduce="
				+ vIntroduce + ", inTime=" + inTime + ", isDel=" + isDel + ", disComment=" + disComment + ", vTopId="
				+ vTopId + ", vTopName=" + vTopName + ", vSecId=" + vSecId + ", vSecName=" + vSecName + "]";
	}
	
}
