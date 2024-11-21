package enums;

public enum Side {
	BLACK(0,"黑色"),WIHTE(1,"白色");
	private int code;
	private String desc;
	Side(int code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode(){
		return code;
	}
	public String getDesc(){
		return desc;
	}
}
