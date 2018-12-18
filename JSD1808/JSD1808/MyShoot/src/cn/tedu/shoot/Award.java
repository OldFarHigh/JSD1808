package cn.tedu.shoot;
/**奖励接口*/
public interface Award {
	public int Doubule_FIRE = 0;//火力值
	public int LIFE = 1;	//命
	
	/**获取奖励类型,返回值0或1*/
	public int getAwardType();
}
