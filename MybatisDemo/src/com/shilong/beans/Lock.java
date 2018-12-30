package com.shilong.beans;

public class Lock {

	private Integer id;
	private String lockName;
	private Key key;

	public Lock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lock(Integer id, String lockName, Key key) {
		super();
		this.id = id;
		this.lockName = lockName;
		this.key = key;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Lock [id=" + id + ", lockName=" + lockName + ", key=" + key + "]";
	}

}
