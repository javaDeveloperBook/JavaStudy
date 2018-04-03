package com.java.demo05;

/**
 * 自定义链表的实现类
 * 
 * @author jack w
 *
 */
public class MyLink implements Link {
	
	/*****************Node內部类开始*******************/
	class Node {
		private Object data ;
		private Node next;
		
		public Node(Object data) {
			this.data = data;
		}

		/**
		 * 递归增加节点数据的方法 
		 */
		public void add(Node newNode) {
			if (this.next == null) {
				this.next = newNode;
			}else {
				this.next.add(newNode);
			}
		}
		
		/**
		 * 递归获取当前节点数据放入对象数组中
		 */
		public void toArrayNode() {
			MyLink.this.datas[MyLink.this.foot++] = this.data;
			if (this.next != null) {
				this.next.toArrayNode();
			}
		}
		
		/**
		 * 递归判断当前数据是否包含在链表中
		 * @param data
		 * @return
		 */
		public boolean containsNode(Object search) {
			if (search.equals(this.data)) {
				return true ;
			}else {
				if (this.next != null) {
					return this.next.containsNode(search);
				}else {
					return false;
				}
			}
		}
		
		/**
		 * 根据索引获取数据
		 * @return
		 */
		public Object getNode(int index) {
			if (MyLink.this.foot ++ == index) {
				return this.data ;
			}else {
				return this.next.getNode(index);
			}
		}
		
		public boolean setNode(int index , Object newData){
			if (MyLink.this.foot++ == index) {
				this.data = newData;
				return true;
			}else {
				if (this.next != null) {
					return this.next.setNode(index, newData);
				}else {
					return false;
				}
			}
		}
		
		public boolean removeNode(Node pro , Object removeData) {
			if (removeData.equals(this.data)) {
				pro.next = this.next ;
				MyLink.this.count -- ;
				return true;
			}else {
				if (this.next != null) {
					return this.next.removeNode(this,removeData);
				}else {
					return false;
				}
			}
		}
	}
	/*****************Node內部类结束*******************/
	
	/**
	 * 存放根节点
	 */
	private Node root;
	
	/**
	 * 链表大小
	 */
	private int count = 0;
	
	/**
	 * 链表的对象数组
	 */
	private Object[] datas ;
	
	/**
	 * 链表对象数组下标
	 */
	private int foot = 0 ;
	
	@Override
	public void add(Object data) {
		//若data数据为null,则结束程序
		if (data == null) {
			return ;
		}
		//包装数据到Node节点中
		Node newNode = new Node(data);
		//若根节点为空，则直接保存在根节点；否则就调用Node节点本身增加节点的方法（递归操作）
		if (this.root == null) {
			this.root = newNode;
		}else {
			this.root.add(newNode);
		}
		//记录节点个数
		count += 1;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Object[] toArray() {
		if (this.count == 0) {
			return null;
		}
		//重置对象数组下标
		this.datas = new Object[this.count];
		this.foot = 0;
		this.root.toArrayNode();
		return datas;
	}

	@Override
	public boolean isEmpty() {
		return this.root==null && this.count == 0;
	}

	@Override
	public boolean contains(Object search) {
		if (search == null || this.root == null) {
			return false ;
		}
		return this.root.containsNode(search);
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index > count-1) {
			throw new IndexOutOfBoundsException();
		}
		if (this.root == null) {
			return null;
		}
		//置0脚标，判断索引index和脚标相等并返回
		this.foot = 0;
		return this.root.getNode(index);
	}

	@Override
	public boolean set(int index, Object newData) {
		if (index < 0 || index > this.count - 1) {
			throw new IndexOutOfBoundsException();
		}
		if (this.root == null) {
			return false;
		}
		this.foot = 0 ;
		return this.root.setNode(index,newData);
	}

	@Override
	public boolean remove(Object removeData) {
		if (removeData == null) {
			return false;
		}
		if (this.root == null) {
			return false;
		}
		
		if (removeData.equals(this.root.data)) {
			this.root = this.root.next;
			this.count --;
			return true ;
		}else {
			return this.root.next.removeNode(this.root,removeData);
		}
	}
	
	
	
}
