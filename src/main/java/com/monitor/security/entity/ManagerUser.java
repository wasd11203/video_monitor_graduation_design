package com.monitor.security.entity;

import java.io.Serializable;

/**
 * 用于验证 时使用的管理者 类
 * @author ganzhigang
 * 时间：2017年5月10日 下午3:27:05
 */
public class ManagerUser implements Serializable{

	private static final long serialVersionUID = 3066687314205273119L;
	
	private Integer mId;
	private String mNickname;
	private String mPassword;
	
	public ManagerUser(){
		
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result + ((mNickname == null) ? 0 : mNickname.hashCode());
		result = prime * result + ((mPassword == null) ? 0 : mPassword.hashCode());
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
		ManagerUser other = (ManagerUser) obj;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		if (mNickname == null) {
			if (other.mNickname != null)
				return false;
		} else if (!mNickname.equals(other.mNickname))
			return false;
		if (mPassword == null) {
			if (other.mPassword != null)
				return false;
		} else if (!mPassword.equals(other.mPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerUser [mId=" + mId + ", mNickname=" + mNickname + ", mPassword=" + mPassword + "]";
	}
	
}
