package com.monitor.entity.vo;

import com.monitor.entity.ResourceDetail;

/**
 * 插入视频时用于接收请求参数
 * @author ganzhigang
 * 时间：2017年5月10日 上午10:58:46
 */
public class ResourceParam extends ResourceDetail{

	private static final long serialVersionUID = -5786360069951931350L;

	private String vPath;
	private Integer mId;
	
	public ResourceParam(){
		
	}

	public String getvPath() {
		return vPath;
	}

	public void setvPath(String vPath) {
		this.vPath = vPath;
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result + ((vPath == null) ? 0 : vPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceParam other = (ResourceParam) obj;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		if (vPath == null) {
			if (other.vPath != null)
				return false;
		} else if (!vPath.equals(other.vPath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ResourceParam [vPath=" + vPath + ", mId=" + mId + "]";
	}
}
