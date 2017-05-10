package com.monitor.entity;

import java.io.Serializable;

/**
 * 管理者---详细信息 Entity
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:33:12
 *
 */
public class ManagerUserDetail implements Serializable{
	
	private static final long serialVersionUID = -3853089283660508078L;
	private Integer mId;
	private String mNickname;
	private String mName;
	private String mPhone;
	private String mPassword;
	private String mPic;
	
	public ManagerUserDetail(){
		
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

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((mNickname == null) ? 0 : mNickname.hashCode());
		result = prime * result + ((mPassword == null) ? 0 : mPassword.hashCode());
		result = prime * result + ((mPhone == null) ? 0 : mPhone.hashCode());
		result = prime * result + ((mPic == null) ? 0 : mPic.hashCode());
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
		ManagerUserDetail other = (ManagerUserDetail) obj;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
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
		if (mPhone == null) {
			if (other.mPhone != null)
				return false;
		} else if (!mPhone.equals(other.mPhone))
			return false;
		if (mPic == null) {
			if (other.mPic != null)
				return false;
		} else if (!mPic.equals(other.mPic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerUserDetail [mId=" + mId + ", mNickname=" + mNickname + ", mName=" + mName + ", mPhone=" + mPhone
				+ ", mPassword=" + mPassword + ", mPic=" + mPic + "]";
	}
}
