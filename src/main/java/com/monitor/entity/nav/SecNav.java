package com.monitor.entity.nav;

import java.io.Serializable;

/**
 * 二级导航 实体
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午10:47:34
 *
 */
public class SecNav implements Serializable{

	private static final long serialVersionUID = 6005259412851047303L;
	
	/**
	 * 二级菜单id
	 */
	private Integer vSecId;
	/**
	 * 二级菜单名称
	 */
	private String vSecName;
	
	public SecNav(){
		
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
		result = prime * result + ((vSecId == null) ? 0 : vSecId.hashCode());
		result = prime * result + ((vSecName == null) ? 0 : vSecName.hashCode());
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
		SecNav other = (SecNav) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "SecNav [vSecId=" + vSecId + ", vSecName=" + vSecName + "]";
	}
}
