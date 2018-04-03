package com.java.demo05;

/**
 * 自定义链表类
 * 
 * @author jack w
 *
 */
public interface Link {
	
	/**
	 * 链表增加数据方法
	 * @param data
	 */
	public void add(Object data) ;
	
	/**
	 * 返回链表节点个数
	 * @return
	 */
	public int size();
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 返回链表的所有数据
	 * @return
	 */
	public Object[] toArray();
	
	/**
	 * 判断数据是否存在
	 * @param data
	 * @return
	 */
	public boolean contains(Object data);
	
	/**
	 * 根据索引获取数据
	 * @param index
	 * @return
	 */
	public Object get(int index);
	
	/**
	 * 修改索引的数据
	 * @param index
	 * @param newData
	 * @return
	 */
	public boolean set(int index , Object newData) ;
	
	/**
	 * 删除数据
	 * @param removeData
	 * @return
	 */
	public boolean remove(Object removeData);

}
