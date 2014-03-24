/**
 * 
 */
package com.fan1tuan.life.business;

import java.util.List;
import com.fan1tuan.general.business.IFan1TuanService;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.life.pojos.ExpressClient;
import com.fan1tuan.life.pojos.ExpressOrder;

/**
 * @author JOE
 * 本地生活，快递板块
 *此处包含的 对ExpressOrder 和 ExpressClient的操作
 * User:饭团用户  Client：快递代取商
 */
public interface ExpressService extends IFan1TuanService{
	//添加新快递单
	public void addNewExpressOrder(ExpressOrder expressOrder);
	//根据手机号码 获取用户最近快递单[user]
	public List<ExpressOrder> getUserExpressOrders(String cellphone,Pageable pageable);
	//根据状态，时间获取订单[client]
	public List<ExpressOrder> getClientExpressOrders(int status,String date,Pageable pageable);
	//更新今天所有订单状态
	public void clientUpdateTodayOrderStatus(int status,String today);
	//根据orderId更新订单状态
	public void clientUpdateOrderStatus(int status,String orderId);
	//更新client信息
	public void updateClient(ExpressClient expressClient);
	//获取今天所有订单列表分页数量
	public long getTodayOrderCount(String date,int pageSize);
	//获取历史订单列表分页分页数量
	public long getHistoryOrderCount(int status,String date,int pageSize);
	
}
